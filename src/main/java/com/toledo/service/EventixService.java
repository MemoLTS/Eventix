package com.toledo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toledo.model.Evento;
import com.toledo.model.FechaEventix;
import com.toledo.repository.EventixRepository;

@Service
public class EventixService {
    @Autowired
    private EventixRepository repository;

    public List<Evento> getAllEventos() {
        return repository.readall();
    }

    public void createEvento(Evento evento) {
        repository.Create(evento);
    }

    public void seed() {
        repository.seed();
    }
    public List<FechaEventix> getFechas() {
        return repository.getFechas();
    }
}
