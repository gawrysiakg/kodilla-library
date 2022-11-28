package com.library.kodillalibrary.mapper;

import com.library.kodillalibrary.domain.Reader;
import com.library.kodillalibrary.domain.dto.ReaderDto;
import org.springframework.stereotype.Service;

@Service
public class ReaderMapper {

    public Reader mapToReader(final ReaderDto readerDto) {
        return new Reader(
                readerDto.getReaderId(),
                readerDto.getFirstName(),
                readerDto.getLastName(),
                readerDto.getRegistrationDate());
    }

    public ReaderDto mapToDto(final Reader reader) {
        return new ReaderDto(
                reader.getReaderId(),
                reader.getFirstName(),
                reader.getLastName(),
                reader.getRegistrationDate());
    }

}
