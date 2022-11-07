package TPE;

import java.util.Comparator;

public class Grupo extends GrupoAbstracto{

	private ListaVinculada grupos;
	
	public Grupo(String nombre,Comparator comparador) {
		super(nombre);
		grupos = new ListaVinculada(comparador);
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


	@Override
	public void Print() {
		// TODO Auto-generated method stub
		System.out.println("Grupo: "+ this.getNombre()+ "/ "+ this.getCantidad());
		for(Nodo nodo : grupos) {
			GrupoAbstracto grupo = (GrupoAbstracto)nodo.getValor();
			grupo.Print();
		}
		
		
		System.out.println("############################################## \n");
	}
}
