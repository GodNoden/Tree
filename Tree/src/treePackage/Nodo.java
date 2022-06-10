package treePackage;

public class Nodo {

	private double id;
	private String nombreNodo;
	private double peso;
	Nodo iz,dr;
	
	public Nodo(double id, String nombreNodo, double peso) {
		iz = null;
		dr = null;
		this.peso = peso;
		this.nombreNodo = nombreNodo;
		this.id = id;
		}
		
	public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
	}

	public String getNombre() {
		return nombreNodo;
	}

	public void setNombre(String nombre) {
		this.nombreNodo = nombre;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

}
