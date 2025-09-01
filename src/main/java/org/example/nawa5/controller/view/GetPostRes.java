package org.example.nawa5.controller.view;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.nawa5.domain.Post;
import org.example.nawa5.domain.PostCategory;

@RequiredArgsConstructor
@Getter
public class GetPostRes {
    private final Long userId;
    private final String title;
    private final String content;
    private final PostCategory category;
    private final String imageUrl;
    private final int commentCount;
    private final int viewCount;

    public GetPostRes(Post post) {
        this.userId = post.getUser().getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.category = post.getCategory();
        this.imageUrl = post.getImageUrl();
        this.commentCount = post.getCommentCount();
        this.viewCount = post.getViewCount();
    }
}
