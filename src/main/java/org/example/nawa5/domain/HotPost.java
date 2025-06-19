package org.example.nawa5.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 인기글
 */
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HotPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 게시글 **/
    @ManyToOne (fetch = FetchType.LAZY)
    private Post post;

    /** 일자 **/
    private LocalDate date;

    /** 순위 **/
    @Column(name = "rank_")
    private int rank;

    /** 카테고리 **/
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private HotPostCategory hotPostCategory;

    /** 상태 **/
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private HotPostStatus hotPostStatus = HotPostStatus.REGISTERED;

    /** 생성 일시 **/
    private LocalDateTime createdAt = LocalDateTime.now();

    /** 삭제 일시 **/
    private LocalDateTime deletedAt;

    public HotPost(Post post, LocalDate date, int rank, HotPostCategory hotPostCategory ) {
        this.post = post;
        this.date = date;
        this.rank = rank;
        this.hotPostCategory = hotPostCategory;
    }

    public void update(Post post, LocalDate date, int rank, HotPostCategory hotPostCategory) {
        this.post = post;
        this.date = date;
        this.rank = rank;
        this.hotPostCategory = hotPostCategory;
    }

    public void delete() {
        this.hotPostStatus = HotPostStatus.DELETED;
        this.deletedAt = LocalDateTime.now();
    }

}
