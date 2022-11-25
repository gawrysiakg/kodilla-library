package com.library.kodillalibrary.domain.dto;

import com.library.kodillalibrary.domain.Rent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReaderDto {
    private Long readerId;
    private String firstName;
    private String lastName;
    private Date registrationDate;
    private List<Rent> readerRentList;

}
