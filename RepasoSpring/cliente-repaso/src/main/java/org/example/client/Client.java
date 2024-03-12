package org.example.client;

import org.example.crud.CharacterCrud;

import java.io.IOException;
import java.util.Scanner;

public class Client {

    public void run(){
        Scanner sc = new Scanner(System.in);
        CharacterCrud crud = new CharacterCrud();
        boolean salir = false;
        while (!salir){
            System.out.println("~ MENU ~\n1. Crear\n2. Buscar\n3. Mostrar\n4. Actualizar\n5. Eliminar\n0. Salir");

            String op = sc.next();

            switch (op){
                case "1":
                    try {
                        crud.create();
                    } catch (IOException | InterruptedException e) {
                        System.out.println("Error en el create\nDescripcion: " + e.toString());
                    }
                    break;
                case "2":
                    try {
                        crud.get();
                    } catch (IOException | InterruptedException e) {
                        System.out.println("Error en el get\nDescripcion: " + e.toString());
                    }
                    break;
                case "3":
                    try {
                        crud.getAll();
                    } catch (IOException | InterruptedException e) {
                        System.out.println("Error en el getAll\nDescripcion: " + e.toString());
                    }
                    break;
                case "4":
                    try {
                        crud.update();
                    } catch (IOException | InterruptedException e) {
                        System.out.println("Error en el update\nDescripcion: " + e.toString());
                    }
                    break;
                case "5":
                    try {
                        crud.delete();
                    } catch (IOException | InterruptedException e) {
                        System.out.println("Error en el delete\nDescripcion: " + e.toString());
                    }
                    break;
                case "0":
                    System.out.println("Hasta la proxima!");
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida, intentalo de nuevo.");
                    break;
            }

        }
    }

}
