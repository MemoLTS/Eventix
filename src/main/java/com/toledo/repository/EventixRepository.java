package com.toledo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.toledo.model.Evento;
import com.toledo.model.FechaEventix;

@Repository
public class EventixRepository {

    private List<Evento> eventos = new ArrayList<>();

    public List<Evento> readall() {
        return eventos;
    }

    public void Create(Evento evento) {
        eventos.add(evento);
    }

    public List<FechaEventix> getFechas() {
        List<FechaEventix> repo=new ArrayList<>();
        for (Evento m : eventos) {
            FechaEventix f=new FechaEventix(m.getTitle(), m.getDia(), m.getAño(), m.getMes());
            repo.add(f);
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

    public void update(Evento updatedEvento) {
        Evento existingEvento = findById(updatedEvento.getId());
        if (existingEvento != null) {
            existingEvento.setTitle(updatedEvento.getTitle());
            existingEvento.setDescription(updatedEvento.getDescription());
            existingEvento.setUbicacion(updatedEvento.getUbicacion());
            existingEvento.setCapacidad(updatedEvento.getCapacidad());
            existingEvento.setAsistentes(updatedEvento.getAsistentes());
        }
    }
    public void seed() {
        Create(new Evento(0, "Evento 1", "Descripción del evento 1", "Ubicación 1", 50, 0, null));
        Create(new Evento(0, "Evento 2", "Descripción del evento 2", "Ubicación 2", 30, 0, null));
        Create(new Evento(0, "Evento 3", "Descripción del evento 3", "Ubicación 3", 20, 0, null));
        Create(new Evento(0, "Evento 4", "Descripción del evento 4", "Ubicación 4", 10, 0, null));
    }
}
