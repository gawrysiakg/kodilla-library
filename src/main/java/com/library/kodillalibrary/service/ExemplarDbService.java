package com.library.kodillalibrary.service;

import com.library.kodillalibrary.controller.exceptions.ExemplarNotFoundException;
import com.library.kodillalibrary.domain.Exemplar;
import com.library.kodillalibrary.repository.ExemplarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExemplarDbService {

    private final ExemplarRepository exemplarRepository;

    public Exemplar saveExemplar(final Exemplar exemplar) {
        return exemplarRepository.save(exemplar);
    }


    public Exemplar getExemplar(final Long exemplarId) throws ExemplarNotFoundException {
        return exemplarRepository.findById(exemplarId).orElseThrow(ExemplarNotFoundException::new);
    }
}
