package org.example.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class CharacterDTO {
    @NonNull
    @NotEmpty
    private String name;
    @NonNull
    @NotEmpty
    private String age;
    @NonNull
    @NotEmpty
    private String source;
}
