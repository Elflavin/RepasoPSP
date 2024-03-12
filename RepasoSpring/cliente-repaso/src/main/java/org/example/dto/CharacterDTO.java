package org.example.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
public class CharacterDTO {
    @NonNull
    private String name;
    @NonNull
    private String age;
    @NonNull
    private String source;
}
