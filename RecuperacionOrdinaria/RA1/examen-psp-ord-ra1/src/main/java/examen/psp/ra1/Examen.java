package examen.psp.ra1;

import examen.psp.ra1.contador.Contador;

public class Examen {

    public static final String COMMAND = "src/main/resources/contadorPalbarasVocales.jar";

    public static void main(String args[]) {
        Contador contador = new Contador(COMMAND);
        contador.contar();
    }

}
