package org.example.nawa5.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * 배너
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Banners {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 베너 이미지 **/
    @Column(length = 200)
    private String imageUrl;

    /** 노출 순서  **/
    @Column(length = 10)
    private int displayOrder;

    /** 노출 여부 **/
    private boolean isVisible;

    /** 노출 일시 **/
    private LocalDateTime exposureTime;

    /** 생성 일시 **/
    private LocalDateTime createdAt = LocalDateTime.now();

    /** 삭제 일시 **/
    private LocalDateTime deletedAt;

    public Banners(String imageUrl, int displayOrder, boolean isVisible, LocalDateTime exposureTime){
        this.imageUrl= imageUrl;
        this.displayOrder = displayOrder;
        this.isVisible = isVisible;
        this.exposureTime = exposureTime;
    }

    public void update(String imageUrl, int displayOrder){
        this.imageUrl = imageUrl;
        this.displayOrder = displayOrder;
    }

    public void delete() {
        this.isVisible = false;
        this.deletedAt = LocalDateTime.now();
    }

}
