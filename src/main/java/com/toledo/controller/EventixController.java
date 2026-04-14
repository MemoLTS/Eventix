package com.toledo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.toledo.model.Evento;
import com.toledo.model.FechaEventix;
import com.toledo.service.EventixService;

@SuppressWarnings("unused")
@RestController
@RequestMapping("api/v1/eventix")
public class EventixController {
    @Autowired
    private EventixService service;

    @GetMapping
    public List<Evento> getAllEventos() {
        return service.getAllEventos();
    }

    @PostMapping("/eventos")
    public ResponseEntity<String> createEvento(@Valid @RequestBody Evento evento) {
        service.createEvento(evento);
        return new ResponseEntity<>("Evento creado exitosamente", HttpStatus.CREATED);
    }

    @GetMapping("/fechas")
    public ResponseEntity<List<FechaEventix>> getFechas() {
        return new ResponseEntity<>(service.getFechas(), HttpStatus.OK);
    }

    @PostMapping("/seed")
    public ResponseEntity<String> seed() {
        service.seed();
        return new ResponseEntity<>("Datos de seed cargados exitosamente", HttpStatus.CREATED);
    }
}
