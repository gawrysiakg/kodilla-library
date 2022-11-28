package com.library.kodillalibrary.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReaderDto {
    private Long readerId;
    private String firstName;
    private String lastName;
    private LocalDate registrationDate;

}
