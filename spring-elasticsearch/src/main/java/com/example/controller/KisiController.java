package com.example.controller;

import com.example.entity.Kisi;
import com.example.repository.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/kisi")
public class KisiController {

    private static final Logger logger = LoggerFactory.getLogger(KisiController.class);
    private final KisiRepository kisiRepository;

    @PostMapping
    public ResponseEntity<Kisi> ekle(@RequestBody Kisi kisi) {
        logger.error("dehsetul whaset bir sey bu ya garip bi adam");
        return ResponseEntity.ok(kisiRepository.save(kisi));
    }
    @GetMapping("/{search}")
    public ResponseEntity<List<Kisi>> getKisi(@PathVariable String search) {
        List<Kisi> kisiler = kisiRepository.getByCustomQuery(search);
        return ResponseEntity.ok(kisiler);
    }
}
