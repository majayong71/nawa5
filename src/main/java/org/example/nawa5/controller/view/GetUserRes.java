package org.example.nawa5.controller.view;

import lombok.Getter;

/**
 *  유저 정보 조회 응답
 *  어떤걸 조회할지 필드값을 정의.
 *  ex) 작성했던 게시글 조회, 작성했던 댓글 조회 등
 */
@Getter
public class GetUserRes {
    private String email;
    private String nickname;

    public GetUserRes(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
    }
}
