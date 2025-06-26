package org.example.nawa5.controller.view;

import lombok.Getter;

@Getter
public class UpdateUserReq {
    private Long userId;
    private String nickname;

    public UpdateUserReq(Long userId, String nickname ) {
        this.userId = userId;
        this.nickname = nickname;
    }
}
