package TPE.Comparadores.compAlumnosYGrupos;

import java.util.Comparator;

import TPE.GrupoAbstracto;

public class ComparadorPorCantidad implements Comparator<GrupoAbstracto>{

    @Override
    public int compare(GrupoAbstracto o1, GrupoAbstracto o2) {
        return o1.compareTo(o2);
    }
    
}
