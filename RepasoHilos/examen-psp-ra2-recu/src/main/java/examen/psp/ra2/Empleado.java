package examen.psp.ra2;

public class Empleado extends Thread{

    public Empleado(String nombre){
        this.setName(nombre);
    }

    @Override
    public void run(){
        AreaRestringida.entrada(this.getName());
    }

}
