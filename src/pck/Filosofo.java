package pck;

import java.util.Random;

public class Filosofo extends Thread {

	private int id;
	private Semaforo semaforo;
	private int[] states;
	private Semaforo[] s;
	private int tempo;
	private int vezesComeu; //count++
	private int semComer; // pegar o tempo da ultima vez q comeu
	private int mediaPensarComer; //tempo que  comeu - tempo que pensou
	private int tempoMaximoSemComer; //Comparar entre todos os semComer e ver qual é o maior
	
	Random random = new Random();
	
	public Filosofo(Semaforo semaforo, int id, int States[], Semaforo semaforos[]){
		this.id = id;
		this.semaforo = semaforo;
		this.states = States;
		this.s = semaforos;
	}
	
	public void pensar(){
		try {
			tempo = random.nextInt(499)+1;
			Thread.sleep(tempo);
			//Pegar tempo parou de pensar
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void pegarGarfo() {
		semaforo.down();
		System.out.println("Filosofo " + id + ": Pegou o  Garfo 1");
		states[id] = 1;
		teste(id);
		semaforo.up();
		s[id].down();
		//Pegar tempo2 da maquina pra semComer
	}

	public void comer() {
		try {
			//count++
			//Pegar temp pra media pra parar de comer

			System.out.println("Filosofo " + id + ": Pegou o  Garfo 2");
			System.out.println("Filosofo " + id + ": Comendo");
			tempo = random.nextInt(499)+1;
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void devolverGarfo(){
		semaforo.down();
		states[id] = 0;
		teste((id+5-1)%5);
		teste((id+1)%5);
		semaforo.up();
		System.out.println("Filosofo " + id + ": Devolve os Garfos");
		//Pegar tempo1 da maquina aqui pra semComer
	}
	
	public void teste(int id){
		int LEFT = (id+5-1)%5;
		int RIGHT = (id+1)%5;

		if ((states[id] == 1) && (states[LEFT] != 2) && (states[RIGHT] != 2)) {
			states[id] = 2;
			s[id].up();
		}else {
			System.out.println("Filosofo " + id + ": Não pega o Garfo");
		}
	}
	
	@Override
	public void run() {
		while (true) {
			pensar();
			pegarGarfo();
			comer();
			devolverGarfo();
		}
	}

	public int getVezesComeu() {
		return vezesComeu;
	}

	public void setVezesComeu(int vezesComeu) {
		this.vezesComeu = vezesComeu;
	}

}
