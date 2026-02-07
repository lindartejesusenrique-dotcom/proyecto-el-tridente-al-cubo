public class Plato_Pedido {

    public Plato plato;     // referencia al objeto Plato
    public int cantidad;    // numero que indica cuantas unidades del plato se pidieron

    // esta clase intermedia une la clase Plato y la clase Pedido
    // cada elemento de platos_pedidos en Pedido sera una instancia de esta clase
    public Plato_Pedido(Plato plato, int cantidad) {
        this.plato = plato;
        this.cantidad = cantidad;
    }
}
