package examen.psp.ra2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class AreaRestringida {

    private  static Semaphore acceso = new Semaphore(5);
    private static List<String> exitosos = new ArrayList<>();
    private static List<String> fracasados = new ArrayList<>();
    private static int usos = 10;

    public void execute() throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            Empleado h = new Empleado("Empleado " + i);
            h.start();
            h.join();
        }

        System.out.println("Lista exitosos:\n");
        for (String ex : exitosos) {
            System.out.println(ex);
        }

        System.out.println("Lista fracasos:\n");
        for (String fr : fracasados) {
            System.out.println(fr);
        }
    }

    public static String entrada(String hilo){
        System.out.println(hilo + " esta esperando para entrar.");
        try {
            acceso.acquire();
            System.out.println(hilo + " ha entrado y esta esperando a usar el ordenador");
            if (usos>0) {
                compu(hilo);
                return "lo logro!";
            }
            fracasados.add(hilo);
            acceso.release();
            return "ha fracasado!";
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized void compu(String hilo){
        System.out.println(hilo + " esta usando el ordenador");
        exitosos.add(hilo);
        usos -= 1;
        System.out.println("Usos restantes: " + usos);
        acceso.release();
    }


}
