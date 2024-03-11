package org.educa.examen.repository.inmemory;

import org.educa.examen.entity.Client;
import org.educa.examen.repository.ClientRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InMemoryClientRepository implements ClientRepository {
    private final Map<Integer, Client> clients = new HashMap<>();

    @Override
    public Client findById(Integer id) {
        return clients.get(id);
    }

    @Override
    public List<Client> findAll() {
        return new ArrayList<>(clients.values());
    }

    @Override
    public boolean add(Client client) {
        if (!clients.containsKey(client.getId())) {
            clients.put(client.getId(), client);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(Integer id, Client client) {
        if (clients.containsKey(id)) {
            clients.remove(id);
            clients.put(client.getId(), client);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(Integer id) {
        if (clients.containsKey(id)) {
            clients.remove(id);
            return true;
        } else {
            return false;
        }
    }
}
