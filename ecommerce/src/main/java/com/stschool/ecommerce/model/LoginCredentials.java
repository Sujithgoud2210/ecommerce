package com.stschool.ecommerce.model;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginCredentials {
    private String email;
    private String password;
}
