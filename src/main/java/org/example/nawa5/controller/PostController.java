package org.example.nawa5.controller;

import lombok.RequiredArgsConstructor;
import org.example.nawa5.controller.view.GetPostRes;
import org.example.nawa5.controller.view.PostData;
import org.example.nawa5.controller.view.RegisterPostReq;
import org.example.nawa5.domain.Post;
import org.example.nawa5.service.PostService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    // 생성
    @PostMapping
    public void register(@RequestBody RegisterPostReq req) {
        Long userId = 1L;

        postService.register(userId, req.getCategory(), req.getTitle(), req.getContent(), req.getMainImageUrl());
    }




    // Todo
    //게시글 단건 조회
    @GetMapping("/{id}")
    public GetPostRes get(@PathVariable Long id) {
        Post post = postService.get(id);

        return new GetPostRes(post);
    }
}
