package tienda.servicios;

import java.util.List;
import java.util.Scanner;

public class TiendaServiceMenu {
    private ProductoService productoService;
    private FabricanteService fabricanteService;
    
    public TiendaServiceMenu() {
        this.productoService = new ProductoService();
        this.fabricanteService = new FabricanteService();
    }
    
    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        
        boolean salir = false;
        while (!salir) {
            System.out.println("Menú:");
            System.out.println("a) Lista el nombre de todos los productos que hay en la tabla producto.");
            System.out.println("b) Lista los nombres y los precios de todos los productos de la tabla producto.");
            System.out.println("c) Listar aquellos productos que su precio esté entre 120 y 202.");
            System.out.println("d) Buscar y listar todos los Portátiles de la tabla producto.");
            System.out.println("e) Listar el nombre y el precio del producto más barato.");
            System.out.println("f) Ingresar un producto a la base de datos.");
            System.out.println("g) Ingresar un fabricante a la base de datos.");
            System.out.println("h) Editar un producto con datos a elección.");
            System.out.println("i) Salir.");
            
            System.out.print("Ingrese una opción: ");
            String opcion = scanner.nextLine();
            
            try {
            	if (opcion.equals("a")) {
            	    // Lista el nombre de todos los productos que hay en la tabla producto.
            	    List<String> nombresProductos = productoService.listarNombresProductos();
            	    System.out.println("Listado de Productos");
                    System.out.println("*********************");
            	    for (String nombre : nombresProductos) {
            	        System.out.println(nombre);
            	    }
            	

                  
                } else if (opcion.equals("b")) {
                    // Lista los nombres y los precios de todos los productos de la tabla producto.
                    // Aquí debes llamar al método correspondiente de la clase ProductoService
                } else if (opcion.equals("c")) {
                    // Listar aquellos productos que su precio esté entre 120 y 202.
                    // Aquí debes llamar al método correspondiente de la clase ProductoService
                } else if (opcion.equals("d")) {
                    // Buscar y listar todos los Portátiles de la tabla producto.
                    // Aquí debes llamar al método correspondiente de la clase ProductoService
                } else if (opcion.equals("e")) {
                    // Listar el nombre y el precio del producto más barato.
                    // Aquí debes llamar al método correspondiente de la clase ProductoService
                } else if (opcion.equals("f")) {
                    // Ingresar un producto a la base de datos.
                    // Aquí debes pedir al usuario los datos del producto y luego llamar al método correspondiente de la clase ProductoService
                } else if (opcion.equals("g")) {
                    // Ingresar un fabricante a la base de datos.
                    // Aquí debes pedir al usuario los datos del fabricante y luego llamar al método correspondiente de la clase FabricanteService
                } else if (opcion.equals("h")) {
                    // Editar un producto con datos a elección.
                    // Aquí debes pedir al usuario los datos del producto y luego llamar al método correspondiente de la clase ProductoService
                } else if (opcion.equals("i")) {
                    salir = true;
                } else {
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        scanner.close();
    }
}
