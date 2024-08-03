package supermercado;

import java.util.ArrayList;
import java.util.List;

class Cajera extends Thread {
    private String nombre;
    private List<Cliente> clientes;

    public Cajera(String nombre) {
        this.nombre = nombre;
        this.clientes = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public void run() {
        long tiempoTotalCobro = 0;

        for (Cliente cliente : clientes) {
            System.out.println("Cajero " + nombre + " está cobrando a " + cliente.nombre);

            double costoTotal = 0;
            long tiempoCobroCliente = 0;

            for (Producto producto : cliente.carrito) {
                System.out.println("Procesando producto: " + producto.nombre);

                long inicioProcesamiento = System.currentTimeMillis();

                try {
                    Thread.sleep(3000); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                long tiempoProcesamiento = System.currentTimeMillis() - inicioProcesamiento;
                tiempoCobroCliente += tiempoProcesamiento;
                costoTotal += producto.precio;

                System.out.println("Tiempo de procesamiento para " + producto.nombre + ": " + tiempoProcesamiento + " ms");
            }

            tiempoTotalCobro += tiempoCobroCliente;

            System.out.println("Cobro completado para " + cliente.nombre);
            System.out.println("Costo total de la compra para " + cliente.nombre + ": $" + costoTotal);
            System.out.println("Tiempo total de cobro para " + cliente.nombre + ": " + tiempoCobroCliente + " ms");
        }

        System.out.println("Tiempo total de cobro para todas las compras atendidas por " + nombre + ": " + tiempoTotalCobro + " ms");
    }
}
