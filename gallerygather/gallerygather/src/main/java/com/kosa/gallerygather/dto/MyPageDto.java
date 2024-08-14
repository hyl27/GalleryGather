package com.kosa.gallerygather.dto;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MyPageDto {
    private String email;
    private String nickName;
    private String name;
    private LocalDate dateOfBirth;
    private String address;
}