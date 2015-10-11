/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrency;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrea
 */
public class Producer implements Runnable {

    private static final int MAX_SIZE = 10;

    private final Pool pool;
    
    public Producer(Pool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        Random randomGenerator = new Random();
        int pause;
        for (int i = 0; i < MAX_SIZE; i++) {
            try {
                pause = randomGenerator.nextInt(500) + 1000 ;
                Thread.sleep(pause) ;
            } catch (InterruptedException ex) {
                Logger.getLogger(Concurrency.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("producer puts " + i);
            pool.put(i);
        }
    }
}
