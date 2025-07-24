package org.example.nawa5.controller.view;

import lombok.Getter;
import org.example.nawa5.domain.PostCategory;

@Getter
public class PostData {
    private final Long userId;
    private final String title;
    private final String content;
    private final PostCategory category;
    private final String imageUrl;
    private final int commentCount;
    private final int viewCount;

    public PostData(
            Long userId, String title, String content, PostCategory category, String imageUrl, int commentCount,
            int viewCount
    ) {
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.category = category;
        this.imageUrl = imageUrl;
        this.commentCount = commentCount;
        this.viewCount = viewCount;
    }
}
