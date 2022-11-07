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

public class Alumno extends GrupoAbstracto{
    private String apellido;
    private int DNI; 
    private int edad; 
    private ListaVinculada palabras;

    public Alumno(String nombre, String apellido, int DNI, int edad){
        super(nombre);
        this.apellido = apellido;
        this.DNI = DNI;
        this.edad = edad;
        palabras =  new ListaVinculada(null);
    }

    public void addPalabras(String palabra){
        palabras.addDato(palabra);
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

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDNI(int dNI) {
        DNI = dNI;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean equals(Object nuevo) {
    	try {
    		Alumno Alumnonuevo = (Alumno) nuevo;
    		return super.getNombre().equals(Alumnonuevo.getNombre());
    	}catch(Exception e) {
    		return false;
    	}
    }

    @Override
    public String toString() {
        return super.getNombre();
    }

    @Override
    public int getCantidad() {
        return 1;
    }

	@Override
	public void Print() {
		// TODO Auto-generated method stub
		System.out.println("Alumno: \n" + this.getApellido() + ", " + super.getNombre() + "\n" + this.DNI + "\n" + this.edad);
	}
}
