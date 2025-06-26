package org.example.nawa5.controller.view;

import lombok.Getter;

@Getter
public class RegisterUserReq {
    private String email;
    private String password;
    private String nickname;

    public RegisterUserReq (String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }
}
