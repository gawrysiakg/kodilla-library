package com.library.kodillalibrary.service;

import com.library.kodillalibrary.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookDbService {

    private final BookRepository bookRepository;
}
