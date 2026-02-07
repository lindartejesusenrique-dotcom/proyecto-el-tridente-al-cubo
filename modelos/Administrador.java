package modelos;


public class Administrador extends Usuario {

    public int id_administrador;
    public int siguiente_id;

    public Administrador(int id_administrador, String nombre, String documento, String telefono) {
        super(nombre, documento, telefono);
        this.id_administrador = id_administrador;
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
        this.siguiente_id = 1;
    }

    // GESTION DEL MENU --- Funciones del administrador

    public void agregar_platos(Menu menu, Plato plato) {
        // no se valida nada, el controlador ya valido los datos
        menu.agregar_plato(plato);
    }

    public void eliminar_platos(Menu menu, int id_plato) {
        menu.eliminar_plato(id_plato);
    }

    public void ver_menu(Menu menu) {
        menu.mostrar_menu();
    }

    public void cambiar_disponibilidad_plato(Menu menu, int id_plato) {
        for (Plato plato : menu.platos) {
            if (plato.id_plato == id_plato) {
                plato.cambiarDisponibilidad();
                System.out.println(
                    "Disponibilidad del plato " + plato.nombre + " cambiada a " + plato.disponibilidad
                );
                return;
            }
        }
        System.out.println("Plato no encontrado");
    }

    public void editar_platos(
            Menu menu,
            int id_plato,
            Double nuevo_precio,
            String nuevo_nombre,
            String nueva_categoria
    ) {

        Plato plato = menu.buscar_platos(id_plato);

        if (plato == null) {
            System.out.println("Error el plato no existe");
            return;
        }

        // editar nombre
        if (nuevo_nombre != null) {
            if (!nuevo_nombre.equals("")) {
                try {
                    plato.nombre = nuevo_nombre;
                    System.out.println("Nombre del plato actualizado a: " + nuevo_nombre);
                } catch (Exception e) {
                    System.out.println("Error: ingrese datos correctos para nombre dese la funcion");
                }
            } else {
                plato.nombre = plato.nombre;
                System.out.println(
                    "El nombre del plato " + plato.nombre + " quedo igual: " + plato.nombre
                );
            }
        }

        // editar precio
        if (nuevo_precio != null) {
            plato.precio = nuevo_precio;
            System.out.println("Precio actualizado a: " + nuevo_precio);
        }

        // editar categoria
        if (nueva_categoria != null) {
            if (!nueva_categoria.equals("")) {
                try {
                    plato.categoria = nueva_categoria;
                    System.out.println("Categoria actualizada a: " + nueva_categoria);
                } catch (Exception e) {
                    System.out.println("Error: ingrese datos correctos para la categoria");
                }
            } else {
                plato.categoria = plato.categoria;
                System.out.println(
                    "La categoria del plato quedo igual " + plato.categoria
                );
            }
        }
    }
}

