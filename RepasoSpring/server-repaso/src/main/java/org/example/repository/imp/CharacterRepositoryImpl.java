package org.example.repository.imp;

import org.example.entity.Character;
import org.example.repository.CharacterRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CharacterRepositoryImpl implements CharacterRepository {

    List<Character> characterList = new ArrayList<>();

    @Override
    public void create(Character character) {
        characterList.add(character);
    }

    @Override
    public List<Character> getAll() {
        return characterList;
    }

    @Override
    public Character get(String name) {
        Character character;
        for (Character c:
                characterList) {
            if (c.getName().equalsIgnoreCase(name)){
                character = c;
                return character;
            }
        }
        return null;
    }

    @Override
    public void delete(String name) {
        for (Character c:
                characterList) {
            if (c.getName().equalsIgnoreCase(name)){
                characterList.remove(c);
                break;
            }
        }
    }

    @Override
    public void update(String name, Character character) {
        for (Character c:
                characterList) {
            if (c.getName().equalsIgnoreCase(name)){
                c.setAge(character.getAge());
                c.setSource(character.getSource());
                break;
            }
        }
    }
}
