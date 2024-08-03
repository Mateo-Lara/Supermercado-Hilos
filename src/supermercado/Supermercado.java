package supermercado;
public class Supermercado {
    public static void main(String[] args) {
        Producto Televisor = new Producto("Televisor", 2500000);
        Producto Gaseosa = new Producto("Gaseosa", 10000);
        Producto Audifonos = new Producto("Audifonos", 500000);

        Cliente cliente1 = new Cliente("Mateo Lara");
        cliente1.agregarProducto(Televisor);
        cliente1.agregarProducto(Gaseosa);

        Cliente cliente2 = new Cliente("Simón Lara");
        cliente2.agregarProducto(Audifonos);
        cliente2.agregarProducto(Gaseosa);
        
        Cliente cliente3 = new Cliente("Santiago Henao");
        cliente3.agregarProducto(Audifonos);
        cliente3.agregarProducto(Televisor);
        cliente3.agregarProducto(Gaseosa);
        


        Cajera cajera1 = new Cajera("Jose Trujillo");
        Cajera cajera2 = new Cajera("Heyner Mena");
        
        cajera1.agregarCliente(cliente1);
        cajera1.agregarCliente(cliente2);
        
        cajera2.agregarCliente(cliente3);
        
        cajera1.start();
        cajera2.start();
        
        try {
        cajera1.join();
        cajera2.join();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

        System.out.println("Todos los clientes han sido atendidos");
    }
}

