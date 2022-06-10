package treePackage;

import javax.swing.JOptionPane;

/*
 * static class nodo { Nodo iz, dr; double data, id; String nombreNodo;
 * 
 * Nodo() { iz = null; dr = null; data = 0; }
 * 
 * Nodo(double peso, String nombreNodo, double id) { iz = null; dr = null; data
 * = peso; this.nombreNodo = nombreNodo; this.id = id; } }
 */

public class Arbol {
	static final int COUNT = 5;
	 public static Nodo raiz;

	public Arbol(double valor) {
		raiz = new Nodo(1, "Raiz", valor);
	}

	public void preorden(Nodo nodo) {
		if (nodo != null) {
			System.out.println("Valor del nodo: " + nodo.getPeso() + " ");
			preorden(nodo.iz);
			preorden(nodo.dr);
		}
	}

	public Nodo buscarNodo(double peso) {
		Nodo nodo = raiz;
		int contador = 0;
		while (true) {
			if (nodo.getPeso() < peso) {
				if (nodo.iz != null)
					nodo = nodo.iz;
				else {
					System.out.println("\n" + "Nodo con valor: " + peso + " no encontrado ");
					return null;
				}
			}
			if (nodo.getPeso() > peso) {
				if (nodo.dr != null)
					nodo = nodo.dr;
				else {
					System.out.println("\n" + "Nodo con valor: " + peso + " no encontrado ");
					return null;
				}
			}
			contador++;
			System.out.println(nodo.getPeso() + " ");
			if (nodo.getPeso() == peso) {
				System.out.println(contador + " nodos visitados para llegar a " + peso);
				return nodo;
			}
		}
	}

	public static void insertarNodo(double id, String nombre, double peso) {
		Nodo nodo = raiz;
		while (true) {
			if (nodo.getPeso() <= peso) {
				if (nodo.iz == null) {
					nodo.iz = new Nodo(id, nombre, peso);
					return;
				}
				nodo = nodo.iz;
			}
			if (nodo.getPeso() > peso) {
				if (nodo.dr == null) {
					nodo.dr = new Nodo(id, nombre, peso);
					return;
				}
				nodo = nodo.dr;
			}
		}
	}

	public void postorden(Nodo nodo) {
		if(nodo == null) {
			return;
		}
		postorden(nodo.iz);
		postorden(nodo.dr);
		System.out.println("Valor del nodo: " + nodo.getPeso() + " ");
	}

	public void inorder(Nodo nodo) {
		if(nodo == null) {
			return;
		}
		System.out.println("Valor del nodo: " + nodo.getPeso() + " ");
		postorden(nodo.iz);
		postorden(nodo.dr);
		
	}



	public static Nodo eliminarRecursivo(Nodo nodo, double peso) {
		if (nodo == null) {
			return null;
		}

		
		if (peso < nodo.getPeso()) {
			nodo.iz = eliminarRecursivo(nodo.iz, peso);
		} else if (peso > nodo.getPeso()) {
			nodo.dr = eliminarRecursivo(nodo.dr, peso);
		} else {
			// node with only one child or no child
			if (nodo.iz == null)
				return nodo.dr;
			else if (nodo.dr == null)
				return nodo.iz;
			
			
			nodo.setPeso(menorElemento(nodo.dr));
           
            nodo.dr = eliminarRecursivo(nodo.dr, nodo.getPeso());
			//System.out.println(nodo.getPeso() + "epa");
		}
		return nodo;
	}
	
	

	public static void eliminar(double value) {
		System.out.println(raiz.getPeso());
		raiz = eliminarRecursivo(raiz, value);
	}

	public static double menorElemento(Nodo raiz) {
		double minv = raiz.getPeso();;
        while (raiz.iz != null)
        {
            minv = raiz.iz.getPeso();
            raiz = raiz.iz;
        }
        return minv;
	}


	public static void imprimir(Nodo root, int space) {
		// Base case
		if (root == null)
			return;

		// Increase distance between levels
		space += COUNT;

		// Process right child first
		imprimir(root.dr, space);

		// Print current node after space
		// count
		System.out.print("\n");
		for (int i = COUNT; i < space; i++)
			System.out.print(" ");
		System.out.print(root.getPeso() + "\n");

		// Process left child
		imprimir(root.iz, space);
	}

}

/*
 * public static void main(String[] args) { //Arbol arbol = new Arbol(0); double
 * valor = 0; String Dato; System.out.println("Numero de Nodos valores: "); Dato
 * =
 * JOptionPane.showInputDialog("Inserta el número de nodos que desea ingresar");
 * 
 * int n = Integer.parseInt(Dato); for (int i = 1; i <= n; i++) { Dato =
 * JOptionPane.showInputDialog("Ingresa el " + i +
 * " valor para colocar en el Arbol");
 * 
 * valor = Integer.parseInt(Dato); System.out.print(valor + " "); if (i == 1) {
 * // arbol.raiz.data = valor; } else { // arbol.insertarNodo(valor); } } Dato =
 * JOptionPane.showInputDialog("Inserta el número a buscar"); double dato =
 * (double) Integer.parseInt(Dato); //arbol.buscarNodo(dato);
 * System.out.println("\n\nRecorrido largo"); //arbol.preorden(arbol.raiz);
 * 
 * }
 */
