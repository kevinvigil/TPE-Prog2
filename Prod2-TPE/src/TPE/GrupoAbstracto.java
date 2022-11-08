package TPE;

public abstract class GrupoAbstracto implements Comparable{

	private String nombre;

	public GrupoAbstracto(String nombre){
		this.nombre = nombre;
	}

	public abstract int getCantidad();
	public abstract void Print();

	@Override
	public int compareTo(Object o) {
		GrupoAbstracto grupo = (GrupoAbstracto) o;
		return grupo.getCantidad() - this.getCantidad();
	}

	public String getNombre() {
        return nombre;
    }

	public void setNombre(String nombre) {
        this.nombre = nombre;
    }
	
}
