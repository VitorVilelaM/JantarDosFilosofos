/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplothreads;

/**
 *
 * @author Douglas
 */
public class ExemploThreadSemaforo extends Thread{
    
    private Semaforo semaforo;
    private Buffer count;
    private int idThread;
    
    public ExemploThreadSemaforo(Semaforo semaforo, Buffer count, int idThead){
        this.semaforo = semaforo;
        this.count = count;
        this.idThread = idThead;
    }
    
    @Override
    public void run (){
        while (true) {
            semaforo.down();
            this.count.increaseBuffer();
            System.out.println("Thread " + idThread + " - Count: " + this.count.getValue());
            semaforo.up();
        }
    }
    
}
