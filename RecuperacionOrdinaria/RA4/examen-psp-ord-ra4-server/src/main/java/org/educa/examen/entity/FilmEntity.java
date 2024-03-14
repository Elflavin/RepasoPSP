package org.educa.examen.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmEntity {
    private Integer id;
    private String name;
    private Integer year;
    private Integer duration;
}
