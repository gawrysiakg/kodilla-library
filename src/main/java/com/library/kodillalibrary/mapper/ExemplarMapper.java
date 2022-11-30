package com.library.kodillalibrary.mapper;

import com.library.kodillalibrary.domain.Exemplar;
import com.library.kodillalibrary.domain.Rent;
import com.library.kodillalibrary.domain.Title;
import com.library.kodillalibrary.domain.dto.ExemplarDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ExemplarMapper {
    public Exemplar mapToExemplar(final ExemplarDto exemplarDto, final Title title, Rent rent) {
        return new Exemplar(
                exemplarDto.getId(),
                exemplarDto.getStatus(),
                title,
                rent
                );
    }


    public ExemplarDto mapToDto(final Exemplar exemplar) {
        return new ExemplarDto(
                exemplar.getId(),
                exemplar.getStatus(),
                exemplar.getTitle().getId()
                );
    }

    public List<ExemplarDto> mapToDtoList (final List<Exemplar> exemplarList) {
        return exemplarList.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

}
