package tienda.entidad;

public class Producto {
	
	private int codigo;
	private String nombre;
	private double precio;
	private int codigoFabricante;
	
	//constructores y setter an getter 
	public Producto() {
		super();
	}

	public Producto(int codigo, String nombre, double precio, int codigoFabricante) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.codigoFabricante = codigoFabricante;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCodigoFabricante() {
		return codigoFabricante;
	}

	public void setCodigoFabricante(int codigoFabricante) {
		this.codigoFabricante = codigoFabricante;
	}
	
	

}
