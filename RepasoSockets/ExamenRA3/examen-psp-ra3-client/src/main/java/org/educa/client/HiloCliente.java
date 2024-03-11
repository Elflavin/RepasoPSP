package org.educa.client;

import java.io.*;

public class HiloCliente extends Thread{

    private String msg;
    private DataInputStream in;
    private DataOutputStream out;

    public HiloCliente(String nombre, String msg, DataOutputStream out, DataInputStream in){
        this.setName(nombre);
        this.msg = msg;
        this.in = in;
        this.out = out;
    }

    @Override
    public void run(){
        try {
            out.writeUTF(msg + "\n");
            out.flush();
            System.out.println(this.getName() + ": Mensaje " + msg + " enviado.");
            if (msg.equalsIgnoreCase("cuat")){
                    System.out.println("\nLa longitud total es: " + in.readInt());
            }
        } catch (Exception e){
            System.out.println("Error en el cliente\nDescripcion: " + e.toString());
        }
    }
}
