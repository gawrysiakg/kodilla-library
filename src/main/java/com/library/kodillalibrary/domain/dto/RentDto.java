package com.library.kodillalibrary.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RentDto {
    private Long rentId;
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private Long readerId;
    private Long exemplarId;

}
