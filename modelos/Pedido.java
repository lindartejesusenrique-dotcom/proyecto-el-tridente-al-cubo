import java.util.ArrayList;

public class Pedido {

    public int id_pedido;
    public Usuario usuario;
    public ArrayList<PlatoPedido> platos_pedidos;
    public double total;
    public String estado;
    public int mesa;
    public boolean entregado;

    public Pedido(int id_pedido, Usuario usuario, int mesa) {
        this.id_pedido = id_pedido;
        this.usuario = usuario;
        this.platos_pedidos = new ArrayList<>();
        this.total = 0;
        this.estado = "En proceso";
        this.mesa = mesa;
        this.entregado = false;
    }

    // agrega platos al pedido
    public void agregar_plato(Plato plato, int cantidad) {

        if (plato == null) {
            System.out.println("Plato no encontrado");
            return;
        }

        if (plato.eliminado == true) {
            System.out.println(
                "Plato " + plato.nombre + " eliminado no se puede agregar"
            );
            return;
        }

        // se respeta la misma logica del Python
        if (plato.disponibilidad == false) {
            System.out.println(
                "Plato " + plato.nombre + " no disponible no se puede agregar"
            );
            return;
        }

        PlatoPedido plato_pedido = new PlatoPedido(plato, cantidad);
        platos_pedidos.add(plato_pedido);
    }

    // elimina un plato del pedido
    public void eliminar_plato_pedido(int id_plato) {

        boolean encontrado = false;

        for (PlatoPedido plato_pedido : platos_pedidos) {
            if (plato_pedido.plato.id_plato == id_plato) {
                platos_pedidos.remove(plato_pedido);
                System.out.println(
                    "Plato " + plato_pedido.plato.nombre + " eliminado correctamente"
                );
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Plato no encontrado");
        }
    }

    public void actualizar_cantidad_platos(int id_plato, int nueva_cantidad) {

        boolean encontrado = false;

        for (PlatoPedido plato_pedido : platos_pedidos) {
            if (plato_pedido.plato.id_plato == id_plato) {
                plato_pedido.cantidad = nueva_cantidad;
                System.out.println(
                    "La nueva cantidad del plato " +
                    plato_pedido.plato.nombre +
                    " en el pedido es " +
                    plato_pedido.cantidad
                );
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Plato no encontrado");
        }
    }

    // recalcula el total del pedido
    public double calcular_total() {

        total = 0;

        for (PlatoPedido plato_pedido : platos_pedidos) {
            total += plato_pedido.plato.precio * plato_pedido.cantidad;
        }

        return total;
    }

    public void cambiar_estado_pedido(String nuevo_estado) {
        estado = nuevo_estado;
        System.out.println(
            "El estado del pedido " + id_pedido + " fue cambiado a " + estado
        );
    }

    public void mostrar_pedido() {

        System.out.print(
            "Pedido " + id_pedido + " pertenece a " + usuario.nombre + " y contiene ["
        );

        for (PlatoPedido plato_pedido : platos_pedidos) {
            System.out.print(plato_pedido.plato.nombre + " ");
        }

        System.out.println("]");
    }

    // marca el pedido como entregado
    public void entregar() {

        if (entregado) {
            System.out.println("El pedido " + id_pedido + " ya fue entregado");
            return;
        }

        entregado = true;
        cambiar_estado_pedido("Entregado");
        System.out.println("El pedido " + id_pedido + " fue entregado");
    }

    // confirma el pedido
    public void confirmar() {

        if (estado.toLowerCase().equals("confirmado")) {
            System.out.println("El pedido " + id_pedido + " ya fue confirmado");
            return;
        }

        estado = "Confirmado";
        System.out.println(
            "El pedido " + id_pedido + " fue confirmado exitosamente"
        );
    }
}