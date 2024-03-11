package org.educa;

import org.educa.client.HiloCliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String[] messages = new String[]{"U", "Do", "Tre", "Cuat"};

        try {
            Socket socket;

            for (int i = 0; i < 4; i++) {
                socket = new Socket("127.0.0.1", 5000);
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                DataInputStream in = new DataInputStream(socket.getInputStream());
                HiloCliente h = new HiloCliente("Cliente " + (i + 1), messages[i],out, in);
                h.start();
                h.join();
            }
        } catch (Exception e) {
            System.out.println("Error en main\nDescripcion: " + e.toString());
        }

    }
}
