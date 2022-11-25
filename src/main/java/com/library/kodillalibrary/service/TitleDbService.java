package com.library.kodillalibrary.service;

import com.library.kodillalibrary.repository.TitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TitleDbService {

    private final TitleRepository titleRepository;
}
