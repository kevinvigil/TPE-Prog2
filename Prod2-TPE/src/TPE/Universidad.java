package TPE;

public class Universidad {

	private String nombre;
	private ListaVinculada grupoAbstracto;
	
	
	public Universidad(String nombre) {
		this.nombre = nombre;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
