package TPE;

import java.util.Comparator;

// a) Insertar un nuevo elemento en la estructura. 
// b) Eliminar un elemento de la estructura dado una posici贸n. 
// c) Eliminar todas las ocurrencias de un elemento de la estructura dado el elemento. 
// d) Obtener la posici贸n de la primera ocurrencia de un elemento dado. 
// e) Un mecanismo que permita recorrer uno a uno los elementos de la lista. 
// f) Permitir cambiar la forma en la que se ordenan los elementos (con el subsecuente reordenamiento de los elementos ya almacenados.

public class ListaVinculada implements Iterator<Nodo>{
	private int posicion;
    private int size;
    private Comparator h;

    private Nodo NSiguiente ;

    //coloco comparador en constructor porque pide (ascendente o descendente,seg鷑 el criterio de orden con el que la lista fue creada)
    public ListaVinculada(Comparator h){
        NSiguiente = new Nodo();
        posicion = 0;
        this.h = h;
    }

    // a) Insertar un nuevo elemento en la estructura. 
    public void addDato (Object n){
        Nodo foo = new Nodo();
        foo.setValor(n);
        size++;
        if (h == null) {
        	NSiguiente.add(foo);
        } else {
            NSiguiente.addOrdenado(foo, h);
        }
    }

    // b) Eliminar un elemento de la estructura dado una posici贸n. 
    public void deleteDato (int pos){
        if (pos > 0 && size >= pos) {
            NSiguiente.getNSiguiente().deleteOnPosition(pos, 1);
            size--;
        }
    }

    // c) Eliminar todas las ocurrencias de un elemento de la estructura dado el elemento. 
    public void deleteOcurrencias(Object o){
        int i = this.NSiguiente.getNSiguiente().deleteTodasOcurrencias(o);
        size -= i;
    }

    // d) Obtener la posici贸n de la primera ocurrencia de un elemento dado.
    public int posElemento(Object o) {
        int i = NSiguiente.getNSiguiente().getPosElemento(o, 1);
        System.out.println(i);
        return i;
    }

  
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

    @Override
    public String toString() {

        return NSiguiente.getNSiguiente().toString();
    }

    // e) Un mecanismo que permita recorrer uno a uno los elementos de la lista. 

    public Iterator<Nodo> Recorrer() {
       
       Iterator<Nodo> it= new Iterator<>();
        while(it.hasNext()) {
        	
        }
			
        return it;
    }
       
	

	public boolean hasNext() {
		return posicion < size;
	}
	
	
	public Nodo Next() {
		posicion++;
		return NSiguiente.getNSiguiente();
	}
}


