package TPE;

public class Grupo extends GrupoAbstracto{

	private ListaVinculada grupos;
	
	
	public Grupo() {
		super();
		grupos = new ListaVinculada();
	}


	@Override
	public int getCantidad() {
		int total = 0;
		for(Nodo nodo : grupos) {
			GrupoAbstracto grupo = (GrupoAbstracto)nodo.getValor();
			total += grupo.getCantidad();
		}
		return total;
	}

	public void AddElemento(GrupoAbstracto grupo) {
		grupos.addDato(grupo);
	}
}
