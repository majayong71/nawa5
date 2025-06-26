package org.example.nawa5.controller.view;

import lombok.Getter;

@Getter
public class LoginUserReq {
    private String email;
    private String password;

    public LoginUserReq (String email, String password) {
        this.email = email;
        this.password = password;
    }
}
