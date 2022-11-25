package com.library.kodillalibrary.domain.dto;

import com.library.kodillalibrary.domain.Exemplar;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TitleDto {
    private Long id;
    private String title;
    private String author;
    private int year;
    private List<Exemplar> exemplars;
}
