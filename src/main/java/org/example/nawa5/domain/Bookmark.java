package org.example.nawa5.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 북마크
 */
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Bookmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 유저
     **/
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    /**
     * 게시글
     **/
    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    /** 상태 **/
    /** @Enumerated Type.ORIGINAL = enum 순서(숫자)값을 DB에 저장  **/
    /**
     * @Enumerated Type.STRING = enum 이름을 DB에 저장
     **/
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private BookmarkStatus bookmarkStatus = BookmarkStatus.REGISTERED;

    /**
     * 생성 일시
     **/
    private LocalDateTime createdAt = LocalDateTime.now();

    /**
     * 삭제 일시
     **/
    private LocalDateTime deletedAt;

    public Bookmark(User user, Post post) {
        this.user = user;
        this.post = post;
    }

    public void delete() {
        if (this.bookmarkStatus == BookmarkStatus.DELETED) {
            throw new IllegalStateException("check failed.");
        }

        this.bookmarkStatus = BookmarkStatus.DELETED;
        this.deletedAt = LocalDateTime.now();
    }
}
