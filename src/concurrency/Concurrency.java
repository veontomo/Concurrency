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
public class Concurrency {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pool pool = new Pool();
        final int MAX_SIZE = 50;
        Thread producer = new Thread(new Runnable() {

            @Override
            public void run() {
                Random randomGenerator = new Random();
                int pause = randomGenerator.nextInt(500);
                for (int i = 0; i < MAX_SIZE; i++) {
                    try {
                        Thread.sleep(pause);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Concurrency.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("producer puts " + i);
                    pool.put(i);
                }
            }
        });

        Thread consumer = new Thread(new Consumer(pool));
        Thread consumer2 = new Thread(new Consumer(pool));

        producer.start();
        consumer.start();
        consumer2.start();
    }

}
