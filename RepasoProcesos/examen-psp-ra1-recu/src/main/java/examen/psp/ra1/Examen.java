package examen.psp.ra1;

import examen.psp.ra1.comando.Comando;

public class Examen {

    //Comando a ejecutar para usar el CMD
    public static final String[] COMMAND = {"cmd.exe", "/c"};

    public static void main(String[] args) {

        Comando comando = new Comando();
        comando.ejecutar(COMMAND);
    }

}
