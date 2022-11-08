package TPE;

import java.util.Comparator;
import java.util.Iterator;

public class ListaVinculada implements Iterable<Nodo> {
    private int size;
    private Comparator criterio;

    private Nodo NInicio ;

    public ListaVinculada(Comparator comparador){ 
        this.NInicio = new Nodo();
        this.criterio = comparador;
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
        	if (this.criterio != null)
        		NInicio.getNSiguiente().addOrdenado(newNodo, criterio);
        	else
        		NInicio.getNSiguiente().add(newNodo);
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

    public int getSize() {
        return this.size;
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


