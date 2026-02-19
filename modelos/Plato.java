public class Plato {

    public int id_plato;
    public String nombre;
    public double precio;
    public String categoria;
    public String disponibilidad;
    public boolean eliminado;

    // Clase que crea los platos que se muestran en el menu
    // y que tambien van relacionadas a pedido
    public Plato(int id_plato, String nombre, double precio, String categoria, String disponibilidad) {

        this.id_plato = id_plato;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;

        // Se respeta EXACTAMENTE la logica del constructor en Python
        // el parametro disponibilidad NO se usa, siempre se asigna "Disponible"
        this.disponibilidad = "Disponible";

        this.eliminado = false;
    }

    // se muestra la informacion de cada plato de acuerdo a su disponibilidad
    public String mostrar_informacion() {

        if (disponibilidad.equals("Disponible")) {
            return "ID: " + id_plato +
                   " /Nombre:" + nombre +
                   "/ Precio:" + precio +
                   "/ Categoria:" + categoria +
                   "/ Disponibilidad: " + disponibilidad;
        } else {
            return "ID: " + id_plato +
                   " /Nombre:" + nombre +
                   "/ Precio:" + precio +
                   "/ Categoria:" + categoria +
                   "/ Disponibilidad: " + disponibilidad;
        }
    }

    // se cambia la disponibilidad de cada plato
    public void cambiarDisponibilidad() {

        if (disponibilidad.equals("Disponible")) {
            disponibilidad = "No Disponible";
        } else {
            disponibilidad = "Disponible";
        }
    }
}