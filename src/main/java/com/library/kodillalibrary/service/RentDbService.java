package com.library.kodillalibrary.service;

import com.library.kodillalibrary.controller.exceptions.ExemplarNotFoundException;
import com.library.kodillalibrary.controller.exceptions.RentNotFoundException;
import com.library.kodillalibrary.domain.Exemplar;
import com.library.kodillalibrary.domain.Rent;
import com.library.kodillalibrary.repository.RentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentDbService {

    private final RentRepository rentRepository;

    public List<Rent> getAllRents() {
        return rentRepository.findAll();
    }

    public Rent saveRent(final Rent rent) {
        return rentRepository.save(rent);
    }

    public Rent getRent(final Long rentId) throws RentNotFoundException {
        return rentRepository.findById(rentId).orElseThrow(RentNotFoundException::new);
    }
}
