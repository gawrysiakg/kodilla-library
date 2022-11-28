package com.library.kodillalibrary.domain.dto;

import com.library.kodillalibrary.domain.BookStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ExemplarDto {
    private Long id;
    private BookStatus status;
    private Long titleId;

}
