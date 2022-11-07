package TPE.Comparadores.compLogicos;

import java.util.Comparator;

public class ComparadorAnd implements Comparator {
    
    private Comparator c1;
	private Comparator c2;
	
	public ComparadorAnd(Comparator c1, Comparator c2) {
		this.c1 = c1;
		this.c2 = c2;
	}

	@Override
	public int compare(Object o1, Object o2) {
		int resultado = this.c1.compare(o1, o2);
		if (resultado == 0)
			resultado = this.c2.compare(o1, o2);
		return resultado;
	}
}
