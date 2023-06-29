package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;

import tienda.entidad.Fabricante;

public final class FabricanteDAO extends DAO {

	public void cargarFabricante(Fabricante fabricante) throws Exception {

		try {
			if (fabricante == null) {
				throw new Exception("Ingrese nombre del Fabricante");
			}
			String sql = "INSERT INTO fabricante (codigo, nombre)" + "VALUES ( '" + fabricante.getCodigo() + "' , '"
					+ fabricante.getNombre() + "' );";

			insertarModificarEliminar(sql);
		} catch (Exception e) {
			throw e;
		} finally {
			desconectarBase();
		}
	}
	
	public void modificarUsuario(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar el usuario que desea modificar");
            }

            String sql = "UPDATE Usuario SET "
                    + "codigo = '" + fabricante.getCodigo() + "' WHERE Nombre = '" + fabricante.getNombre() + "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
	public Fabricante buscarFabricantePorCodigo(Integer codigo) throws Exception {
        try {

            String sql = "SELECT * FROM fabricante "
                    + " WHERE codigo = '" + codigo + "'";

            consultarBaseDatos(sql);

            Fabricante fabricante = null;
            while (resultado.next()) {
            	fabricante = new Fabricante();
            	fabricante.setCodigo(resultado.getInt(1));
            	fabricante.setNombre(resultado.getString(2));
                
            }
            desconectarBase();
            return fabricante;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
	public Fabricante listarFabricante() throws Exception {
	    try {
	        String sql = "SELECT codigo FROM Usuario ";

	        consultarBaseDatos(sql);

	        Fabricante fabricante = null;
	        ArrayList Fabricante = new ArrayList();
	        while (resultado.next()) {
	            fabricante = new Fabricante();
	            fabricante.setCodigo(0);
	        
	            ((Collection) fabricante).add(fabricante);
	        }
	        desconectarBase();
	        return fabricante;
	    } catch (Exception e) {
	        e.printStackTrace();
	        desconectarBase();
	        throw new Exception("Error de sistema");
	    }
	}

	
}
