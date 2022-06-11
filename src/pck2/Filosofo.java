package pck2;

import java.util.Random;

public class Filosofo extends Thread {

	private int id;
	private Garfos[] garfos;
	private int states = 0;//Começam pensando

	private int count = 0;
	private int tempo;
	private int vezesComeu = 0;
	private long semComer = 0;
	private long inicioSemComer = 0;
	private long fimSemComer = 0;
	private long mediaPensarComer;
	private long tempoPensar;
	private long tempoComer;
	private long tempMaxSemComer = 0;

	Random random = new Random();

	public Filosofo(int Filosofo, Garfos G[]) {
		this.garfos = G;
		this.id = Filosofo;
	}

	public void pensar() {
		try {
			tempo = random.nextInt(499) + 1;
			Thread.sleep(tempo);
			setTempoPensar(System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void pegarGarfo() {
		teste(id);

		setFimSemComer(System.currentTimeMillis());
		setSemComer(getFimSemComer() - getInicioSemComer());
		if (count == 0) {
			count++;
			setSemComer(0);
			setTempMaxSemComer(0);
		} else {
			setSemComer(getFimSemComer() - getInicioSemComer());
			if (getTempMaxSemComer() <= getSemComer()) {
				setTempMaxSemComer(getSemComer());
			}
		}

	}

	public void comer() {
		try {
			count++;
			setVezesComeu(getVezesComeu() + 1);
			setTempoComer(System.currentTimeMillis());
			setMediaPensarComer((getTempoComer() - getTempoPensar()) / getVezesComeu());
			tempo = random.nextInt(499) + 1;
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void devolverGarfo() {
		garfos[id].setStatusDireita(true);
		garfos[id].setStatusEsquerda(true);
		states = 0;
		setInicioSemComer(System.currentTimeMillis());
	}
	
	public void teste(int id) {
		int LEFT = (id + 1) % 5;
		int RIGHT = (id + 5 - 1) % 5;
		
		if (id == 4) {	
			if (garfos[RIGHT].isStatusDireita()) {
				states = 1; //Faminto
				garfos[id].setStatusDireita(false);
				if (garfos[LEFT].isStatusEsquerda()) {
					garfos[id].setStatusEsquerda(false);
					states = 2;//Pode Comer
				} else {
					garfos[RIGHT].setStatusDireita(true);
				}
			}
			
		} else {
			if (garfos[LEFT].isStatusEsquerda()) {
				garfos[id].setStatusEsquerda(false);
				states = 1;//Faminto
				if (garfos[RIGHT].isStatusDireita()) {
					garfos[id].setStatusDireita(false);
					states = 2;//Pode comer
				} else {
					garfos[id].setStatusEsquerda(true);
				}
			}
		}
	}

	@Override
	public void run() {
		while (true) {
			pensar();
			pegarGarfo();
			if(states == 2) {
				comer();
				devolverGarfo();
				System.out.println("Filosofo: " + id + "comeu: " + count + "vezes");
			}
		}
	}

	public int getVezesComeu() {
		return vezesComeu;
	}

	public void setVezesComeu(int vezesComeu) {
		this.vezesComeu = vezesComeu;
	}

	public long getSemComer() {
		return semComer;
	}

	public void setSemComer(long semComer) {
		this.semComer = semComer;
	}

	public long getFimSemComer() {
		return fimSemComer;
	}

	public void setFimSemComer(long fimSemComer) {
		this.fimSemComer = fimSemComer;
	}

	public long getInicioSemComer() {
		return inicioSemComer;
	}

	public void setInicioSemComer(long inicioSemComer) {
		this.inicioSemComer = inicioSemComer;
	}

	public long getTempMaxSemComer() {
		return tempMaxSemComer;
	}

	public void setTempMaxSemComer(long tempMaxSemComer) {
		this.tempMaxSemComer = tempMaxSemComer;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public long getMediaPensarComer() {
		return mediaPensarComer;
	}

	public void setMediaPensarComer(long mediaPensarComer) {
		this.mediaPensarComer = mediaPensarComer;
	}

	public long getTempoPensar() {
		return tempoPensar;
	}

	public void setTempoPensar(long tempoPensar) {
		this.tempoPensar = tempoPensar;
	}

	public long getTempoComer() {
		return tempoComer;
	}

	public void setTempoComer(long tempoComer) {
		this.tempoComer = tempoComer;
	}
}
