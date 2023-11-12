package com.joaocastillo.demo.domain;

import lombok.Getter;

@Getter
public class LoginRequest {
    private String email;
    private String password;
}
