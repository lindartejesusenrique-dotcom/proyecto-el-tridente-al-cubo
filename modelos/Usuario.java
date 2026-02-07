public class Usuario {

    public String nombre;
    public String documento;
    public String telefono;

    // Clase padre para Administrador / Cliente / Mesero
    // Reutiliza atributos basicos
    public Usuario(String nombre, String documento, String telefono) {
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
    }
}
