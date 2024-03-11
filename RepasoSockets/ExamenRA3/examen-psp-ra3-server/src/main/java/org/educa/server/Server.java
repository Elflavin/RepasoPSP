package org.educa.server;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void execute() {
        try (ServerSocket serverSocket = new ServerSocket(5000)){
            System.out.println("Server iniciado");
            while (true) {
                Socket socket = null;
                socket = serverSocket.accept();
                System.out.println("Conexion establecida: " + socket + "\nGenerando un nuevo hilo para responder a la peticion..");
                HiloServer h = new HiloServer(socket);
                h.start();
            }

        } catch (Exception e) {
            System.out.println("Error en el server\nDescripcion del error: " + e.toString());
        }
    }
}


