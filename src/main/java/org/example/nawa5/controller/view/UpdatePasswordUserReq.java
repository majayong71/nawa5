package org.example.nawa5.controller.view;

import lombok.Getter;

/**
 * 유저 id JWT 토큰으로 받아온다.
 */
@Getter
public class UpdatePasswordUserReq {
    private final String password;

    public UpdatePasswordUserReq(String password) {
        this.password = password;
    }
}
