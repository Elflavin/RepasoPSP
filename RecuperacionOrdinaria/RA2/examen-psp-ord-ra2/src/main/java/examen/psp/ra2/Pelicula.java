package examen.psp.ra2;

public class Pelicula extends Thread{

    private String nom = "";
    private int dur = 0;
    Cine c;
    public Pelicula(String nom, Cine c){
        this.nom = nom;
        this.c = c;
        switch (nom){
            case "El Padrino":
                dur = 175;
                break;
            case "El Señor de los Anillos":
                dur = 178;
                break;
            case "Interestelar":
                dur = 169;
                break;
            case "Titanic":
                dur = 195;
                break;
            case "El Club de la Lucha":
                dur = 139;
                break;
            case "La Lista de Schindler":
                dur = 195;
                break;
            case "El Caballero de la Noche":
                dur = 152;
                break;
            case "La Vida es Bella":
                dur = 116;
                break;
            case  "El Gran Hotel Budapest":
                dur = 99;
                break;
            case "Pulp Fiction":
                dur = 154;
                break;
        }

    }

    @Override
    public void run(){
        c.entrarSala(nom, dur);
    }

}
