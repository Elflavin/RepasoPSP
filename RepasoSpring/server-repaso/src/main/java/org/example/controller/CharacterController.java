package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.CharacterDTO;
import org.example.mapper.CharacterMapper;
import org.example.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Character")
public class CharacterController {

    private final CharacterService characterService;
    private final CharacterMapper characterMapper;

    @Autowired
    public CharacterController(CharacterService characterService, CharacterMapper characterMapper) {
        this.characterService = characterService;
        this.characterMapper = characterMapper;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<String> create(@RequestBody @Valid CharacterDTO characterDTO){
        System.out.println(characterDTO.toString());
        characterService.create(characterMapper.toCharacter(characterDTO));
        return new ResponseEntity<>("Personaje creado correctamente!", HttpStatus.CREATED);
    }

    @GetMapping(path = "/get/{name}")
    public ResponseEntity<CharacterDTO> get(@PathVariable("name") String name){
        CharacterDTO characterDTO;
        try {
            characterDTO = characterMapper.toDTO(characterService.get(name));
            return ResponseEntity.ok(characterDTO);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<CharacterDTO>> getAll(){
        return ResponseEntity.ok(characterMapper.toDTOs(characterService.getAll()));
    }

    @DeleteMapping(path = "/delete/{name}")
    public ResponseEntity<String> delete(@PathVariable("name")String name){
        characterService.delete(name);
        return new ResponseEntity<>("Personaje eliminado sin problemas!", HttpStatus.OK);
    }

    @PutMapping(path = "/put")
    public ResponseEntity<String> put(@RequestBody @Valid CharacterDTO characterDTO){
        characterService.update(characterDTO.getName(), characterMapper.toCharacter(characterDTO));
        return new ResponseEntity<>("Personaje actualizado!", HttpStatus.OK);
    }
}
