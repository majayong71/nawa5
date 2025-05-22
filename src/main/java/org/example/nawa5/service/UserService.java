package org.example.nawa5.service;

import org.example.nawa5.domain.User;

public interface UserService {

    /** 회원 가입 **/
    User register (User user);

    /** 로그인 **/
    User login (String email, String password);

    /** 회원 정보 조회 **/
    User getUser (String user);

    /** 회원 정보 수정  **/
    User updateUser (User user);

    /** 회원 탈퇴 **/
    User deleteUser (String user);

}
