package com.kosa.gallerygather.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "TBL_REVIEW_IMAGE")
public class ReviewImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "img_idx")
    private Long id;

    @Column(name = "path")
    private String path;

    @Column(name = "original_name")
    private String originalName;

    @ManyToOne
    @JoinColumn(name = "exhibitreview_id")
    private ExhibitionReview exhibitionReview;
}
