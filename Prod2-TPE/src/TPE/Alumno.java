package TPE;

// 2) 
// Uso de la estructura Como este año la cursada de Programación 2 tuvo récord de alumnos, 
// los profesores desean utilizar la estructura de datos implementada en el ejercicio 1 para 
// mantener ordenados a los alumnos de acuerdo a diferentes criterios. 

// Cada alumno posee nombre, apellido, DNI, edad, y una lista de palabras que representan sus intereses. 
// Considerar la posibilidad de utilizar órdenes compuestos (por ejemplo, ordenar por apellido, y si hay dos 
// alumnos con el mismo apellido, ordenarlos por nombre, y si ambos coinciden por dni) Implementar 
// en Java la clase Alumno, con todas las características necesarias para poder agregar a los mismos 
// a una lista vinculada.

public class Alumno {
    private String nombre;
    private String apellido;
    private int DNI; 
    private int edad; 
    private ListaVinculada palabras;

    public Alumno(String nombre, String apellido, int DNI, int edad){
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.edad = edad;
    }

    public String getApellido() {
        return apellido;
    }

    public int getDNI() {
        return DNI;
    }

    public int getEdad() {
        return edad;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDNI(int dNI) {
        DNI = dNI;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public boolean equals(Object nuevo) {
    	try {
    		Alumno Alumnonuevo = (Alumno) nuevo;
    		return nombre.equals(Alumnonuevo.getNombre());
    	}catch(Exception e) {
    		return false;
    	}
    }

    @Override
    public String toString() {
        
        return nombre;
    }
}
