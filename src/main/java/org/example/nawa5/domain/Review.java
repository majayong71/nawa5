package org.example.nawa5.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * 리뷰
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 유저 **/
    @ManyToOne (fetch = FetchType.LAZY)
    private User user;

    /** 레스토랑 **/
    @ManyToOne (fetch = FetchType.LAZY)
    private Restaurant restaurant;

    /** 내용 **/
    @Column(length = 200)
    private String content;

    /** 이미지 **/
    @Column(length = 200)
    private String imageUrl;

    /** 점수 **/
    @Column(length = 5)
    private int rating;

    /** 상태 **/
    @Enumerated(EnumType.STRING)
    private ReviewStatus reviewStatus = ReviewStatus.REGISTERED;

    /** 생성 일시 **/
    private LocalDateTime createdAt = LocalDateTime.now();

    public Review(User user, Restaurant restaurant, String content,String imageUrl, int rating) {
        this.user = user;
        this.restaurant = restaurant;
        this.content = content;
        this.imageUrl = imageUrl;
        this.rating = rating;
    }

    /** 리뷰 수정 **/
    public void update(String content,String imageUrl, int rating) {
        this.content = content;
        this.imageUrl = imageUrl;
        this.rating = rating;
    }

    /** 리뷰 삭제 **/
    public void delete() {
        this.reviewStatus = ReviewStatus.DELETED;
    }
}