package com.library.kodillalibrary.mapper;

import com.library.kodillalibrary.domain.Title;
import com.library.kodillalibrary.domain.dto.TitleDto;
import org.springframework.stereotype.Service;

@Service
public class TitleMapper {
    public Title mapToTitle(TitleDto titleDto) {
        return new Title(
                titleDto.getId(),
                titleDto.getTitle(),
                titleDto.getAuthor(),
                titleDto.getYear());
    }


    public TitleDto mapToTitleDto(Title title) {
        return new TitleDto(
                title.getId(),
                title.getTitle(),
                title.getAuthor(),
                title.getYear());
    }



}
