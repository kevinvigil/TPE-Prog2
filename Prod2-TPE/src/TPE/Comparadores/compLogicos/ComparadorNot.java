package TPE.Comparadores.compLogicos;

import java.util.Comparator;

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
