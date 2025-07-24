package org.example.nawa5.controller.view;

import lombok.Getter;

@Getter
public class LoginUserReq {
    private final String email;
    private final String password;

    public LoginUserReq (String email, String password) {
        this.email = email;
        this.password = password;
    }
}
