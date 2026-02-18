import java.util.Scanner;
import java.util.Vector;

public class Empresa {
    Vector<Persona> empleados;
    Empresa () {
        empleados= new Vector<Persona>(30);
    }
    boolean anadir (String nombre, int edad){
        //No se puede añadir si la persona ya existe en el vector (el nombre ya existe)
        Persona p= new Persona(nombre, edad);
        empleados.add(p);
        return true;
    }
    void listar(){
   /*     for(int i=0; i<empleados.size(); i++)
            System.out.println(empleados.elementAt(i));*/
        for (Persona miPers: empleados)
            System.out.println(miPers);
    }
    void menu(){
        Scanner sc= new Scanner(System.in);
        int opc=0;
        System.out.println ("1-Añadir empleado");
        System.out.println("2-Eliminar empleado");
        System.out.println("3-Modificar edad");
        System.out.println("4-Modificar Nombre"); //Crear una nueva persona que sustituya a la anterior
        System.out.println("5-Listar empleados");
        System.out.println("6-listar ordenado por edad");
        do  {
            System.out.println("Dar opc ");
            opc= Integer.parseInt(sc.nextLine());
            switch (opc) {
                case 1:
                    System.out.println("Introducir nombre");
                    String nombre= sc.nextLine();
                    System.out.println("Introducir edad");
                    int edad= Integer.parseInt(sc.nextLine());
                    anadir(nombre, edad);
                    break;
                case 2:
                    listar();
                    break;
            }
        }while (opc !=0);

    }
    public static void main(String[] args) {
        Empresa e= new Empresa();

        e.menu();
        Persona p1=new Persona("Juan", 25);
        Persona p2=new Persona("Pedro", 26);
        if (p1.equals(p2)) System.out.println("Son iguales");
    }
}
