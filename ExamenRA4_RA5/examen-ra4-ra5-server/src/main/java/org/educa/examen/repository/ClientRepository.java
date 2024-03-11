package org.educa.examen.repository;

import org.educa.examen.entity.Client;

import java.util.List;

public interface ClientRepository {

    Client findById(Integer id);

    List<Client> findAll();

    boolean add(Client client);

    boolean update(Integer id, Client client);

    boolean delete(Integer id);
}
