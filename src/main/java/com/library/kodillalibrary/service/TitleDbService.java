package com.library.kodillalibrary.service;

import com.library.kodillalibrary.controller.exceptions.TitleNotFoundException;
import com.library.kodillalibrary.domain.Title;
import com.library.kodillalibrary.repository.TitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TitleDbService {

    private final TitleRepository titleRepository;

    public Title saveTitle(final Title title) {
        return titleRepository.save(title);
    }

    public Title getTitle(final Long titleId) throws TitleNotFoundException {
        return titleRepository.findById(titleId).orElseThrow(TitleNotFoundException::new);
    }


}
