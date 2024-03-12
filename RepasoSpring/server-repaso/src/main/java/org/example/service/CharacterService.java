package org.example.service;

import org.example.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.example.entity.Character;

@Service
public class CharacterService{

    private final CharacterRepository characterRepository;

    @Autowired
    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public void create(Character character) {
        characterRepository.create(character);
    }

    public List<Character> getAll() {
        return characterRepository.getAll();
    }

    public Character get(String name) {
        return characterRepository.get(name);
    }

    public void delete(String name) {
        characterRepository.delete(name);
    }

    public void update(String name, Character character) {
        characterRepository.update(name, character);
    }
}
