package org.educa.server;

import java.io.*;
import java.net.Socket;

public class HiloServer extends Thread {

    Socket socket;
    private static int sumaEdad = 0;

    public HiloServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {

            // Recibir mensaje
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String msg = in.readUTF();
            System.out.println("Mensaje recibido: " + msg);

            String[] mensaje = msg.split(":");
            int edad = Integer.parseInt(mensaje[1].trim());
            sumaEdad(edad);

            // Enviar mensaje
            out.writeInt(sumaEdad);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void sumaEdad(int edad){
        sumaEdad = sumaEdad + edad;
        System.out.println("Edad actual: " + sumaEdad);
    }
}
