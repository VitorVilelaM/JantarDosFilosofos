package pck;

public class Main {

	public static void main(String[] args) {
		Semaforo mutex = new Semaforo(1);
		Semaforo[] s = new Semaforo[5];

		Semaforo s0 = new Semaforo(0);
		Semaforo s1 = new Semaforo(0);
		Semaforo s2 = new Semaforo(0);
		Semaforo s3 = new Semaforo(0);
		Semaforo s4 = new Semaforo(0);
		

		int States[] = new int[5]; 
		
		for(int i = 0; i > 5;i++) {
			States[i] = 0;
		}
		
		s[0] = s0;
		s[1] = s1;
		s[2] = s2;
		s[3] = s3;
		s[4] = s4;
		
		
		Filosofo f1 = new Filosofo(mutex, 0, States, s);
		Filosofo f2 = new Filosofo(mutex, 1, States, s);
		Filosofo f3 = new Filosofo(mutex, 2, States, s);
		Filosofo f4 = new Filosofo(mutex, 3, States, s);
		Filosofo f5 = new Filosofo(mutex, 4, States, s);
		
		f1.start();
		f2.start();
		f3.start();
		f4.start();
		f5.start();
	}
}
