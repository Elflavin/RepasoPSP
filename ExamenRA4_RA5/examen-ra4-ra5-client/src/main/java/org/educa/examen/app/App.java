package org.educa.examen.app;

import org.educa.examen.dto.ClientDTO;
import org.educa.examen.dto.TotalDTO;
import org.educa.examen.dto.UserDTO;
import org.educa.examen.service.ClientService;

import java.io.IOException;
import java.util.Scanner;

public class App {

    ClientService clientService = new ClientService();
    UserDTO userDTO = null;
    public void run() {
        int option;
        try (Scanner sc = new Scanner(System.in)) {
            do {
                String userActive = userDTO != null ? userDTO.getUsername() : null;
                System.out.println("=================================================");
                System.out.println("Welcome to the client rest. USER: " + userActive);
                System.out.println("=================================================");
                System.out.println("Choose option");
                System.out.println("0. Exit");
                System.out.println("1. Choose user");
                System.out.println("2. Add client");
                System.out.println("3. Find client");
                System.out.println("4. Get total client number");

                option = sc.nextInt();
                sc.nextLine();

                switch (option) {
                    case 0:
                        System.out.println("Good Bye");
                        break;
                    case 1:
                        chooseUser(sc);
                        break;
                    case 2:
                        addClient(sc);
                        break;
                    case 3:
                        findClient(sc);
                        break;
                    case 4:
                        getTotalNumberClient();
                        break;
                    default:
                        System.out.println("Invalid option");
                }
            } while (option != 0);
        }
    }

    private void chooseUser(Scanner sc) {
        System.out.println("Choose an user");
        System.out.println("1. Admin");
        System.out.println("2. Personal");
        System.out.println("3. User");
        System.out.println("4. No auth");
        int option = sc.nextInt();
        sc.nextLine();

        switch (option) {
            case 1:
                userDTO = new UserDTO("admin", "admin");
                break;
            case 2:
                userDTO = new UserDTO("personal", "personal");
                break;
            case 3:
                userDTO = new UserDTO("user", "user");
                break;
            case 4:
                userDTO = null;
                break;
            default:
                System.out.println("Invalid user");
        }

    }

    private void addClient(Scanner sc) {
        System.out.println("Introduce client data:");
        System.out.println("Introduce id:");
        Integer id = sc.nextInt();
        sc.nextLine();
        System.out.println("NIF:");
        String nif = sc.nextLine();
        System.out.println("name:");
        String name = sc.nextLine();
        System.out.println("email:");
        String email = sc.nextLine();
        ClientDTO clientDTO = new ClientDTO(id, null, nif, name, email);

        try {
            if(clientService.addClient(clientDTO, userDTO)) {
                System.out.println("Client "+nif+" was created successfully");
            } else {
                System.out.println("Client "+nif+" was NOT created");
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Upsss!!! There was a problem!!!" + e);
        }
    }

    private void findClient(Scanner sc) {
        System.out.println("Introduce id:");
        Integer id = sc.nextInt();
        sc.nextLine();
        ClientDTO clientDTO = null;
        try {
            clientDTO = clientService.getClient(id, userDTO);
            if (clientDTO != null) {
                printClient(clientDTO);
            } else {
                System.out.println("The client with ID " + id + " was NOT found");
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Upsss!!! There was a problem!!!" + e);
        }

    }

    private void getTotalNumberClient() {
        TotalDTO totalDTO = null;
        try {
            totalDTO = clientService.getTotalNumberClient(userDTO);
            if (totalDTO != null) {
                System.out.println("=============================================");
                System.out.println("Total clients: " + totalDTO.getTotal());
                System.out.println("=============================================");
            } else {
                System.err.println("Upsss!!! There was a problem!!!");
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Upsss!!! There was a problem!!!" + e);
        }

    }

    private void printClient(ClientDTO clientDTO) {
        System.out.println("=================================================");
        System.out.println("ID: " + clientDTO.getId());
        System.out.println("NIF: " + clientDTO.getNif());
        System.out.println("name: " + clientDTO.getName());
        System.out.println("fingerprint: " + clientDTO.getFingerprint());
        System.out.println("email: " + clientDTO.getEmail());
        System.out.println("=================================================");
    }
}
