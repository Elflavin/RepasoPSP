package org.example.repository;

import java.util.List;
import org.example.entity.Character;

public interface CharacterRepository {

    public void create(Character character);
    public List<Character> getAll();
    public Character get(String name);
    public void delete(String name);
    public void update(String name, Character character);
}
