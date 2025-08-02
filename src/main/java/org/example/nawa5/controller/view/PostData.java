package org.example.nawa5.controller.view;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.nawa5.domain.PostCategory;

@RequiredArgsConstructor
@Getter
public class PostData {
    private final Long userId;
    private final String title;
    private final String content;
    private final PostCategory category;
    private final String imageUrl;
    private final int commentCount;
    private final int viewCount;
}
