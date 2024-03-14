package examen.psp.ra2;

import java.util.concurrent.Semaphore;

public class Cine {

    Semaphore s = new Semaphore(5);
    private static int tiempo = 850;

    public void abrir() {
        String[] pelis = {
                "El Padrino",
                "El Señor de los Anillos",
                "Interestelar",
                "Titanic",
                "El Club de la Lucha",
                "La Lista de Schindler",
                "El Caballero de la Noche",
                "La Vida es Bella",
                "El Gran Hotel Budapest",
                "Pulp Fiction"
        };

        for (int i = 0; i < pelis.length; i++) {
            Pelicula p = new Pelicula(pelis[i], this);
            p.start();
        }
    }

    public void entrarSala(String peli, int dur){
        try {
            s.acquire();
            verPeli(peli, dur);
            s.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void verPeli(String peli, int dur){
        if ((tiempo - dur) > 0) {
            System.out.println("||PUDO VERSE|| La pelicula " + peli + " ha empezado. Duracion: " + dur);
            tiempo = tiempo - dur;
        } else {
            System.out.println("||NO PUDO VERSE|| La pelicula " + peli + " no pudo ser proyectada dado que su tiempo restante seria: " + (tiempo-dur));
            tiempo = tiempo - dur;
        }
    }

}
