package TPE.Comparadores;

import java.util.Comparator;

import TPE.Alumno;

public class ComparadorPorDNI implements Comparator<Alumno>{

    @Override
    public int compare(Alumno o1, Alumno o2) {
        int i;
        if (o1.getDNI()>o2.getDNI()) {
            i = 1;
        }else if (o1.getDNI()<o2.getDNI()) {
            i = -1;
        }else{
            i = 0;
        }
        return i;
    }
    
}
