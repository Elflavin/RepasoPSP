package examen.psp.ra1.contador;

import java.io.*;
import java.util.Scanner;

public class Contador {

    private String COMMAND = "";

    public Contador(String command) {
        this.COMMAND = command;
    }

    /**
     * Método a crear, podéis crear otros metodos dentro de esta clase si así lo creeis oprtuno.
     * No es necesario crear nuevas clases dentro del proyecto.
     */
    public void contar() {

        try(Scanner sc = new Scanner(System.in)){
            while (true) {
                System.out.println("Escribe p para contar palabras y v para contar vocales, para acabar escribe FIN");
                String con = sc.nextLine();
                String arg = "";
                if (con.equalsIgnoreCase("v")) {
                    System.out.println("Vas a contar vocales");
                    arg = "-v";
                } else if (con.equalsIgnoreCase("p")) {
                    System.out.println("Vas a contar palabras");
                    arg = "-p";
                } else if (con.equalsIgnoreCase("fin")) {
                    break;
                } else {
                    System.out.println("No es valido...");
                }

                ProcessBuilder pb = new ProcessBuilder("java", "-jar", COMMAND, arg);
                Process process = pb.start();

                OutputStreamWriter out = new OutputStreamWriter(process.getOutputStream());
                BufferedWriter bw = new BufferedWriter(out);

                System.out.println("Escribe la frase que quieres contar: ");
                String msg = sc.nextLine();

                bw.write(msg);
                bw.flush();
                bw.close();


                InputStreamReader in = new InputStreamReader(process.getInputStream());
                BufferedReader br = new BufferedReader(in);
                String line = "";

                while ((line = br.readLine())!=null){
                    System.out.println("El jar ha devuelto: " + line);
                }

            }

            System.out.println("Fin del programa");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
