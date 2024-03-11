package org.educa.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HiloServer extends Thread {

    private static int thread_number = 4;
    private static int longitud = 0;
    private Socket socket;
    public HiloServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            String msg = in.readUTF();
            System.out.println("Mensaje recibido: " + msg);
            changeNsend(msg, out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private synchronized void changeNsend(String msg, DataOutputStream out) throws IOException {
        System.out.println("Sumando longitud al total...");
        int len = msg.length();
        longitud += len;
        thread_number -= 1;
        System.out.println("-T Para enviar total: " + thread_number);
        if (thread_number <= 0) {
            System.out.println("Longitud total enviandose...");
            out.writeInt(longitud);
        }
    }

}
