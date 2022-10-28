package TPE;

public class List {

    private int size;

    private Nodo NSiguiente;

    public void addDato (Nodo n){
        size++;
    }

    public void deleteDato (int pos){
        if (pos > 0 && size >= pos) {
            NSiguiente.deleteOnPosition(pos);
            size--;
        }
    }

}