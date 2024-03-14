package org.educa;

import org.educa.client.HiloCliente;

import java.io.IOException;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Socket socket = null;
        try {
            for (int i = 0; i < 5; i++) {
                socket = new Socket("localhost", 5000);
                HiloCliente c = new HiloCliente("Hilo " + i, "Persona " + i, i, socket);
                c.start();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}