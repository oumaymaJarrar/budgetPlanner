package com.app_proxy.budgetplanner.Config;

import com.app_proxy.budgetplanner.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig  {
    private final UserRepository userRepository;

    //Loads user-specific data during authentication. It's responsible for retrieving
    // user details (including roles/authorities) from the database.
//    public ApplicationConfiguration(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//    @Bean
//    UserDetailsService userDetailsService(UserRepository userRepository) {
//        return username -> userRepository.findByEmail(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//    }
//
//    @Bean
//    BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }


//    @Bean
//    AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//
//        authProvider.setUserDetailsService(userDetailsService(userRepository));
//        authProvider.setPasswordEncoder(passwordEncoder());
//
//        return authProvider;
//    }

}
