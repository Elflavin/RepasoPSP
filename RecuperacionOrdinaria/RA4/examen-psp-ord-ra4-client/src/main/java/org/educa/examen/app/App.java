package org.educa.examen.app;

import org.educa.examen.dto.FilmDTO;
import org.educa.examen.service.FilmService;

import java.util.Scanner;

public class App {

    FilmService filmService = new FilmService();
    public void run() {
        int option;
        try (Scanner sc = new Scanner(System.in)) {
            do {
                System.out.println("=================================================");
                System.out.println("Welcome to the film client rest.");
                System.out.println("=================================================");
                System.out.println("Choose option");
                System.out.println("0. Exit");
                System.out.println("1. Create film");
                System.out.println("2. Find film by id");
                System.out.println("3. Remove film by id");

                option = sc.nextInt();
                sc.nextLine();

                switch (option) {
                    case 0:
                        System.out.println("Good Bye");
                        break;
                    case 1:
                        createFilm(sc);
                        break;
                    case 2:
                        findFilmById(sc);
                        break;
                    case 3:
                        removeFilmById(sc);
                        break;
                    default:
                        System.out.println("Invalid option");
                }
            } while (option != 0);
        }
    }

    private void createFilm(Scanner sc) {
        System.out.println("Introduce film data:");
        System.out.println("Introduce id:");
        Integer id = sc.nextInt();
        sc.nextLine();
        System.out.println("name:");
        String name = sc.nextLine();
        System.out.println("duration:");
        Integer duration = sc.nextInt();
        sc.nextLine();
        System.out.println("year:");
        Integer year = sc.nextInt();
        sc.nextLine();
        FilmDTO filmDTO = new FilmDTO(id, name, duration, year);

        try {
            if(filmService.createFilm(filmDTO)) {
                System.out.println("Film "+filmDTO.getName()+" was created successfully");
            } else {
                System.out.println("Film "+filmDTO.getName()+" was NOT created");
            }
        } catch (Exception e) {
            System.err.println("Upsss!!! There was a problem!!!" + e);
        }
    }

    private void findFilmById(Scanner sc) {
        System.out.println("Introduce id:");
        Integer id = sc.nextInt();
        sc.nextLine();
        FilmDTO filmDTO = null;
        try {
            filmDTO = filmService.findFilmById(id);
            if (filmDTO != null) {
                printFilm(filmDTO);
            } else {
                System.out.println("The client with ID " + id + " was NOT found");
            }
        } catch (Exception e) {
            System.err.println("Upsss!!! There was a problem!!!" + e);
        }

    }

    private void removeFilmById(Scanner sc) {
        System.out.println("Introduce id:");
        Integer id = sc.nextInt();
        sc.nextLine();
        try {
            if(filmService.removeFilmById(id)) {
                System.out.println("Film with id: "+id+" was removed successfully");
            } else {
                System.out.println("Film with id: "+id+" was NOT removed successfully");
            }
        } catch (Exception e) {
            System.err.println("Upsss!!! There was a problem!!!" + e);
        }

    }

    private void printFilm(FilmDTO filmDTO) {
        System.out.println("=================================================");
        System.out.println("ID: " + filmDTO.getId());
        System.out.println("name: " + filmDTO.getName());
        System.out.println("duration: " + filmDTO.getDuration());
        System.out.println("year: " + filmDTO.getYear());
        System.out.println("=================================================");
    }
}
