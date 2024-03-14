package org.educa.examen.repository;

import org.educa.examen.entity.FilmEntity;

import java.util.List;

public interface FilmRepository {

    FilmEntity findById(Integer id);

    List<FilmEntity> findAll();

    boolean add(FilmEntity filmEntity);

    boolean update(Integer id, FilmEntity filmEntity);

    boolean delete(Integer id);
}
