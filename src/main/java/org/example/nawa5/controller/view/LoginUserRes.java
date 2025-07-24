package org.example.nawa5.controller.view;

import lombok.Getter;

@Getter
public class LoginUserRes {
    private final String accessToken;

    public LoginUserRes (String accessToken){
        this.accessToken = accessToken;
    }
}
