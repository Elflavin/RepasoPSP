package org.educa.examen.service;

import com.google.gson.Gson;
import org.educa.examen.dto.FilmDTO;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FilmService {

    private final String URL = "http://localhost/film/";

    public boolean createFilm(FilmDTO clientDTO) {
        String body = toJson(clientDTO);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "create") )
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        try {
            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 201){
                System.out.println("Personaje creado correctamente");
            } else {
                System.out.println("Algo ha salido mal");
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    public FilmDTO findFilmById(Integer id) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "find/" + id))
                .
        return null;
    }

    public boolean removeFilmById(Integer id) {
        //TODO
        return false;
    }

    private String toJson(FilmDTO characterDTO) {
        Gson gson = new Gson();
        return gson.toJson(characterDTO);
    }

    private FilmDTO toDTO(String response){
        Gson gson = new Gson();
        return gson.fromJson(response, FilmDTO.class);
    }



}
