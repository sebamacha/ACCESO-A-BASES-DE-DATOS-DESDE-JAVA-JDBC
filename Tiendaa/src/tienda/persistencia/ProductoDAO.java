package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;

import tienda.entidad.Fabricante;
import tienda.entidad.Producto;


public final class ProductoDAO extends DAO {

	 private final Fabricante fabricante;

	    public ProductoDAO() {
	        this.fabricante = new Fabricante();
	    }

	    public void guardarProducto(Producto producto) throws Exception {
	        try {
	            if (producto == null) {
	                throw new Exception("Debe indicar el producto");
	            }
	            String sql = "INSERT INTO Producto (codigo_fabricante, precio, nombre, codigo) "
	            	    + "VALUES ( '" + producto.getCodigoFabricante() + "' , '" + producto.getPrecio() +
	            	    "' ,'" + producto.getNombre() +  "' , '" + producto.getCodigo() + "')";


	            System.out.println(sql);
	            insertarModificarEliminar(sql);
	        } catch (Exception e) {
	            throw e;
	        } finally {
	            desconectarBase();
	        }
	    }

	    public void modificarProducto(Producto producto) throws Exception {
	        try {
	            if (producto == null) {
	                throw new Exception("Debe indicar que producto desea modificar");
	            }
	            String sql = "UPDATE Producto SET "
	            	    + "codigo_fabricante = '" + producto.getCodigoFabricante() + "', precio = '" + producto.getPrecio() + "', nombre = '" + producto.getNombre()
	            	    + "' WHERE codigo = '" + producto.getCodigo() + "'";
	            insertarModificarEliminar(sql);
	        } catch (Exception e) {
	            throw e;
	        } finally {
	            desconectarBase();
	        }
	    }

	    public void eliminarProducto(int codigo) throws Exception {
	        try {
	            String sql = "DELETE FROM Producto WHERE codigo = " + codigo;
	            insertarModificarEliminar(sql);
	        } catch (Exception e) {
	            throw e;
	        } finally {
	            desconectarBase();
	        }
	    }


	    public Producto buscarProductoPorCodigo(int codigo) throws Exception {
	        try {
	            String sql = "SELECT * FROM Producto WHERE codigo = " + codigo;
	            consultarBaseDatos(sql);
	            Producto producto = null;
	            while (resultado.next()) {
	                producto = new Producto();
	                producto.setCodigo(resultado.getInt(1));
	                producto.setNombre(resultado.getString(2));
	                producto.setPrecio(resultado.getDouble(3));
	                producto.setCodigoFabricante(resultado.getInt(4));
	            }
	            desconectarBase();
	            return producto;
	        } catch (Exception e) {
	            desconectarBase();
	            throw e;
	        }
	    }

	    

	    public Collection<Producto> listarProductos() throws Exception {
	        try {
	            String sql = "SELECT * FROM Producto";
	            consultarBaseDatos(sql);
	            Producto producto = null;
	            Collection<Producto> productos = new ArrayList();
	            while (resultado.next()) {
	                producto = new Producto();
	                producto.setCodigo(resultado.getInt(1));
	                producto.setNombre(resultado.getString(2));
	                producto.setPrecio(resultado.getDouble(3));
	                producto.setCodigoFabricante(resultado.getInt(4));
	                productos.add(producto);
	            }
	            desconectarBase();
	            return productos;
	        } catch (Exception e) {
	            e.printStackTrace();
	            desconectarBase();
	            throw e;
	        }
	    }

	}