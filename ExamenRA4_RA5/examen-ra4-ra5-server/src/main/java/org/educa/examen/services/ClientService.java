package org.educa.examen.services;

import org.educa.examen.entity.Client;
import org.educa.examen.repository.ClientRepository;
import org.educa.examen.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService implements ClientRepository{
    private final SecurityUtil securityUtil;
    List<Client> clients = new ArrayList<>();

    @Autowired
    public ClientService(SecurityUtil securityUtil) {
        this.securityUtil = securityUtil;
    }

    @Override
    public Client findById(Integer id) {
        for (Client c : clients){
            if(c.getId() == id){
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Client> findAll() {
        return clients;
    }

    @Override
    public boolean add(Client client) {
        if (client != null){
            try {
                client.setFingerprint(securityUtil.createHash(client.getEmail()));
                client.setEmail(securityUtil.crypt(client.getEmail()));
                client.setNif(securityUtil.crypt(client.getNif()));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            clients.add(client);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Integer id, Client client) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
