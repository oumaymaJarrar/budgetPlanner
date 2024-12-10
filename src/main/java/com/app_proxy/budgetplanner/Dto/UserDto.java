package com.app_proxy.budgetplanner.Dto;

import com.app_proxy.budgetplanner.Entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    @NotBlank(message = "email is required")
    @Email
    private String email;
    private Long age;
    @NotBlank(message = "password is required")
    private String password;
    private Instant createdAt;
    private Instant updatedAt;
//    public static UserDto makeUser(User user){
//        return  UserDto.builder()
//                .id(user.getId())
//                .firstName(user.getName())
//                .lastName(user.getLastName())
//                .email(user.getEmail())
//                .age(user.getAge())
//                .createdAt(user.getCreatedAt())
//                .updatedAt(user.getUpdatedAt())
//                .build();
//    }
}
