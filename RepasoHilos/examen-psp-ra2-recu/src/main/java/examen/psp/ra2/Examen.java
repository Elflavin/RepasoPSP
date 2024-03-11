package examen.psp.ra2;

public class Examen {

    public static void main(String[] args) {

        AreaRestringida areaRestringida = new AreaRestringida();
        try {
            areaRestringida.execute();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
