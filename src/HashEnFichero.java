import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class HashEnFichero {
    final static String FICHEROPROPERTIES ="properties.dat";
    static void escritura(){
        Properties p = new Properties();
        p.setProperty("clave1A","Juan");
        p.setProperty("clave2B","Pepe");
        p.setProperty("clave3C","Ana");
        try (OutputStream fo= new FileOutputStream(FICHEROPROPERTIES)){
            p.store(fo, "escritura Realizada");
        }catch (Exception e){
            System.out.println("Error");
        }
    }
    static void añadir(){
        try (OutputStream fo= new FileOutputStream
                (FICHEROPROPERTIES, true)){
            Properties p = new Properties();
            p.setProperty("clave4D","Oscar" );
            p.setProperty("clave5E","Marta");
            p.store(fo, null);
        }catch (Exception e) {
            System.out.println("Error");
        }
    }
    static void lecturaClaves() {
        try (InputStream fi = new FileInputStream(FICHEROPROPERTIES)) {
            Properties p = new Properties();
            p.load(fi);
            String clavePepe = p.getProperty("Pepe");
            System.out.println("Clave de Pepe:" + clavePepe);
            String claveNoExiste = p.getProperty("No existe"); //null
            System.out.println("Clave de No existe:" + claveNoExiste);
            System.out.println("TODOS los usuarios.");
            for (String s : p.stringPropertyNames())
                System.out.println(s+"="+p.getProperty(s));

        } catch (Exception e) {
            System.out.println("Error");
        }
    }
        public static void main(String[] args) {
           // escritura();
          //  añadir();
            lecturaClaves();

        }

    }
