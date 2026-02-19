public class Clave {
    int codigo;
    String xxx;

    public Clave(int codigo, String xxx) {
        this.codigo = codigo;
        this.xxx=xxx;
    }
    public int hashCode() {
//Si no se codifica hashCode se usa el por defecto
        final int prime = 31;
        int result = 1;
        result = prime * result + codigo;
        result = prime * result + ((xxx == null) ? 0 : xxx.hashCode());
        return result;
    }
    public boolean equals(Object obj) {
         return codigo==((Clave)obj).codigo && xxx==((Clave)obj).xxx;
    }
}
