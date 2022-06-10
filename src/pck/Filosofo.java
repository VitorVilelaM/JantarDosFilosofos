package pck;

import java.util.Random;

public class Filosofo extends Thread {

	private int id;
	private int count = 0;
	private Semaforo semaforo;
	private int[] states;
	private Semaforo[] s;
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

	public Filosofo(Semaforo semaforo, int id, int States[], Semaforo semaforos[]) {
		this.id = id;
		this.semaforo = semaforo;
		this.states = States;
		this.s = semaforos;
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
		semaforo.down();
		states[id] = 1;
		teste(id);
		semaforo.up();
		s[id].down();
		setFimSemComer(System.currentTimeMillis());
		setSemComer(getFimSemComer() - getInicioSemComer());
		if (count == 0) {
			count++;
			setSemComer(0);
			setTempMaxSemComer(0);
		}else {
			setSemComer(getFimSemComer() - getInicioSemComer());
			if (getTempMaxSemComer() <= getSemComer()) {
				setTempMaxSemComer(getSemComer());
			}
		}

	}

	public void comer() {
		try {
			setVezesComeu(getVezesComeu() + 1);
			setTempoComer(System.currentTimeMillis());
			setMediaPensarComer((getTempoComer() - getTempoPensar())/getVezesComeu());
			tempo = random.nextInt(499) + 1;
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void devolverGarfo() {
		semaforo.down();
		states[id] = 0;
		teste((id + 5 - 1) % 5);
		teste((id + 1) % 5);
		semaforo.up();
		setInicioSemComer(System.currentTimeMillis());
	}

	public void teste(int id) {
		int LEFT = (id + 5 - 1) % 5;
		int RIGHT = (id + 1) % 5;

		if ((states[id] == 1) && (states[LEFT] != 2) && (states[RIGHT] != 2)) {
			states[id] = 2;
			s[id].up();
		}
	}

	@Override
	public void run() {
		while (true) {
			pensar();
			pegarGarfo();
			comer();
			devolverGarfo();
			System.out.println("Filosofo: " + id + "leva em media: " + getMediaPensarComer() + " para pensar e comer");
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
