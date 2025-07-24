package org.example.nawa5.controller.view;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class GetPostsRes {
    private final List<PostData> posts;
}
