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
        this.size = 0;
    }

    // a) Insertar un nuevo elemento en la estructura. 
    public void addDato (Object n){
        Nodo newNodo = new Nodo();
        newNodo.setValor(n);
        size++;
        if (NInicio.getNSiguiente() == null) {
            NInicio.setNSiguiente(newNodo);
        } else {
        	if (this.criterio != null) {
        		addNodoOrdenado(newNodo);
        	} else {
                addNodo(newNodo);
            }
        }  
    }

    public void addNodo (Nodo newNodo){
        Nodo nodoEstructura = NInicio.getNSiguiente();
        while (nodoEstructura.getNSiguiente() != null)
        	nodoEstructura = nodoEstructura.getNSiguiente();
        
        nodoEstructura.setNSiguiente(newNodo);
        this.size++;
    }
    
    public void addNodoOrdenado (Nodo newNodo){
    	  Nodo nodoSiguiente = this.NInicio.getNSiguiente();
    	  Nodo nodoAnterior = this.NInicio;
    	  Boolean insertado = false;
    	  while (!insertado) {
    		int i = criterio.compare( newNodo.getValor(), nodoSiguiente.getValor());
            
            if (i > 0) {
                if (nodoSiguiente.getNSiguiente() == null) {
                	nodoSiguiente.setNSiguiente(newNodo);
                	insertado = true;
                    this.size++;
                } else {
                	nodoAnterior = nodoSiguiente;
                	nodoSiguiente = nodoSiguiente.getNSiguiente();
                }
            } else {
            	nodoAnterior.setNSiguiente(newNodo);
            	newNodo.setNSiguiente(nodoSiguiente);
                insertado = true;
                this.size++;
            }
    	}
    }
    
    // b) Eliminar un elemento de la estructura dado una posición. 
    public void deleteDato (int pos){
    	int iterador = 0;
    	Nodo nodoIterador = this.NInicio;
    	Nodo nodoAnterior = this.NInicio;
    
        while (iterador < pos && nodoIterador != null) {
        	nodoAnterior = nodoIterador;
        	nodoIterador = nodoIterador.getNSiguiente();
        	iterador++;
        }
        
        if (nodoIterador != null) {
        	nodoAnterior.setNSiguiente(nodoIterador.getNSiguiente());
        	nodoIterador = null;
            this.size--;
        }
    }
    
    // c) Eliminar todas las ocurrencias de un elemento de la estructura dado el elemento. 
    public void deleteOcurrencias(Object o){
    	Nodo nodoIterador = this.NInicio.getNSiguiente();
    	Nodo nodoAnterior = this.NInicio;
    
        while (nodoIterador != null) {
            if (nodoIterador.equals(o)) {
            	nodoAnterior.setNSiguiente(nodoIterador.getNSiguiente());
                this.size--;
            } else {
            	nodoAnterior = nodoIterador;
            }
        	nodoIterador = nodoIterador.getNSiguiente();
        }
    }

    // d) Obtener la posicion de la primera ocurrencia de un elemento dado.
    public int posElemento(Object o) {
        int iterador = 1;
    	Nodo nodoIterador = this.NInicio.getNSiguiente();

        while (nodoIterador != null && !nodoIterador.equals(o)) {
        	nodoIterador = nodoIterador.getNSiguiente();
        	iterador++;
        }
        
        if (nodoIterador == null){
            iterador = -1;
        }

        return iterador;        
    }

    // f) Permitir cambiar la forma en la que se ordenan los elementos (con el subsecuente reordenamiento de los elementos ya almacenados.
    public void setComparator(Comparator criterio){
        this.criterio = criterio;
    }

    public void order(){
        int i = size;
        int j = size;
        Nodo primero;
        Nodo segundo;
        Nodo base;
        while (i > 1) {
            base = this.NInicio;
            primero = this.NInicio.getNSiguiente();
            segundo = primero.getNSiguiente();
            while (j > 1) {
                if (criterio.compare(primero.getValor(), segundo.getValor()) > 1) {
                    intercambio(base, primero, segundo);
                }
                base = primero;
                primero = segundo;
                if (segundo.getNSiguiente() != null) {
                    segundo = segundo.getNSiguiente();
                }
                j--;
            }
            i--;
            j = i;
        }
    }

    public void intercambio (Nodo base, Nodo primero, Nodo segundo){
        base.setNSiguiente(segundo);
        primero.setNSiguiente(segundo.getNSiguiente());
        segundo.setNSiguiente(primero);
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


