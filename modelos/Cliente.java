package modelos;


public class Cliente extends Usuario {

    public int id_cliente;

    // representa al cliente: puede ver el menu, crear pedidos,
    // agregar o eliminar platos, ver el total y el resumen
    public Cliente(String nombre, String documento, String telefono, int id_cliente) {
        super(nombre, documento, telefono);
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
        this.id_cliente = id_cliente;
    }

    public void ver_menu(Menu menu) {
        // el cliente puede ver el menu
        menu.mostrar_menu();
    }

    public Pedido crear_pedido(int id_pedido, int mesa) {
        // crea un objeto Pedido con el cliente como usuario
        Pedido pedido = new Pedido(id_pedido, this, mesa);
        System.out.println("Pedido " + id_pedido + " creado correctamente");
        return pedido; // devuelve el pedido para que el controlador lo guarde
    }

    public void agregar_plato_a_pedido(Pedido pedido, Plato plato, int cantidad) {
        // delega la logica a la clase Pedido
        pedido.agregar_plato(plato, cantidad);
    }

    public void eliminar_plato(Pedido pedido, int id_plato) {
        // delegacion a la clase Pedido
        pedido.eliminar_plato_pedido(id_plato);
    }

    public void ver_total(Pedido pedido) {
        // delegacion para calcular el total desde la clase Pedido
        pedido.calcular_total();
    }

    public void ver_resumen(Pedido pedido) {
        // muestra resumen del pedido
        pedido.mostrar_pedido();
    }
}
