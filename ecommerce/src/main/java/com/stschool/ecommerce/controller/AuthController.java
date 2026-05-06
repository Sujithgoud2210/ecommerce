package com.stschool.ecommerce.controller;

import org.springframework.web.bind.annotation.PostMapping;

public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) throws IOException {
        this.authService = authService;
    }
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody Customer customer)  {
        try {
            Customer signedUpCustomer = authService.signup(customer);
            return ResponseEntity.status(HttpStatus.CREATED).body(signedUpCustomer);
        } catch (CustomerExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginCredentials loginCredentials) {
        try {
            return ResponseEntity.ok(authService.login(loginCredentials.getEmail(), loginCredentials.getPassword()));
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    public Customer getCustomerByEmail(String email) throws CustomerNotFoundException {
        return authService.getCustomerByEmail(email);
    }
}
