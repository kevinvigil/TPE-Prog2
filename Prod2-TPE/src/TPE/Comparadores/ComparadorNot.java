package TPE.Comparadores;

import java.util.Comparator;

import TPE.Alumno;

public class ComparadorNot implements Comparator{

    private Comparator comparador;
	
	public ComparadorNot(Comparator comparador) {
		this.comparador = comparador;
	}

	@Override
	public int compare(Object o1, Object o2) {
		return - this.comparador.compare(o1, o2);
		
	}
}
