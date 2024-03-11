package org.educa.examen.exceptions;

import lombok.Getter;

@Getter
public class ClientNotFoundException extends Exception {
    private final Integer id;

    public ClientNotFoundException(Integer id) {
        this.id = id;
    }
}
