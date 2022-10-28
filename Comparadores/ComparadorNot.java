package TPE.Comparadores;

import java.util.Comparator;

import TPE.Alumno;

public class ComparadorNot implements Comparator<Alumno>{

    private Comparator<Alumno> comparador;
	
	public ComparadorNot(Comparator<Alumno> comparador) {
		this.comparador = comparador;
	}

	@Override
	public int compare(Alumno a1, Alumno a2) {
		return - this.comparador.compare(a1, a2);
	}
}
