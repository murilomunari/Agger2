package com.agger.Controller;

import com.agger.DTO.ApoliceDTO;
import com.agger.Model.Apolice;
import com.agger.Service.ApoliceService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apolice")
public class ApoliceController {

    private final ApoliceService apoliceService;

    public ApoliceController(ApoliceService apoliceService) {
        this.apoliceService = apoliceService;
    }

    @PostMapping
    public ResponseEntity<Apolice> create(@Valid @RequestBody ApoliceDTO data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(apoliceService.create(data));
    }

    @GetMapping
    public ResponseEntity<List<Apolice>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping("/{number}")
    public ResponseEntity<Optional<Apolice>> findByNumber(String number) {
        return ResponseEntity.status(HttpStatus.OK).body(apoliceService.findByNumber(number));
    }
}
