package org.example.nawa5.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 게시글
 */
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 유저
     **/
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    /**
     * 제목
     **/
    @Column(length = 100)
    private String title;

    /**
     * 본문
     **/
    @Column(length = 500)
    private String content;

    /**
     * 카테고리
     **/
    @Enumerated(EnumType.STRING)
    private PostCategory category;

    /**
     * 이미지 첨부
     **/
    @Column(length = 200)
    private String imageUrl;

    /**
     * 댓글 수
     **/
    private int commentCount = 0;

    /**
     * 조회 수
     **/
    private int viewCount = 0;

    /**
     * 상태
     **/
    private PostStatus status = PostStatus.REGISTERED;

    /**
     * 삭제 일시
     **/
    private LocalDateTime deletedAt;


    /**
     * 생성 일시
     **/
    private LocalDateTime createdAt = LocalDateTime.now();

    public Post(User user, PostCategory category, String title, String content, String imageUrl) {
        this.user = user;
        this.category = category;
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
    }

    /**
     * 수정
     **/
    public void update(Long userId, String title, PostCategory category, String content, String imageUrl) {
        if (this.user.getId() != userId) {
            throw new IllegalArgumentException("check failed.");
        }

        this.title = title;
        this.category = category;
        this.content = content;
        this.imageUrl = imageUrl;
    }

    /**
     * 삭제
     **/
    public void delete(Long userId) {
        if (this.user.getId() != userId) {
            throw new IllegalArgumentException("check failed.");
        }

        if (this.status == PostStatus.DELETED) {
            throw new IllegalStateException("check failed");
        }

        this.status = PostStatus.DELETED;
        this.deletedAt = LocalDateTime.now();
    }
}
