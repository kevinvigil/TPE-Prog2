package TPE;

import java.util.Comparator;

// Una lista vinculada ordenada es una estructura de datos formada por un conjunto de nodos, 
// cada uno de los cuales posee un objeto y una referencia al siguiente nodo de la estructura. 
// La particularidad que tiene este tipo de listas es que se encuentra siempre ordenada 
// (ascendente o descendente, según el criterio de orden con el que la lista fue creada) 
// con respecto a los elementos que contiene. Ejemplos:

// Implementar en Java las clases necesarias para diseñar esta estructura de datos, 
// teniendo en cuenta que el valor de cada nodo puede ser cualquier tipo de objeto. 
// NO pueden usarse colecciones de Java existentes para la implementación (ArrayList, Vector, arreglos clásicos [], etc ). 
// La lista vinculada debe proveer al menos a los siguientes servicios: 
// a) Insertar un nuevo elemento en la estructura. 
// b) Eliminar un elemento de la estructura dado una posición. 
// c) Eliminar todas las ocurrencias de un elemento de la estructura dado el elemento. 
// d) Obtener la posición de la primera ocurrencia de un elemento dado. 
// e) Un mecanismo que permita recorrer uno a uno los elementos de la lista. 
// f) Permitir cambiar la forma en la que se ordenan los elementos (con el subsecuente reordenamiento de los elementos ya almacenados.

public class Nodo {
    
    private Nodo NAnterior;
    private Nodo NSiguiente;

    private Object  valor;

    public Nodo(){}

    // a) Insertar un nuevo elemento en la estructura. 
    public void addOrdenado(Nodo n, Comparator<Object> criterio){
        int i = criterio.compare(n.valor, this.valor);
        if (i > 0) {
            if (NSiguiente == null) {
                this.NSiguiente = n;
                this.NSiguiente.NAnterior = this;
            }else{
                NSiguiente.addOrdenado(n, criterio);
            }
        } else {
            this.NAnterior.setNSiguiente(n);
            this.NAnterior.NSiguiente.setNAnterior(this.NAnterior);
            this.setNAnterior(n);
            this.NAnterior.setNSiguiente(this);
        }
    }

     public void add (Nodo n){
         if (this.NSiguiente != null) {
             this.NSiguiente.add(n);
        }else{
            this.NSiguiente = n;
             this.NSiguiente.NAnterior = this;
         }
    }

    // b) Eliminar un elemento de la estructura dado una posición. 
    public void deleteOnPosition(int pos, int index){
        if (index == pos) {
            delete(this);
        }else{
            index++;
            NSiguiente.deleteOnPosition(pos, index);
        }
    }

    public void delete(Nodo n){
        if (this.NAnterior != null) {
            if (this.NSiguiente!=null) {
                this.NAnterior.NSiguiente = this.NSiguiente;
            }else{
                this.NAnterior.NSiguiente =null;
            }
            
        }
        
        
        if (this.NSiguiente!=null) {
            this.NSiguiente.NAnterior =this.NAnterior;
        }
        this.NSiguiente = null;
        this.NAnterior = null;
    }

    // c) Eliminar todas las ocurrencias de un elemento de la estructura dado el elemento. 
    public int deleteTodasOcurrencias (Object o){
        int i = 0;
        Nodo aux = null;
        if (o.equals(this.valor)) {
            i++;
            aux = this.NSiguiente;
            delete(this);
        }
        if (this.NSiguiente != null) {
            i += this.NSiguiente.deleteTodasOcurrencias(o);
        }else if(aux != null){
            i += aux.deleteTodasOcurrencias(o);
        }
        return i;
    }

    // d) Obtener la posición de la primera ocurrencia de un elemento dado.
    public int getPosElemento(Object o, int posActual){
        if (o.equals(this.valor)) {
            return posActual;
        }
        if (NSiguiente != null) {
            posActual ++;
            return NSiguiente.getPosElemento(o, posActual);
        } else {
            return -1;
        }
    }

    // f) Permitir cambiar la forma en la que se ordenan los elementos (con el subsecuente reordenamiento de los elementos ya almacenados.
    public void ordenar(int size, Comparator criterio, int j){
        if (size>j) {
            if (this.NSiguiente != null) {
                int i = criterio.compare(this.valor, this.NSiguiente.valor);
                if (i>0) {
                    intercambiar(this, this.NSiguiente);
                    ordenar(size, criterio, j++);
                }else{
                    this.NSiguiente.ordenar(size, criterio, j++);
                }
            }
            
        } 
    }

    public void intercambiar(Nodo n1, Nodo n2){
        if (n2.NSiguiente != null) {
            n2.NSiguiente.setNAnterior(n1);
            n1.setNSiguiente(n2.NSiguiente);
        } else{
            n1.setNSiguiente(null);
        }
        
        n2.setNAnterior(n1.NAnterior);
        n2.setNSiguiente(n1);
        n2.NAnterior.setNSiguiente(n2);
        n1.setNAnterior(n2);
        
    }
  
    public void setNAnterior (Nodo n){
    	this.NAnterior = n;
    }

    public void setNSiguiente (Nodo n){
        this.NSiguiente = n;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public Object getValor() {
        return valor;
    }

    public Nodo getNSiguiente() {
        return NSiguiente;
    }

    @Override
    public String toString() {
        return this.valor.toString();
    }
}
