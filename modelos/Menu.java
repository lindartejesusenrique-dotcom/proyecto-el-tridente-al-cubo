package modelos;

import modelos.Plato;
import modelos.Pedido;
import modelos.Plato_Pedido;
import modelos.Usuario;
import modelos.Administrador;
import modelos.Cliente;
import modelos.Mesero;
import java.util.ArrayList;

public class Menu {

    public ArrayList<Plato> platos;
    public int administrador_id;
    public int platos_id;
    public int pedidos_id;
    public int meseros_id;
    public int clientes_id;

    public Menu() {
        this.platos = new ArrayList<>();
        this.administrador_id = 1;
        this.platos_id = 1;
        this.pedidos_id = 1;
        this.meseros_id = 1;
        this.clientes_id = 1;
    }

    // generador de IDs para administrador
    public int generar_id_administrador() {
        int id_generador_administrador = administrador_id;
        administrador_id++;
        return id_generador_administrador;
    }

    // generador de IDs para platos
    public int generar_id_platos() {
        int id_generador_platos = platos_id;
        platos_id++;
        return id_generador_platos;
    }

    // generador de IDs para pedidos
    public int generar_id_pedidos() {
        int id_generador_pedidos = pedidos_id;
        pedidos_id++;
        return id_generador_pedidos;
    }

    // generador de IDs para meseros
    public int generar_id_meseros() {
        int id_generador_meseros = meseros_id;
        meseros_id++;
        return id_generador_meseros;
    }

    // generador de IDs para clientes
    public int generar_id_clientes() {
        int id_generador_clientes = clientes_id;
        clientes_id++;
        return id_generador_clientes;
    }

    // se agrega un plato al menu
    public void agregar_plato(Plato plato) {
        platos.add(plato);
        System.out.println(
            "El plato " + plato.nombre + " fue agregado correctamente al menu"
        );
    }

    // se muestran los platos del menu
    public void mostrar_menu() {

        System.out.println("MENU DEL DIA");

        for (Plato plato : platos) {

            if (platos.isEmpty()) {
                System.out.println("No hay platos en el menu");
                return;
            }

            System.out.println(plato.mostrar_informacion());
        }

        System.out.println(" ");
    }

    // elimina un plato segun su ID
    public void eliminar_plato(int id_plato) {

        boolean encontrado = false;

        for (Plato plato : platos) {
            if (plato.id_plato == id_plato) {
                platos.remove(plato);
                System.out.println(
                    "Plato " + plato.nombre + " eliminado correctamente"
                );
                plato.eliminado = true;
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Plato no encontrado");
        }

        System.out.println(" ");
    }

    // busca un plato por ID
    public Plato buscar_platos(int id_plato) {

        for (Plato plato : platos) {
            if (plato.id_plato == id_plato) {
                return plato;
            }
        }

        return null;
    }

    // muestra solo los platos disponibles
    public String platos_disponibles() {

        String disponibles = "";

        for (Plato plato : platos) {
            // se respeta EXACTAMENTE la comparación del Python
            if (plato.disponibilidad.equals("Disponible")) {
                disponibles += plato.mostrar_informacion() + "\n";
            }
        }

        if (disponibles.equals("")) {
            System.out.println(" ");
        }

        return disponibles;
    }
}
