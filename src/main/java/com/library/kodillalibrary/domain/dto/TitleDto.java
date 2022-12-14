package com.library.kodillalibrary.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TitleDto {
    private Long id;
    private String title;
    private String author;
    private int year;
}
