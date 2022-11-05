package TPE;

import java.util.Comparator;
import java.util.Iterator;

// a) Insertar un nuevo elemento en la estructura. 
// b) Eliminar un elemento de la estructura dado una posicion. 
// c) Eliminar todas las ocurrencias de un elemento de la estructura dado el elemento. 
// d) Obtener la posicion de la primera ocurrencia de un elemento dado. 
// e) Un mecanismo que permita recorrer uno a uno los elementos de la lista. 
// f) Permitir cambiar la forma en la que se ordenan los elementos (con el subsecuente reordenamiento de los elementos ya almacenados.

public class ListaVinculada implements Iterable<Nodo> {
    private int size;
    private Comparator criterio;

    private Nodo NInicio ;

    public ListaVinculada(){ 
        this.NInicio = new Nodo();
    }

    public ListaVinculada(Comparator c){ 
        this.NInicio = new Nodo();
        this.criterio = c;
    }

    // a) Insertar un nuevo elemento en la estructura. 
    public void addDato (Object n){
        Nodo newNodo = new Nodo();
        newNodo.setValor(n);
        size++;
        if ( NInicio.getNSiguiente() == null) {
            NInicio.setNSiguiente(newNodo);
            newNodo.setNAnterior(NInicio);
        } else {
            NInicio.getNSiguiente().addOrdenado(newNodo, criterio);
        }  
    }

    // b) Eliminar un elemento de la estructura dado una posición. 
    public void deleteDato (int pos){
        if (pos > 0 && size >= pos) {
            NInicio.getNSiguiente().deleteOnPosition(pos, 1);
            size--;
        }
    }

    // c) Eliminar todas las ocurrencias de un elemento de la estructura dado el elemento. 
    public void deleteOcurrencias(Object o){
        int i = this.NInicio.getNSiguiente().deleteTodasOcurrencias(o);
        size -= i;
    }

    // d) Obtener la posicion de la primera ocurrencia de un elemento dado.
    public int posElemento(Object o) {
        int i = NInicio.getNSiguiente().getPosElemento(o, 1);
        return i;
    }

  
    // f) Permitir cambiar la forma en la que se ordenan los elementos (con el subsecuente reordenamiento de los elementos ya almacenados.
    public void setComparator(Comparator criterio){
        this.criterio = criterio;
    }

    public void order(){
        int i = size;
        while (i > 1) {
            this.NInicio.getNSiguiente().ordenar(i, criterio, 1);
            i--;
        }
    }

    @Override
    public String toString() {

        return NInicio.getNSiguiente().toString();
    }

	@Override
	public Iterator<Nodo> iterator() {
		// TODO Auto-generated method stub
		return new IteratorListVinculada();
	}
	
	protected class IteratorListVinculada implements Iterator<Nodo> {

		protected Nodo nodoIterador;
		private int pos;
		
        public IteratorListVinculada()   
        { 
        	this.pos = 1;
        	this.nodoIterador = NInicio;
        }
        
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
	        return (pos == 0 && nodoIterador == null)  || (nodoIterador != null && nodoIterador.getNSiguiente() != null);
		}

		@Override
		public Nodo next() {
			// TODO Auto-generated method stub
			Nodo next;
			if (pos == 0)
				next = this.nodoIterador;
			else
				next = this.nodoIterador = this.nodoIterador.getNSiguiente();
			
			pos++;
			return next;
		}
		
	}
}


