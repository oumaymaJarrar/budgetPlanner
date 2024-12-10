package com.app_proxy.budgetplanner.Config;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{
    // It wil be a filter for once request
    private final JwtService jwtService; // Service pour gérer les JWT (JSON Web Tokens)
    private  UserDetailsService userDetailsService; // Service pour charger les détails d'un utilisateur par son nom d'utilisateur
    private final HandlerExceptionResolver handlerExceptionResolver;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        try {
            final String jwt = authHeader.substring(7);
            final String userEmail = jwtService.extractUsername(jwt);

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if (userEmail != null && authentication == null) {
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);

                if (jwtService.isTokenValid(jwt, userDetails)) {
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    );

                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }

            filterChain.doFilter(request, response);
        } catch (Exception exception) {
            handlerExceptionResolver.resolveException(request, response, null, exception);
        }
    }
//    @Override
//    protected void doFilterInternal(
//            // it will intercept every Request and every Response
//           @NonNull HttpServletRequest request,
//           @NonNull HttpServletResponse response,
//           //contiene the list of filter we need to execute
//           @NonNull FilterChain filterChain
//    ) throws ServletException, IOException {
//        //used to extracte the header of the token from the request with name Authorization
//    final String authHeader = request.getHeader("Authorization");
//    final String jwt;
//    final String userEmail;
//    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
//        filterChain.doFilter(request, response);
//        return;
//    }
//    // Supprime le préfixe "Bearer " pour obtenir le token JWT pur
//    jwt = authHeader.substring(7);
//    //Extract the userEmail from jwt token
//    userEmail = jwtService.extractUsername(jwt);
//    // we chek if the user is authenticate or no
//        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//        // cheak if the user exist in the data base or no
//        UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
//        //cheak if the token if valide or no
//        if(jwtService.isTokenValid(jwt, userDetails)) {
//            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
//                    userDetails, null, userDetails.getAuthorities()
//            );
//            authToken.setDetails(
//                    new WebAuthenticationDetailsSource().buildDetails(request)
//            );
//            SecurityContextHolder.getContext().setAuthentication(authToken);
//        }
//    }
//    filterChain.doFilter(request, response);
//    }
    @PostConstruct
    public void init() {
        this.userDetailsService = userDetailsService; // Set the dependency after bean creation
    }


}
