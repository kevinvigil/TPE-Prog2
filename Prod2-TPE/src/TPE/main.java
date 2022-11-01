package TPE;

public class main {

	public static void main(String[] args) {
		ListaVinculada foo = new ListaVinculada();
		int j =10;
		foo.addDato(j);
		int k =11;
		foo.addDato(k);
		int p =12;
		foo.addDato(p);
		foo.addDato(k);
		foo.addDato(j);
		foo.posElemento(p);
		System.out.println(foo.toString());
		

	}

}
