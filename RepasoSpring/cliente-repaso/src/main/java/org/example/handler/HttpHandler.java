package org.example.handler;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.dto.CharacterDTO;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class HttpHandler {
    public List<CharacterDTO> getAll(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", MediaType.APPLICATION_JSON_VALUE)
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        List<CharacterDTO> characterDTOList = toDTOlist(response.body());

        if (response.statusCode() == 200){
            return toDTOlist(response.body());
        }
        return null;
    }

    public CharacterDTO get(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200){
            return toDTO(response.body());
        }
        return null;
    }

    public void create(String url, CharacterDTO characterDTO) throws IOException, InterruptedException {
        String body = toJson(characterDTO);
        System.out.println(body);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .header("Content-Type", "application/json")
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 201){
            System.out.println("Personaje creado correctamente!");
        } else {
            System.out.println("Parece que hubo un error creando el personaje...");
            System.out.println("Response id: " + response.statusCode());
        }
    }

    public void delete(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .DELETE()
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200){
            System.out.println("Personaje eliminado correctamente!");
        } else {
            System.out.println("Parece que hubo un error eliminando el personaje...");
        }
    }

    public void update(String url, CharacterDTO characterDTO) throws IOException, InterruptedException {
        String body = toJson(characterDTO);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .PUT(HttpRequest.BodyPublishers.ofString(body))
                .header("Content-Type", "application/json")
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200){
            System.out.println("Personaje actualizado correctamente!");
        } else {
            System.out.println("El personaje no pudo ser actualzado...");
        }
    }

    private String toJson(CharacterDTO characterDTO) {
        Gson gson = new Gson();
        return gson.toJson(characterDTO);
    }

    private CharacterDTO toDTO(String response){
        Gson gson = new Gson();
        return gson.fromJson(response, CharacterDTO.class);
    }

    private List<CharacterDTO> toDTOlist(String body) {
        Gson gson = new Gson();
        java.lang.reflect.Type listType = new TypeToken<List<CharacterDTO>>(){}.getType();
        return gson.fromJson(body, listType);
    }

}
