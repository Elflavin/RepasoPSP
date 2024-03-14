package org.educa.examen.exceptions;

import lombok.Getter;

@Getter
public class FilmNotFoundException extends Exception {
    private final Integer id;

    public FilmNotFoundException(Integer id) {
        this.id = id;
    }
}
