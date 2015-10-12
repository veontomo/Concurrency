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

    private final Pool pool;
    private final String name;

    public Producer(Pool pool, String name) {
        this.pool = pool;
        this.name = name;
    }

    @Override
    public void run() {
        Random randomGenerator = new Random();
        int pause;
        int counter = 0;
        while (true) {
            try {
                pause = randomGenerator.nextInt(500);
                Thread.sleep(pause);
                pool.put(name + " " + counter);
                counter++;
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
