package org.educa.examen.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FilmDTO {
    @NotNull
    private Integer id;
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    private Integer year;
    @NotNull
    private Integer duration;
}
