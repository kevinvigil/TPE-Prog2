package TPE;

import java.util.Collection;
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
    
    private int index;
    private Nodo NAnterior;
    private Nodo NSiguiente;

    private Object valor;

    public Nodo(int size){
        index = size;
    }

    public void deleteOnPosition(int pos){
        if (index == pos) {
            if (this.NSiguiente != null) {
                this.NAnterior.setNSiguiente(this.NSiguiente);
                this.NSiguiente.setNAnterior(this.NAnterior);
                this.NSiguiente = null;
            }else{
                this.NAnterior.setNSiguiente(null);
            }
        }else{
            NSiguiente.deleteOnPosition(pos);
        }
    }

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
    
  
}
