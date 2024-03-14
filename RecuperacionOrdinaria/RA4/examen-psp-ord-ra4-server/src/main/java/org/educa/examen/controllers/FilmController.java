package org.educa.examen.controllers;

import jakarta.validation.Valid;
import org.educa.examen.dto.FilmDTO;
import org.educa.examen.mappers.FilmMapper;
import org.educa.examen.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/film")
public class FilmController {
    //TODO: Crear controlador para clientes con su mapper y servicio

    private final FilmService filmService;
    private final FilmMapper filmMapper;

    @Autowired
    public FilmController(FilmService filmService, FilmMapper filmMapper) {
        this.filmService = filmService;
        this.filmMapper = filmMapper;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<String> create(@RequestParam @Valid FilmDTO filmDTO){
        if (filmService.add(filmMapper.toEntity(filmDTO))) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping(path = "/find/{id}")
    public ResponseEntity<FilmDTO> get(@PathVariable("id")String id){
        FilmDTO filmDTO = filmMapper.toDTO(filmService.findById(Integer.parseInt(id)));

        if (filmDTO != null) {
            return new ResponseEntity<>(filmDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id){
        if (filmService.delete(Integer.parseInt(id))){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
