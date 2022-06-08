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
public class Buffer {
    
    private int value;
    
    public Buffer (int value){
        this.value = value;
    }
    
    public void increaseBuffer (){
        this.value++;
    }
    
    public void decreaseBuffer () {
        this.value--;
    }
    
    public int getValue () {
        return this.value;
    }
    
}
