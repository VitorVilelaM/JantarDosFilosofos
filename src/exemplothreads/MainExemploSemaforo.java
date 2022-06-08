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
public class MainExemploSemaforo {
    
    public static void main(String[] args) {
        
        Semaforo mutex = new Semaforo(1);
        Buffer count = new Buffer(0);
        
        ExemploThreadSemaforo exs1 
                = new ExemploThreadSemaforo(mutex, count, 1);
        ExemploThreadSemaforo exs2 
                = new ExemploThreadSemaforo(mutex, count, 2);
        
        exs1.start();
        exs2.start();
    }
    
}
