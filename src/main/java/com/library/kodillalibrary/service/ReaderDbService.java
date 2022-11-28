package com.library.kodillalibrary.service;

import com.library.kodillalibrary.controller.exceptions.ReaderNotFoundException;
import com.library.kodillalibrary.domain.Reader;
import com.library.kodillalibrary.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReaderDbService {

    private final ReaderRepository readerRepository;


    public Reader getReader(final Long readerId) throws ReaderNotFoundException {
        return readerRepository.findById(readerId).orElseThrow(ReaderNotFoundException::new);
    }

    public Reader saveReader(final Reader reader) {
        return readerRepository.save(reader);
    }

}
