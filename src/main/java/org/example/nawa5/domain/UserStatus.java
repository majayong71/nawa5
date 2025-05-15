package org.example.nawa5.domain;

public enum UserStatus {
    REGISTERED, // 등록됨
    ACTIVATE, // 활성화 (이메일 인증 완료)
    INACTIVATE, // 비활성화
    DELETED // 탈퇴
}
