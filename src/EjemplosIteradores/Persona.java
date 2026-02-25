package EjemplosIteradores;

public class Persona {
    int edad;
    String nombre;
    Persona(String nombre){
        this.nombre=nombre;
        edad=0;
    }

    public Persona(int edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
