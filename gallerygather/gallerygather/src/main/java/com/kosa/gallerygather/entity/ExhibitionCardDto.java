package com.kosa.gallerygather.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExhibitionCardDto {
    private Long exhibitionId;
    private String imageUrl;
    private String title;
    private String description;
}
