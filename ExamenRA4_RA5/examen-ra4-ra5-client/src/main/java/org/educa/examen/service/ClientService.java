package org.educa.examen.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.educa.examen.dto.ClientDTO;
import org.educa.examen.dto.TotalDTO;
import org.educa.examen.dto.UserDTO;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClientService {

    public String BASE_URL = "http://localhost:8080";

    public boolean addClient(ClientDTO clientDTO, UserDTO userDTO) throws IOException, InterruptedException {
        String clientDTOtoJson = createJson(clientDTO);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/client/create"))
                .header("Content-Type", "application/json")
                .header(userDTO.getUsername(), userDTO.getPassword())
                .POST(HttpRequest.BodyPublishers.ofString(clientDTOtoJson))
                .build();
        return false;
    }

    public ClientDTO getClient(Integer id, UserDTO userDTO) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/client/find" + id))
                .header(userDTO.getUsername(), userDTO.getPassword())
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("GET Response Code: " + response.statusCode());
        System.out.println("Requested client: " + response.body());

        return null;
    }

    public TotalDTO getTotalNumberClient(UserDTO userDTO) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/client/total"))
                .header(userDTO.getUsername(), userDTO.getPassword())
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("GET Response Code: " + response.statusCode());
        System.out.println("Total clients: " + response.body());
        return null;
    }

    public String createJson(ClientDTO clientDTO){
        Gson gson = new Gson();
        return gson.toJson(clientDTO);
    }

}
