package tienda.servicios;

import java.util.List;

public class NombresProductos {
    ProductoService productoService = new ProductoService();
    
    public void mostrarNombresProductos() {
        try {
            List<String> nombresProductos = productoService.listarNombresProductos();
            System.out.println("Listado de Productos");
            System.out.println("*********************");
            for (String nombre : nombresProductos) {
                System.out.println(nombre);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
