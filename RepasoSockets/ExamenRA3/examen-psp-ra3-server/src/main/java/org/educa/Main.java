package org.educa;

import org.educa.server.Server;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        System.out.println("Creando socket servidor");
        Server server = new Server();
        server.execute();
    }
}