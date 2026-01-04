package com.acl.gestorTareas.dto;

public class LoginResponse {
    private String token;

    public LoginResponse() {} // constructor vacío para Jackson

    public LoginResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
