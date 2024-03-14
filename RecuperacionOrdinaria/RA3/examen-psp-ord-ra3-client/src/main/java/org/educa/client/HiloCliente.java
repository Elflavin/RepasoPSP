package org.educa.client;

import java.io.*;
import java.net.Socket;

public class HiloCliente extends Thread{

    private String persona;
    private int edad;
    String msg;
    Socket socket;

    public HiloCliente(String nom, String nPer, int edad, Socket socket){
        this.setName(nom);
        this.persona = nPer;
        this.edad = edad;
        this.socket = socket;
        this.msg = "La persona " + persona + " tiene : " + edad;
    }

    @Override
    public void run(){
        try {
            // Enviar mensaje

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            out.writeUTF(msg);
            out.flush();
            out.close();

            // Recibir mensaje
            System.out.println("Total edades actual: " + in.readInt());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
