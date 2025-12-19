package com.bentesdev.financemanager.domain.user.dto;

public class CreateUserRequest {
    private String email;
    private String password;

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }
}
