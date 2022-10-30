package TPE.Comparadores;

import java.util.Comparator;

import TPE.Alumno;

public class ComparadorAnd implements Comparator<Alumno> {
    
    private Comparator<Alumno> c1;
	private Comparator<Alumno> c2;
	
	public ComparadorAnd(Comparator<Alumno> c1, Comparator<Alumno> c2) {
		this.c1 = c1;
		this.c2 = c2;
	}
	
	@Override
	public int compare(Alumno a1, Alumno a2) {
		int resultado = this.c1.compare(a1, a2);
		if (resultado == 0)
			resultado = this.c2.compare(a1, a2);
		return resultado;
	}
}
