package com.kosa.gallerygather.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "TBL_EXHIBITION")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Exhibition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "place")
    private String place;

    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "charge")
    private Integer charge;

    @Column(name = "author")
    private String author;

    @Column(name ="site_url")
    private String siteUrl;

    @Column(name = "img_url")
    private String imgUrl;

    private int likeCount;

    private int readCount;

    private int reviewCount;

    private int avgScore;

    private String genre;

    private String duration;
}