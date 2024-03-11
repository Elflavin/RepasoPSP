package examen.psp.ra1.comando;

import java.io.*;
import java.util.Scanner;

public class Comando {

    /**
     * Método a crear, podéis crear otros metodos dentro de esta clase si así lo creeis oprtuno.
     * No es necesario crear nuevas clases dentro del proyecto.
     *
     */
    public void ejecutar(String[] COMMAND) {

        try (Scanner sc = new Scanner(System.in)){
            System.out.println("Escribe el comando que quieras ejecutar: ");
            String msg = sc.next();

            ProcessBuilder pb = new ProcessBuilder(COMMAND[0], COMMAND[1], msg);
            Process process = pb.start();

            System.out.println("Recibiendo mensaje...");
            recibir(process);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void recibir(Process process) throws IOException {
        InputStream in = process.getInputStream();
        InputStreamReader ins = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(ins);
        String line;

        System.out.println("Imprimiendo lineas\n");

        while ((line = br.readLine())!=null){
            System.out.println(line);
        }
    }

}
