public class Mesero extends Usuario {

    public int id_mesero;

    // representa al mesero: toma pedidos, agrega o elimina platos y entrega pedidos
    public Mesero(String nombre, String documento, String telefono, int id_mesero) {
        super(nombre, documento, telefono);
        this.id_mesero = id_mesero;
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
    }

    public Pedido tomar_pedido(int id_pedido, Cliente cliente, int mesa) {
        // crea un objeto Pedido con id_pedido, el cliente y la mesa
        Pedido pedido = new Pedido(id_pedido, cliente, mesa);
        System.out.println(
            "Pedido " + id_pedido + " creado para mesa " + mesa + " / Cliente " + cliente.nombre
        );
        return pedido; // devuelve el pedido para que el controlador lo almacene
    }

    public void agregar_plato_a_pedido(Pedido pedido, Plato plato, int cantidad) {
        // delega la accion a la clase Pedido
        pedido.agregar_plato(plato, cantidad);
    }

    public void eliminar_plato_de_pedido(Pedido pedido, int id_plato) {
        pedido.eliminar_plato_pedido(id_plato);
    }

    public void entregar_pedido(Pedido pedido) {
        // cambia el estado del pedido a "Entregado"
        pedido.cambiar_estado_pedido("Entregado");
    }

    public void ver_menu(Menu menu) {
        // el mesero puede ver el menu
        menu.mostrar_menu();
    }
}
