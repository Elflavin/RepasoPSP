package org.educa.examen.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmDTO {
    private Integer id;
    private String name;
    private Integer duration;
    private Integer year;
}
