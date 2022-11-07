package TPE.Comparadores.compAlumnosYGrupos;

import java.util.Comparator;

import TPE.Alumno;

public class ComparadorPorApellido implements Comparator<Alumno>{
    
    public int compare(Alumno o1, Alumno o2) {
        return o1.getApellido().compareTo(o2.getApellido());
    }

}
