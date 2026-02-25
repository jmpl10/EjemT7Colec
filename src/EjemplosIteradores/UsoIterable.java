package EjemplosIteradores;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class UsoIterable {
    static void recorrerPersonas(){
        Scanner sc= new Scanner(System.in);
        List<Persona> lista= new LinkedList<>();
        for (int i=0; i<5; i++) {
            System.out.println("Dar nombre");
            String nombre=sc.nextLine();
            lista.add(new Persona(nombre));
        }
        for (Persona p: lista)
            System.out.println(p);
    }
    static void recorrerInteger(){
        int v[]={4,5,66,77,44};
        for (Integer i:v)
            System.out.println(i);
    }
    static void recorrerVectorInteger(){
        Vector<Integer> v= new Vector <Integer>();
        for (int i=0; i<10; i++)
            v.add(i);
        for (Integer i:v){
            System.out.println(i);
            if (i%2==0)
                v.remove(i);
        }
    }
    static void modificarHashPersonas(){
        Hashtable <String, Persona> ht= new Hashtable <String, Persona>();
        System.out.println("Recorrido con foreach");
        ht.put("Juan", new Persona(3, "Juan"));
        for (Persona p:ht.values()) {
            System.out.println(p.nombre+":"+p.edad);
            if (p.edad>=3) {
                ht.put("xxx", new Persona(33, "xxx"));
                ht.remove("Juan");
                System.out.println("anadida");
            }
       }
    }
    static void usoIterator(){
        System.out.println("Listado con for con iterator");
        List <String> palabras= Arrays.asList("uno", "dos", "tres");
        for (Iterator <String> it = palabras.iterator();  it.hasNext();) {
            String objeto = it.next();
            System.out.println(objeto);
//También se puede hacer con System.out.println( it.next());
// en lugar de las 2 líneas anteriores
        }
    }
    static void modificacionIterador(){
        List<String> palabras = new LinkedList<String>();
        palabras.add("dos2");
        palabras.add("tres3");
        Iterator it = palabras.iterator();
        palabras.add("cuatro4");  //No debes modificar la colección aquí
        for (;it.hasNext();)
            System.out.println(it.next());
        }
        static void borrarConIterator(){
            List <String> palabras= new ArrayList<>();
            palabras.add("uno");
            palabras.add("dos");
            palabras.add("tres");
            for (Iterator <String> it= palabras.iterator();it.hasNext();){
                String s= (String) it.next();
                if (s.equals("dos"))
                        it.remove();
            }
            System.out.println("Después de borrar queda:");
            for(String s:palabras)
                System.out.println(s);

        }
        static void borrarIteradorInteger(){
            Vector <Integer> v= new Vector <Integer>();
            for (int i=0;i<10; i++)
                v.add(i);
            int i=0;
            Integer num;
            for (Iterator <Integer> it=v.iterator();it.hasNext();){
                num=it.next();
                if (num%2==0)
                    it.remove();  //Elimina el último elemento recuperado con next()
            }
            v.stream().forEach(System.out::println);
        }
    public static void main(String[] args) {
        UsoIterable.borrarConIterator();
    }




}
