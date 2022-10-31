
package TPE;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

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

    private Object valor;

    public Nodo(){}
    // e) Un mecanismo que permita recorrer uno a uno los elementos de la lista. 

    // d) Obtener la posición de la primera ocurrencia de un elemento dado.
    public int getPosElemento(Object o, int posActual){
        int i = 0;
        if (o.equals(this.valor)) {
            return i;
        }
        if (NSiguiente != null) {
            posActual ++;
            return NSiguiente.getPosElemento(o, posActual);
        } else {
            return -1;
        }
    }

    // c) Eliminar todas las ocurrencias de un elemento de la estructura dado el elemento. 
    public int deleteTodasOcurrencias (Object o){
        int i = 0;
        if (o.equals(this.valor)) {
            i++;
            delete(this);
        }
        if (NSiguiente != null) {
            i += NSiguiente.deleteTodasOcurrencias(o);
        }
        return i;
    }

    // b) Eliminar un elemento de la estructura dado una posición. 
    public void deleteOnPosition(int pos, int index){
        if (index == pos) {
            if (this.NSiguiente != null) {
                delete(this);
            }else{
                this.NAnterior.setNSiguiente(null);
                this.NAnterior = null;
            }
        }else{
            index++;
            NSiguiente.deleteOnPosition(pos, index);
        }
    }

    public void delete(Nodo n){
        this.NAnterior.setNSiguiente(this.NSiguiente);
        this.NSiguiente.setNAnterior(this.NAnterior);
        this.NSiguiente = null;
        this.NAnterior = null;
    }

    // a) Insertar un nuevo elemento en la estructura. 
    public void setNSiguiente (Nodo n){
    	if (this.NSiguiente == null) {
    		n.setNAnterior(this);
    	   	this.NSiguiente = n;
    	}
        else
        	NSiguiente.setNSiguiente(n);
    }

    public void setNAnterior (Nodo n){
    	this.NAnterior = n;
    }

    // a) Insertar un nuevo elemento en la estructura. 
    public void addOrdenado(Nodo n, Comparator h){
        int i = h.compare(n.valor, valor);
        if (i > 0) {
            addOrdenado(n, h);
        } else {
            NAnterior.setNSiguiente(n);
            NAnterior.NSiguiente.setNAnterior(this.NAnterior);
            setNAnterior(n);
            NAnterior.setNSiguiente(this);
        }
    }


    // f) Permitir cambiar la forma en la que se ordenan los elementos (con el subsecuente reordenamiento de los elementos ya almacenados.
    public void ordenar(int size, Comparator comp, int j){
        int i = comp.compare(this.valor, this.NSiguiente.valor);
        if (size>j) {
            if (i>0) {
                intercambiar(this, this.NSiguiente);
                ordenar(size, comp, j++);
            }else{
                this.NSiguiente.ordenar(size, comp, j++);
            }
        }
        
    }

    public void intercambiar(Nodo n1, Nodo n2){
        n2.NSiguiente.setNAnterior(n1);
        n2.NAnterior.NAnterior.setNSiguiente(n2);
        n2.setNAnterior(n1.NAnterior);
        n1.setNSiguiente(n2.NSiguiente);
        n2.setNSiguiente(n1);
        n1.setNAnterior(n2);
    }
  
}
