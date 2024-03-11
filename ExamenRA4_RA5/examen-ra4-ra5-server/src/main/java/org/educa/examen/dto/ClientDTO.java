package org.educa.examen.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDTO {
    @NotNull
    private Integer id;
    private String fingerprint;
    @NotBlank
    private String nif;
    @NotBlank
    @NotNull
    private String name;
    @NotBlank
    @Email
    @NotNull
    private String email;
}
