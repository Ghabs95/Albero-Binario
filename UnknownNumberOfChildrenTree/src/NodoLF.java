
/*
 * Gabriele Bertini
 * Matricola n° 5793664
 */

import java.util.LinkedList;

public class NodoLF<T> {

	private T info;
	public int livello;
	public NodoLF<T> padre;
	public LinkedList<NodoLF<T>> figli = new LinkedList<>();

	// costruttore
	public NodoLF(T n) {
		info = n;
	}

	// accessori
	public T getInfo() {
		return info;
	}

	// mutuatori
	public void setInfo(T info) {
		this.info = info;
	}

}
