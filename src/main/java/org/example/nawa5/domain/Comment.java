package org.example.nawa5.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * 댓글
 */
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 유저 **/
    @ManyToOne (fetch = FetchType.LAZY)
    private User user;

    /** 게시글 **/
    @ManyToOne (fetch = FetchType.LAZY)
    private Post post;

    /** 내용 **/
    @Column(length = 200)
    private String content;

    /** 이미지 **/
    @Column(length = 200)
    private String imageUrl;

    /** 상태 **/
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private CommentStatus Status = CommentStatus.REGISTERED;

    /** 생성 일시 **/
    private LocalDateTime createdAt = LocalDateTime.now();

    /** 삭제 일시 **/
    private LocalDateTime deletedAt;


    public Comment(User user, Post post, String content, String imageUrl) {
        this.user = user;
        this.post = post;
        this.content = content;
        this.imageUrl = imageUrl;
    }

    public void update(Long id, User user, String content, String imageUrl) {
        this.id = id;
        this.user = user;
        this.content = content;
        this.imageUrl = imageUrl;
    }

    public void delete(Long id, User user) {
        this.Status = Status.DELETED;
        this.deletedAt = LocalDateTime.now();
    }

}
