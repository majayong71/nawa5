package org.example.nawa5.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * 게시글
 */
@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 유저 **/
    @ManyToOne (fetch = FetchType.LAZY)
    private User user;

    /** 제목 **/
    @Column(length = 100)
    private String title;

    /** 본문 **/
    @Column(length = 500)
    private String content;

    /** 카테고리 **/
    @Enumerated(EnumType.STRING)
    private PostCategory postCategory;

    /** 이미지 첨부 **/
    @Column(length = 200)
    private String imageUrl;

    /** 댓글 수 **/
    private int commentCount = 0;

    /** 조회 수 **/
    private int viewCount = 0;

    /** 상태 **/
    private PostStatus postStatus = PostStatus.REGISTERED;

    /** 생성 일시 **/
    private LocalDateTime createdAt = LocalDateTime.now();

}
