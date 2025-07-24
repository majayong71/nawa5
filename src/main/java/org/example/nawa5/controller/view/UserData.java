package org.example.nawa5.controller.view;

import lombok.Getter;

@Getter
public class UserData {
    private final String nickname;

    public UserData(String nickname){
        this.nickname = nickname;
    }
}
