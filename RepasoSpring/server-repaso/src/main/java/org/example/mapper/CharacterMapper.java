package org.example.mapper;

import lombok.NoArgsConstructor;
import org.example.dto.CharacterDTO;
import org.example.entity.Character;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
public class CharacterMapper {

    public CharacterDTO toDTO(Character character){
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName(character.getName());
        characterDTO.setAge(character.getAge());
        characterDTO.setSource(character.getSource());
        return characterDTO;
    }

    public Character toCharacter(CharacterDTO characterDTO){
        Character character = new Character();
        character.setName(characterDTO.getName());
        character.setAge(characterDTO.getAge());
        character.setSource(characterDTO.getSource());
        return character;
    }

    public List<CharacterDTO> toDTOs(List<Character> characterList){
        List<CharacterDTO> characterDTOList = new ArrayList<>();
        for (Character c:
             characterList) {
            characterDTOList.add(toDTO(c));
        }
        return characterDTOList;
    }

}
