package pck2;

public class Main {

	public static void main(String[] args) {
		
		Garfos[] garfos = new Garfos[5];
		Filosofo[] filosofos = new Filosofo[5];
		
		for(int i = 0; i < 5; i++) {
			int LEFT = i;
			int RIGHT = (i + 5 - 1) % 5;
			
			garfos[i] = new Garfos(0 + i, LEFT, RIGHT);
		}

		for(int i = 0; i < 5; i++) {
			filosofos[i] = new Filosofo(i, garfos);
			filosofos[i].start();
		}
		
		

	}
}
