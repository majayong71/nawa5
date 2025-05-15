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

    /** 상태 **/
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private CommentStatus commentStatus = CommentStatus.REGISTERED;

    /** 일시 **/
    private LocalDateTime createdAt = LocalDateTime.now();
}
