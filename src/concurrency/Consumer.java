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
public class Consumer implements Runnable {

    private static final int MAX_SIZE = 20;

    private static int counter = 0;
    private final int marker;

    private final Pool pool;

    public Consumer(Pool pool) {
        counter++;
        this.pool = pool;
        marker = counter;
    }

    @Override
    public void run() {
        Random randomGenerator = new Random();
        int pause = randomGenerator.nextInt(500);
        for (int i = 1; i <= MAX_SIZE; i++) {
            try {
                Thread.sleep(pause);
                System.out.println("consumer " + marker + ", try " + i + " gets " + pool.get());
            } catch (InterruptedException ex) {
                Logger.getLogger(Concurrency.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
