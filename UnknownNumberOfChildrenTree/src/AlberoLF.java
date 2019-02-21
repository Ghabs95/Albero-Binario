
/*
 * Gabriele Bertini
 * Matricola n° 5793664
 */

import java.util.LinkedList;

public class AlberoLF<T> {

	private NodoLF<T> radice;
	private int numNodi;
	public int altezza = 0;

	// restituisce il numero dei nodi dell'albero
	public int numNodi() { // #01
		return numNodi;
	}

	// restituisce il numero di figli di un nodo
	public int numFigli(NodoLF<T> nodo) { // #02
		return nodo.figli.size();
	}

	// restituisce l'informazione di un nodo
	public T infoNodo(NodoLF<T> nodo) { // #03
		return nodo.getInfo();
	}

	// cambia l'informazione di un nodo
	public NodoLF<T> cambiaInfo(NodoLF<T> nodo, T n) { // #04
		nodo.setInfo(n);
		return nodo;
	}

	// restituisce la radice dell'albero
	public NodoLF<T> getRadice() { // #05
		return radice;
	}

	// restituisce il padre di un nodo
	public NodoLF<T> getPadre(NodoLF<T> nodo) { // #06
		if (nodo == radice) {
			return null;
		}
		return nodo.padre;
	}

	// restituisce la lista delle informazioni dei figli di un nodo
	public LinkedList<T> infoFigli(NodoLF<T> nodo) { // #07
		if (nodo.figli.size() == 0) {
			return null;
		}
		LinkedList<T> informazioni = new LinkedList<>();
		NodoLF<T> temp = nodo.figli.getFirst();
		int i = 1;
		while (temp != nodo.figli.getLast()) {
			informazioni.add(temp.getInfo());
			temp = nodo.figli.get(i++);
		}
		informazioni.add(nodo.figli.getLast().getInfo());
		return informazioni;
	}

	// inserisce la radice nell'albero e la restituisce
	public NodoLF<T> aggiungiRadice(T info) { // #08
		if (radice != null) {
			return sostituisciRadice(info);
		}
		radice = new NodoLF<T>(info);
		numNodi++;
		radice.livello = 0;
		return radice;
	}

	// inserisce una nuova radice nell'albero e la restituisce
	public NodoLF<T> sostituisciRadice(T info) { // #09
		NodoLF<T> temp = radice;
		radice = new NodoLF<T>(info);
		radice.figli.addFirst(temp);
		numNodi++;
		radice.livello = 0;
		return radice;
	}

	// aggiunge un figlio v ad un nodo u e lo restituisce
	public NodoLF<T> aggiungiFiglio(NodoLF<T> u, T n) { // #10
		NodoLF<T> v = new NodoLF<T>(n);
		u.figli.add(v);
		v.livello = u.livello + 1;
		numNodi++;
		if (v.livello > altezza) {
			altezza = v.livello;
		}
		return v;
	}

	/*
	 * visita in profondita' l'albero e restituisce la lista delle informazioni
	 * dei nodi cosi' incontrati (iterativa)
	 */
	public LinkedList<T> visitaDFS() { // #11
		LinkedList<NodoLF<T>> pila = new LinkedList<>();
		LinkedList<T> infoNodi = new LinkedList<>();
		pila.push(radice);
		while (pila.size() != 0) {
			NodoLF<T> temp = pila.pop();
			infoNodi.add(temp.getInfo());
			for (int i = temp.figli.size() - 1; i >= 0; i--) {
				pila.push(temp.figli.get(i));
			}
		}
		return infoNodi;
	}

	/*
	 * visita in ampiezza l'albero e restituisce la lista delle informazioni dei
	 * nodi cosi' incontrati (iterativa)
	 */
	public LinkedList<T> visitaBFS() { // #12
		LinkedList<NodoLF<T>> coda = new LinkedList<>();
		LinkedList<T> infoNodi = new LinkedList<>();
		coda.addFirst(radice);
		while (coda.size() != 0) {
			NodoLF<T> temp = coda.removeLast();
			infoNodi.add(temp.getInfo());
			for (int i = 0; i < temp.figli.size(); i++) {
				coda.addFirst(temp.figli.get(i));
			}
		}
		return infoNodi;
	}

	// restituisce l'altezza dell'albero
	public int altezza() { // #13
		return altezza;
	}

}