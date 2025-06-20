package org.example.nawa5.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 배너
 */
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Banner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 베너 이미지
     **/
    @Column(length = 200)
    private String imageUrl;

    /**
     * 링크 url
     **/
    @Column(length = 200)
    private String linkUrl;

    /**
     * 노출 순서
     **/
    private int displayOrder = 0;

    /**
     * 상태
     **/
    @Enumerated(EnumType.STRING)
    BannerStatus status = BannerStatus.REGISTERED;

    /**
     * 노출 여부
     **/
    private boolean isVisible = false;

    /**
     * 노출 일시
     **/
    private LocalDateTime exposureTime;

    /**
     * 생성 일시
     **/
    private LocalDateTime createdAt = LocalDateTime.now();

    /**
     * 삭제 일시
     **/
    private LocalDateTime deletedAt;

    public Banner(String imageUrl, String linkUrl, int displayOrder, boolean isVisible, LocalDateTime exposureTime) {
        this.imageUrl = imageUrl;
        this.linkUrl = linkUrl;
        this.displayOrder = displayOrder;
        this.isVisible = isVisible;
        this.exposureTime = exposureTime;
    }

    public void update(String imageUrl, String linkUrl, int displayOrder) {
        this.imageUrl = imageUrl;
        this.linkUrl = linkUrl;
        this.displayOrder = displayOrder;
    }

    public void delete() {
        if (this.status == BannerStatus.DELETED) {
            throw new IllegalStateException("check failed.");
        }

        this.status = BannerStatus.DELETED;
        this.isVisible = false;
        this.deletedAt = LocalDateTime.now();
    }
}
