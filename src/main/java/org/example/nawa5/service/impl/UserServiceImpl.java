package org.example.nawa5.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.nawa5.domain.User;
import org.example.nawa5.repository.UserRepository;
import org.example.nawa5.service.UserService;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void register(String email, String password, String nickname) {
        // 이메일 중복 검사
        if(userRepository.existsByEmail(email)) { // 이메일이 존재
            throw new IllegalArgumentException("이미 중복된 이메일입니다.");
        }

        // TODO: 비밀번호 양식 체크 정규식

        User user = new User(email, password, nickname);

        userRepository.save(user);
    }

    @Override
    public void login(String email, String password) {

    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void updateUser(Long id, String nickname) {
        User user = userRepository.findById(id).get();

        user.updateUser(nickname);
    }

    @Override
    public void updatePassword(Long id, String password) {
        User user = userRepository.findById(id).get();

        user.updatePassword(password);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).get();

        user.deleteUser();
    }
}
