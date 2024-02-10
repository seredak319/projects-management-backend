package com.marcing.marcing.dto;
import lombok.Value;

@Value
public class RegisterRequest {
    String email;
    String password;
}
