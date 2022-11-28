package com.library.kodillalibrary.controller;

import com.library.kodillalibrary.controller.exceptions.ExemplarNotFoundException;
import com.library.kodillalibrary.controller.exceptions.ReaderNotFoundException;
import com.library.kodillalibrary.domain.*;
import com.library.kodillalibrary.domain.dto.RentDto;
import com.library.kodillalibrary.mapper.ExemplarMapper;
import com.library.kodillalibrary.mapper.ReaderMapper;
import com.library.kodillalibrary.mapper.RentMapper;
import com.library.kodillalibrary.mapper.TitleMapper;
import com.library.kodillalibrary.service.ExemplarDbService;
import com.library.kodillalibrary.service.ReaderDbService;
import com.library.kodillalibrary.service.RentDbService;
import com.library.kodillalibrary.service.TitleDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/rents")
@RequiredArgsConstructor
@CrossOrigin("*")
public class RentController {

    private final RentDbService rentDbService;
    private final RentMapper rentMapper;
    private final ReaderDbService readerDbService;
    private final ReaderMapper readerMapper;
    private final TitleDbService titleDbService;
    private final TitleMapper titleMapper;
    private final ExemplarDbService exemplarDbService;
    private final ExemplarMapper exemplarMapper;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createRent(@RequestBody RentDto rentDto) throws ReaderNotFoundException, ExemplarNotFoundException {
        Reader reader = readerDbService.getReader(rentDto.getReaderId());
        Exemplar exemplar = exemplarDbService.getExemplar(rentDto.getExemplarId());
        exemplar.setStatus(BookStatus.RENTED);
        Rent rent = rentMapper.mapToRent(rentDto, reader, exemplar);
        rent.setRentalDate(LocalDate.now());
        rentDbService.saveRent(rent);
        return ResponseEntity.ok().build();
    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> closeRent(@RequestBody RentDto rentDto) throws ReaderNotFoundException, ExemplarNotFoundException {
        Reader reader = readerDbService.getReader(rentDto.getReaderId());
        Exemplar exemplar = exemplarDbService.getExemplar(rentDto.getExemplarId());
        exemplar.setStatus(BookStatus.AVAILABLE);
        Rent rent = rentMapper.mapToRent(rentDto, reader, exemplar);
        rent.setReturnDate(LocalDate.now());
        rentDbService.saveRent(rent);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity <List<RentDto>> getRents(){
        List<Rent> rents = rentDbService.getAllRents();
        return ResponseEntity.ok(rentMapper.mapToRentDtoList(rents));
    }

}
