import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

public class EjemHasTable {
    static Hashtable<String, Persona> ht = new Hashtable<String, Persona>();
    static Hashtable<Clave, Persona> ht2 = new Hashtable<Clave, Persona>();
    static Hashtable<Integer, Integer> ht4 = new Hashtable<Integer, Integer>(33, (float) 0.75);

    static void crearHashTableEnteros() {
        ht4.put(3, 32);
        ht4.put(1, 11);
        ht4.put(2, 2);
        Integer aux;
        System.out.println("tamano ht4: "+ht4.size());
        for (int i = 0; i < 33; i++)
            if ((aux=ht4.put(i, i * 10)) !=null)
                System.out.println("valor anterior de la clave " + i + " es:"+aux);
        System.out.println("tamano ht4"+ht4.size());
        System.out.println("Valor asociado a la clave 2:"+ht4.get(2));
    }

    static void crearHashTableSimple() {
        ht.put("Juan", new Persona("Juan", 1, 100));
        ht.put("Ana", new Persona("Ana", 2, 200));
        ht.put("Jose", new Persona("Jose", 4, 400));
        Persona p = new Persona("Oscar", 3, 300);
        ht.put(p.nombre, p);
        Persona px = ht.get("Ana");
        System.out.println("nombre:" + px.nombre + "    edad:" + px.edad);
    }
    static void listarHashTableSimple2(){
//No está ordenado por ningún criterio, tampoco por el orden de inserción
        Persona p;
        Collection<Persona> listaPersonas = ht.values();  //ht.values().stream().forEach(System.out::println);
        Iterator<Persona> it=listaPersonas.iterator();
        System.out.println("LISTADO");
        while(it.hasNext()) {
            p=it.next();
            if (p.edad%2==0)
              System.out.println(p.nombre+" "+p.edad);
        }
    }

    public static void main(String[] args) {
       // EjemHasTable.crearHashTableEnteros();
        EjemHasTable.crearHashTableSimple();
        EjemHasTable.listarHashTableSimple2();
    }
}

