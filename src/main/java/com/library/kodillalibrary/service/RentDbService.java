package com.library.kodillalibrary.service;

import com.library.kodillalibrary.repository.RentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RentDbService {

    private final RentRepository rentRepository;
}
