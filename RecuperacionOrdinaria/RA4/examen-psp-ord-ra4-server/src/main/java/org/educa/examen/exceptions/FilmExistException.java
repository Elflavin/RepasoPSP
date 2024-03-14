package org.educa.examen.exceptions;

import lombok.Getter;

@Getter
public class FilmExistException extends Exception {
    private final Integer id;

    public FilmExistException(Integer id) {
        this.id = id;
    }
}
