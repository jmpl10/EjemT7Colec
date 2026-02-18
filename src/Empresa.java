import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Empresa {
    Vector<Persona> empleados;
    Empresa () {
        empleados= new Vector<Persona>(30);
    }
    boolean anadir (String nombre, int edad){
        boolean encontrado=false;
        //No se puede añadir si la persona ya existe en el vector (el nombre ya existe)
        encontrado=empleados.contains(new Persona(nombre));
  /*   for (Persona p: empleados)
            if (p.nombre.equals(nombre))
                encontrado=true;*/
        if(!encontrado) {
            Persona p = new Persona(nombre, edad);
            empleados.add(p);
        }
        return encontrado;
    }
    void listar(){
   /*     for(int i=0; i<empleados.size(); i++)
            System.out.println(empleados.elementAt(i));*/
        for (Persona miPers: empleados)
            System.out.println(miPers);
    }
    boolean eliminar(String nombre){
        boolean eliminado=false;
      //  eliminado=empleados.removeElement(new Persona(nombre));
        eliminado=empleados.remove(empleados.indexOf(new Persona(nombre)))!=null;
        return eliminado;
    }
    boolean modificarEdad(String nombre, int edad){
        boolean modificado=false;
        Persona p= new Persona(nombre);
     /*  int posEmpleado= empleados.indexOf(p);
        if (posEmpleado>=0) {
            empleados.elementAt(posEmpleado).edad = edad;
            modificado = true;
        }
        */
        for (int i=0; i<empleados.size(); i++)
            if (empleados.elementAt(i).nombre.equals(nombre)) {
                empleados.elementAt(i).edad=edad;
                modificado=true;
            }
        return modificado;
    }
    boolean modificarNombre (String nombre, String nuevoNombre){
        boolean modificado=false;
        int pos= empleados.indexOf(new Persona(nombre));
        if (pos>=0) {
            int edad=empleados.elementAt(pos).edad;
            Persona p= new Persona(nuevoNombre,edad);
            empleados.setElementAt(p, pos);
            modificado=true;
        }
       return modificado;
    }
    void listarOrdenado(){
        List<Persona> listaOrdenada= empleados;
        Collections.sort(listaOrdenada);
        for (Persona miPers: listaOrdenada)
            System.out.println(miPers);
    }
    void menu(){
        Scanner sc= new Scanner(System.in);
        int opc=0;
        String nombre;
        int edad;
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
                     nombre= sc.nextLine();
                    System.out.println("Introducir edad");
                    edad= Integer.parseInt(sc.nextLine());
                    anadir(nombre, edad);
                    break;
                case 2:  System.out.println("Introducir nombre");
                     nombre= sc.nextLine();
                      if( eliminar (nombre))
                          System.out.println("Eliminado");
                      else System.out.println("No se ha encontrado, no se ha podido eliminar");
                    break;
                case 3:  System.out.println("Introducir nombre");
                    nombre= sc.nextLine();
                    System.out.println("Introducir edad");
                    edad= Integer.parseInt(sc.nextLine());
                    modificarEdad(nombre, edad);
                    break;
                case 4:System.out.println("Introducir nombre");
                    nombre= sc.nextLine();
                    System.out.println("Introducir Nuevo nombre");
                   String nuevoNombre= sc.nextLine();
                    System.out.println("Se ha modificado "+ modificarNombre(nombre, nuevoNombre));
                    break;
                case 5:
                    listar();
                    break;
                    case 6: listarOrdenado();
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
