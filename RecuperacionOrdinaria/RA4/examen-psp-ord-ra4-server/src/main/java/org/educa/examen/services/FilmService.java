package org.educa.examen.services;

import org.educa.examen.dto.FilmDTO;
import org.educa.examen.entity.FilmEntity;
import org.educa.examen.repository.inmemory.InMemoryFilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmService {

    private final InMemoryFilmRepository inMemoryFilmRepository;

    @Autowired
    public FilmService(InMemoryFilmRepository inMemoryFilmRepository) {
        this.inMemoryFilmRepository = inMemoryFilmRepository;
    }

    public boolean add(FilmEntity film){
        return inMemoryFilmRepository.add(film);
    }

    public boolean delete(int id){
        return inMemoryFilmRepository.delete(id);
    }

    public FilmEntity findById(int id){
        return inMemoryFilmRepository.findById(id);
    }

}
