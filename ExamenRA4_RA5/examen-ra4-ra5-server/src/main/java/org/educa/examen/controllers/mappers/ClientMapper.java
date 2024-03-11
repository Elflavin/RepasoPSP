package org.educa.examen.controllers.mappers;

import org.educa.examen.dto.ClientDTO;
import org.educa.examen.entity.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public ClientDTO toDTO(Client client){
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setEmail(client.getEmail());
        clientDTO.setId(client.getId());
        clientDTO.setName(client.getName());
        clientDTO.setNif(client.getNif());
        clientDTO.setFingerprint(client.getFingerprint());
      return   clientDTO;
    }

    public Client toClient(ClientDTO clientDTO){
        Client client = new Client();
        client.setEmail(clientDTO.getEmail());
        client.setFingerprint(clientDTO.getFingerprint());
        client.setId(clientDTO.getId());
        client.setName(clientDTO.getName());
        client.setNif(clientDTO.getNif());
        return client;
    }

}
