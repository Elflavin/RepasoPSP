package org.educa.examen.repository.inmemory;

import org.educa.examen.entity.FilmEntity;
import org.educa.examen.repository.FilmRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InMemoryFilmRepository implements FilmRepository {
    private final Map<Integer, FilmEntity> films = new HashMap<>();

    @Override
    public FilmEntity findById(Integer id) {
        return films.get(id);
    }

    @Override
    public List<FilmEntity> findAll() {
        return new ArrayList<>(films.values());
    }

    @Override
    public boolean add(FilmEntity filmEntity) {
        if (!films.containsKey(filmEntity.getId())) {
            films.put(filmEntity.getId(), filmEntity);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(Integer id, FilmEntity filmEntity) {
        if (films.containsKey(id)) {
            films.remove(id);
            films.put(filmEntity.getId(), filmEntity);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(Integer id) {
        if (films.containsKey(id)) {
            films.remove(id);
            return true;
        } else {
            return false;
        }
    }
}
