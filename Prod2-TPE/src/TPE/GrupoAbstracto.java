package TPE;

public abstract class GrupoAbstracto implements Comparable{

	private String nombre;

	public GrupoAbstracto(String n){
		this.nombre = n;
	}

	public abstract int getCantidad();

	@Override
	public int compareTo(Object o) {
		GrupoAbstracto j = (GrupoAbstracto) o;
		return this.getCantidad() - j.getCantidad();
	}

	public String getNombre() {
        return nombre;
    }

	public void setNombre(String nombre) {
        this.nombre = nombre;
    }
	
}
