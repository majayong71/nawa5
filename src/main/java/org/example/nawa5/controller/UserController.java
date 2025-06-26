package org.example.nawa5.controller;

import lombok.RequiredArgsConstructor;
import org.example.nawa5.controller.view.*;
import org.example.nawa5.domain.User;
import org.example.nawa5.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    // 회원 가입
    @PostMapping
    public void register(@RequestBody RegisterUserReq req) {
        userService.register(req.getEmail(), req.getPassword(), req.getNickname());
    }

    @PostMapping("/login")
    public LoginUserRes login(@RequestBody LoginUserReq req) {
        String accessToken = userService.login(req.getEmail(), req.getPassword());

        return new LoginUserRes(accessToken);
    }

    @GetMapping("/{id}")
    public GetUserRes get(@PathVariable Long id) {

        User user = userService.get(id);

        return new GetUserRes(user.getEmail(), user.getNickname());
    }

    @PostMapping("/update")
    public void update(@RequestBody UpdateUserReq req) {
        userService.update(req.getUserId(), req.getNickname());
    }

    /**
     * userId -> token
     **/
    @PostMapping("/password")
    public void updatePassword(@RequestBody UpdatePasswordUserReq req) {
        Long userId = 1L;

        userService.updatePassword(userId, req.getPassword());
    }

    @PostMapping("/delete")
    public void delete() {
        Long userId = 1L;

        userService.delete(userId);
    }
}
