package org.example.nawa5.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 레스토랑
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 이름 **/
    @Column(length = 20)
    private String name;

    /** 카테고리 **/
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RestaurantCategory category;

    /** 주소 **/
    @Column(length = 100)
    private String address;

    /** 영업 시간 **/
    private LocalDateTime businessHours;

    /** 연락처 **/
    @Column(length = 15)
    private String phoneNumber;

    /** 설명 **/
    @Column(length = 100)
    private String description;

    /** 대표 이미지 **/
    @Column(length = 200)
    private String mainImageUrl;

    /** 노출 여부 **/
    private Boolean visible = true;

    /** 생성 일시 **/
    private LocalDateTime createdAt = LocalDateTime.now();


    public Restaurant(String name, RestaurantCategory category, String address, LocalDateTime businessHours, String phoneNumber, String description, String mainImageUrl) {
        this.name = name;
        this.category = category;
        this.address = address;
        this.businessHours = businessHours;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.mainImageUrl = mainImageUrl;
    }
}
