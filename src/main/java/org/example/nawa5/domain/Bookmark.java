package org.example.nawa5.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * 북마크
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bookmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 유저 **/
    @ManyToOne (fetch = FetchType.LAZY)
    private User user;

    /** 게시글 **/
    @ManyToOne (fetch = FetchType.LAZY)
    private Post post;

    /** 상태 **/
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private BookmarkStatus bookmarkStatus = BookmarkStatus.REGISTERED;

    /** 생성 일시 **/
    private LocalDateTime createdAt = LocalDateTime.now();
}
