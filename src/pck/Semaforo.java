package pck;

public class Semaforo {
	private int numMax;
	
	public Semaforo(int numMax){
		this.numMax = numMax;
	}
	
	public synchronized void down() {
        synchronized (this) {
            try {
                while (numMax == 0) {
                    this.wait();
                }
                numMax--;
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public synchronized void up() {
        synchronized (this) {
            this.numMax++;
            notifyAll();
        }
    }

}
