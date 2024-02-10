package com.marcing.marcing.dto;

import lombok.Value;

@Value
public class LoginRequest {

    String email;
    String password;
}
