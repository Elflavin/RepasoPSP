package org.educa.examen.controllers;

import org.educa.examen.controllers.mappers.ClientMapper;
import org.educa.examen.dto.ClientDTO;
import org.educa.examen.dto.TotalDTO;
import org.educa.examen.entity.Client;
import org.educa.examen.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientController {
    //TODO: Crear controlador para clientes con su mapper y servicio
    private final ClientService clientService;
    private final ClientMapper clientMapper;

    @Autowired
    public ClientController(ClientService clientService, ClientMapper clientMapper) {
        this.clientService = clientService;
        this.clientMapper = clientMapper;
    }

    @PostMapping(path = "/client/create")
    public ResponseEntity<String> createCli(@RequestBody ClientDTO clientDTO){
        System.out.println("Datos del cliente recidos: " + clientDTO.getName());
        Client client = clientMapper.toClient(clientDTO);
        if(clientService.add(client)){
            return new ResponseEntity<>("Client created successfully", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Client wasn't created", HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "/cliend/find/{id}")
    public ResponseEntity<ClientDTO> getCli(@PathVariable("id") int id){
        Client client = clientService.findById(id);
        ClientDTO clientDTO = clientMapper.toDTO(client);
        if (client != null) {
            return new ResponseEntity<>(clientDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/client/total")
    public ResponseEntity<TotalDTO> getNCli(){
        int nCli = clientService.findAll().size();
        TotalDTO totalDTO = new TotalDTO(nCli);
        return new ResponseEntity<>(totalDTO, HttpStatus.OK);
    }
}
