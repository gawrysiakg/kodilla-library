package com.library.kodillalibrary.controller;

import com.library.kodillalibrary.controller.exceptions.*;
import com.library.kodillalibrary.domain.*;
import com.library.kodillalibrary.domain.dto.RentDto;
import com.library.kodillalibrary.mapper.RentMapper;
import com.library.kodillalibrary.service.ExemplarDbService;
import com.library.kodillalibrary.service.ReaderDbService;
import com.library.kodillalibrary.service.RentDbService;
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
    private final ExemplarDbService exemplarDbService;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createRent(@RequestBody RentDto rentDto) throws ReaderNotFoundException, ExemplarNotFoundException, RentedExemplarException {
        Reader reader = readerDbService.getReader(rentDto.getReaderId());
        Exemplar exemplar = exemplarDbService.getExemplar(rentDto.getExemplarId());
        if(exemplar.getStatus().equals(BookStatus.RENTED)){
            throw new RentedExemplarException();
           }
            exemplar.setStatus(BookStatus.RENTED);
            Rent rent = rentMapper.mapToRent(rentDto, reader, exemplar);
            rent.setExemplar(exemplar);
            rent.setRentalDate(LocalDate.now());
            rent.setReturnDate(null);
            exemplarDbService.saveExemplar(exemplar);
            rentDbService.saveRent(rent);
            reader.getReaderRentList().add(rent);
            readerDbService.saveReader(reader);

        return ResponseEntity.ok().build();
    }




    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> closeRent(@RequestBody RentDto rentDto) throws ReaderNotFoundException, ExemplarNotFoundException, RentNotFoundException {
        Reader reader = readerDbService.getReader(rentDto.getReaderId());
        Exemplar exemplar = exemplarDbService.getExemplar(rentDto.getExemplarId());
        exemplar.setStatus(BookStatus.AVAILABLE);
       Rent rentFromDb = rentDbService.getRent(rentDto.getRentId());
        rentFromDb.setReturnDate(LocalDate.now());
        rentDbService.saveRent(rentFromDb);
        return ResponseEntity.ok().build();
    }




    @GetMapping
    public ResponseEntity <List<RentDto>> getRents(){
        List<Rent> rents = rentDbService.getAllRents();
        return ResponseEntity.ok(rentMapper.mapToRentDtoList(rents));
    }




    @GetMapping("/{id}")
    public ResponseEntity <List<RentDto>> getReaderRents(@PathVariable("id") Long id) throws ReaderNotFoundException {
       Reader reader =  readerDbService.getReader(id);
        List<Rent> readerRentList = reader.getReaderRentList();
        return ResponseEntity.ok(rentMapper.mapToRentDtoList(readerRentList));
    }
}
