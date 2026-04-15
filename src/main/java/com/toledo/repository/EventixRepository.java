package com.toledo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.toledo.model.Evento;
import com.toledo.model.FechaEventix;

@Repository
public class EventixRepository {

    private List<Evento> eventos = new ArrayList<>();

    
    private List<FechaEventix> fechasList = new ArrayList<>();

    public List<Evento> readall() {
        return eventos;
    }


    public Evento Create(Evento evento) {
        eventos.add(evento);
        return evento;
    }

    public FechaEventix addFechaEventix(FechaEventix fechalist) {
        if (findById(fechalist.getEventoId()) == null) {
            throw new IllegalArgumentException("No existe un evento con el ID " + fechalist.getEventoId());
        }
        fechasList.add(fechalist);
        return fechalist;
    }


    public List<FechaEventix> getFechas() {
        List<FechaEventix> repo=new ArrayList<>();
        for (FechaEventix f: fechasList) {
            FechaEventix fe=new FechaEventix(f.getEventoId(), f.getDia(), f.getMes(), f.getAño());
            repo.add(fe);
        }
        return repo;
    }

    public Evento findById(int id) {
        return eventos.stream()
                .filter(evento -> evento.getId() == id)
                .findFirst()
                .orElse(null);
    }
    public void deleteById(int id) {
        eventos.removeIf(evento -> evento.getId() == id);
    }

    public Evento update(Evento updatedEvento) {
        Evento existingEvento = findById(updatedEvento.getId());
        if (existingEvento != null) {
            existingEvento.setTitle(updatedEvento.getTitle());
            existingEvento.setDescription(updatedEvento.getDescription());
            existingEvento.setUbicacion(updatedEvento.getUbicacion());
            existingEvento.setCapacidad(updatedEvento.getCapacidad());
            existingEvento.setAsistentes(updatedEvento.getAsistentes());
        }
        return existingEvento;
    }
    public void seed() {
        Create(new Evento(0, "Evento 1", "Descripción del evento 1", "Ubicación 1", 50, "convención", 0));
        Create(new Evento(1, "Evento 2", "Descripción del evento 2", "Ubicación 2", 30, "comicon", 0));
        Create(new Evento(2, "Evento 3", "Descripción del evento 3", "Ubicación 3", 20, "congreso", 0));
        Create(new Evento(3, "Evento 4", "Descripción del evento 4", "Ubicación 4", 10, "taller", 0));
        addFechaEventix(new FechaEventix(0, 20, 12, 2026));
        addFechaEventix(new FechaEventix(1, 26, 11, 2027));
        addFechaEventix(new FechaEventix(2, 20, 12, 2027));
        addFechaEventix(new FechaEventix(3, 5, 7, 2027));
    }
}
