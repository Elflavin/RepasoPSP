package org.educa.examen.mappers;

import org.educa.examen.dto.FilmDTO;
import org.educa.examen.entity.FilmEntity;
import org.springframework.stereotype.Component;

@Component
public class FilmMapper {

    public FilmDTO toDTO(FilmEntity film){
        FilmDTO filmDTO = new FilmDTO();
        filmDTO.setId(film.getId());
        filmDTO.setName(film.getName());
        filmDTO.setYear(film.getYear());
        filmDTO.setDuration(film.getDuration());
        return filmDTO;
    }

    public FilmEntity toEntity(FilmDTO filmDTO){
        FilmEntity film = new FilmEntity();
        film.setId(filmDTO.getId());
        film.setName(filmDTO.getName());
        film.setYear(filmDTO.getYear());
        film.setDuration(filmDTO.getDuration());
        return film;
    }

}
