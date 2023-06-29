package tienda.servicios;
import tienda.persistencia.*;

import java.util.ArrayList;
import java.util.List;

public class ProductoService extends DAO {
    public List<String> listarNombresProductos() throws Exception {
        List<String> nombres = new ArrayList<>();
        try {
            String sql = "SELECT nombre FROM Producto";
            consultarBaseDatos(sql);
            while (resultado.next()) {
                nombres.add(resultado.getString(1));
            }
            desconectarBase();
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
        return nombres;
    }
    
    // Agrega aquí otros métodos relacionados con la gestión de productos
}
