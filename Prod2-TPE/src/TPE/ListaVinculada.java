package TPE;

public class ListaVinculada {

    private int size;

    private Nodo NSiguiente;

    public void addDato (Nodo n){
        size++;
        if (this.NSiguiente == null)
        	this.NSiguiente = n;
        else {
        	NSiguiente.setNSiguiente(n);
        }
        	
    }

    public void deleteDato (int pos){
        if (pos > 0 && size >= pos) {
            NSiguiente.deleteOnPosition(pos);
            size--;
        }
    }
    
 
}