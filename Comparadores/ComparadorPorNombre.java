package TPE.Comparadores;

import java.util.Comparator;

import TPE.Alumno;

public class ComparadorPorNombre implements Comparator<Alumno>{

    public int compare(Alumno o1, Alumno o2) {
        return o1.getNombre().compareTo(o2.getNombre());
    }
    
}
