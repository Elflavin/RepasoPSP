package org.example.crud;

import org.example.dto.CharacterDTO;
import org.example.handler.HttpHandler;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CharacterCrud {

    private final String BASE_URL = "http://localhost:8080/Character";
    private HttpHandler handler = new HttpHandler();
    private Scanner sc = new Scanner(System.in);

    public void create() throws IOException, InterruptedException {
        System.out.println("Escribe el nombre del personaje: ");
        String name = sc.next();
        System.out.println("Escribe su edad: ");
        String age = sc.next();
        System.out.println("Escribe su procedencia: ");
        String source = sc.next();

        CharacterDTO characterDTO = new CharacterDTO(name, age, source);
        handler.create(BASE_URL + "/create", characterDTO);
    }

    public void get() throws IOException, InterruptedException {
        System.out.println("Escribe el nombre del personaje que buscas: ");
        String name = sc.next();
        CharacterDTO characterDTO = handler.get(BASE_URL + "/get/" + name);
        if (characterDTO != null) {
            System.out.println("Personaje encontrado: " + characterDTO.toString());
        } else {
            System.out.println("No se ha encontrado a ningun personaje llamado " + name);
        }
    }

    public void getAll() throws IOException, InterruptedException {
        List<CharacterDTO> characterDTOList = handler.getAll(BASE_URL + "/getAll");
        if (characterDTOList != null) {
            System.out.println("Lista de personajes\n===============");
            for (CharacterDTO c :
                    characterDTOList) {
                System.out.println(c.toString());
            }
        } else {
            System.out.println("Upss, algo ha salido mal!");
        }
    }

    public void delete() throws IOException, InterruptedException {
        System.out.println("Escribe el nombre del personaje que quieres eliminar: ");
        String name = sc.next();
        handler.delete(BASE_URL + "/delete/" + name);
    }

    public void update() throws IOException, InterruptedException {
        System.out.println("Escribe el nombre del personaje que quieres actualizar: ");
        String name = sc.next();
        System.out.println("Escribe su nueva edad: ");
        String age = sc.next();
        System.out.println("Escribe su nueva procedencia: ");
        String source = sc.next();

        CharacterDTO characterDTO = new CharacterDTO(name, age, source);
        handler.update(BASE_URL + "/put", characterDTO);
    }

}
