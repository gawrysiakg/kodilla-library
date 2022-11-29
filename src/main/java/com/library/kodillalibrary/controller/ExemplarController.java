package com.library.kodillalibrary.controller;


import com.library.kodillalibrary.controller.exceptions.ExemplarNotFoundException;
import com.library.kodillalibrary.controller.exceptions.TitleNotFoundException;
import com.library.kodillalibrary.domain.Exemplar;
import com.library.kodillalibrary.domain.Title;
import com.library.kodillalibrary.domain.dto.ExemplarDto;
import com.library.kodillalibrary.mapper.ExemplarMapper;
import com.library.kodillalibrary.service.ExemplarDbService;
import com.library.kodillalibrary.service.TitleDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/exemplars")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ExemplarController {

    private final ExemplarDbService exemplarDbService;
    private final TitleDbService titleDbService;
    private final ExemplarMapper exemplarMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createExemplar(@RequestBody ExemplarDto exemplarDto) throws TitleNotFoundException {
        Title title = titleDbService.getTitle(exemplarDto.getTitleId());
        Exemplar exemplar = exemplarMapper.mapToExemplar(exemplarDto, title);
        exemplar.setTitle(title);
        exemplar.setStatus(exemplarDto.getStatus());
        //exemplar.setStatus(BookStatus.AVAILABLE);
        exemplarDbService.saveExemplar(exemplar);
        title.getExemplars().add(exemplar);
        titleDbService.saveTitle(title);
        return ResponseEntity.ok().build();
    }


    @PutMapping
    public ResponseEntity<ExemplarDto> updateExemplarStatus(@RequestBody ExemplarDto exemplarDto) throws ExemplarNotFoundException {
        Exemplar exemplar = exemplarDbService.getExemplar(exemplarDto.getId());
        exemplar.setStatus(exemplarDto.getStatus());
        Exemplar savedExemplar = exemplarDbService.saveExemplar(exemplar);
        return ResponseEntity.ok(exemplarMapper.mapToDto(savedExemplar));
    }





}
