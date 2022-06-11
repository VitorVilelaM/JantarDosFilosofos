package pck2;

public class Garfos {
	private int filosofo;
	private int garfoEsquerda;
	private int garfoDireita;
	private boolean statusEsquerda = true;
	private boolean statusDireita = true;

	public Garfos(int id, int seuGarfo, int garfoVizinho) {
		setFilosofo(id);
		setGarfoEsquerda(seuGarfo);
		setGarfoDireita(garfoVizinho);
	}

	public void mostrarInformacoes() {
		System.out.println("Filosofo: " + getFilosofo() + " Garfo Esquerda: " + GarfoEsquerda() + " Garfo Direita: " + GarfoDireita());
	}

	public int GarfoEsquerda() {
		return garfoEsquerda;
	}

	public void setGarfoEsquerda(int garfoVizinho) {
		this.garfoEsquerda = garfoVizinho;
	}

	public int GarfoDireita() {
		return garfoDireita;
	}

	public void setGarfoDireita(int seuGarfo) {
		this.garfoDireita = seuGarfo;
	}

	public int getFilosofo() {
		return filosofo;
	}

	public void setFilosofo(int filosofo) {
		this.filosofo = filosofo;
	}

	public boolean isStatusEsquerda() {
		return statusEsquerda;
	}

	public void setStatusEsquerda(boolean statusEsquerda) {
		this.statusEsquerda = statusEsquerda;
	}

	public boolean isStatusDireita() {
		return statusDireita;
	}

	public void setStatusDireita(boolean statusDireita) {
		this.statusDireita = statusDireita;
	}
}
