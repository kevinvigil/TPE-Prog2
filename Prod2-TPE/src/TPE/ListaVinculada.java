package TPE;

import java.util.Comparator;

// a) Insertar un nuevo elemento en la estructura. 
// b) Eliminar un elemento de la estructura dado una posición. 
// c) Eliminar todas las ocurrencias de un elemento de la estructura dado el elemento. 
// d) Obtener la posición de la primera ocurrencia de un elemento dado. 
// e) Un mecanismo que permita recorrer uno a uno los elementos de la lista. 
// f) Permitir cambiar la forma en la que se ordenan los elementos (con el subsecuente reordenamiento de los elementos ya almacenados.

public class ListaVinculada {

    private int size;
    private Comparator h;

    private Nodo NSiguiente;

    // a) Insertar un nuevo elemento en la estructura. 
    public void addDato (Object n){
        Nodo foo = new Nodo();
        foo.setValor(foo);
        size++;
        if (this.NSiguiente == null)
        	this.NSiguiente = foo;
        else if (h == null) {
        	NSiguiente.add(foo);
        } else {
            NSiguiente.addOrdenado(foo, h);
        }
    }

    // b) Eliminar un elemento de la estructura dado una posición. 
    public void deleteDato (int pos){
        if (pos >= 0 && size > pos) {
            NSiguiente.deleteOnPosition(pos, 0);
            size--;
        }
    }

    // c) Eliminar todas las ocurrencias de un elemento de la estructura dado el elemento. 
    public void deleteOcurrencias(Object o){
        int i = NSiguiente.deleteTodasOcurrencias (o);
        size -= i;
    }

    // d) Obtener la posición de la primera ocurrencia de un elemento dado.
    public int posElemento(Object o) {
        return NSiguiente.getPosElemento(o, 0);
    }

    // e) Un mecanismo que permita recorrer uno a uno los elementos de la lista. 

    // f) Permitir cambiar la forma en la que se ordenan los elementos (con el subsecuente reordenamiento de los elementos ya almacenados.
    public void setComparator(Comparator j){
        this.h = j;
    }

    public void order(){
        int i = size;
        while (i > 1) {
            this.NSiguiente.ordenar(i, h, 1);
            i--;
        }
    }
}
