package com.library.kodillalibrary.mapper;

import com.library.kodillalibrary.domain.Exemplar;
import com.library.kodillalibrary.domain.Reader;
import com.library.kodillalibrary.domain.Rent;
import com.library.kodillalibrary.domain.dto.RentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentMapper {

    public RentDto mapToDto(final Rent rent){
        return new RentDto(
                rent.getId(),
                rent.getRentalDate(),
                rent.getReturnDate(),
                rent.getExemplar().getId(),
                rent.getReader().getReaderId()
        );
    }

    public Rent mapToRent(RentDto rentDto, final Reader reader, final Exemplar exemplar){
        return new Rent(
                rentDto.getRentId(),
                rentDto.getRentalDate(),
                rentDto.getReturnDate(),
                reader,
                exemplar
        );
    }


    public List<RentDto> mapToRentDtoList(final List<Rent> rentList) {
        return rentList.stream()
                .map(this::mapToDto)
                .toList();
    }

}
