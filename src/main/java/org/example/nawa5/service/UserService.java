package org.example.nawa5.service;

import org.example.nawa5.domain.User;

public interface UserService {

    /**
     * 회원 가입
     **/
    void register(String email, String password, String nickname);

    /**
     * 로그인
     **/
    String login(String email, String password);

    /**
     * 회원 정보 조회
     **/
    User get(Long id);

    /**
     * 회원 정보 수정
     **/
    void update(Long id, String nickname);

    /**
     * 회원 패스워드 수정
     **/
    void updatePassword(Long id, String password);

    /**
     * 회원 탈퇴
     **/
    void delete(Long id);
}
