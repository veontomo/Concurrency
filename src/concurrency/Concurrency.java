/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrency;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;
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
    public static void main(String[] args) throws InterruptedException {
        Pool pool = new Pool();
//        Thread producer = new Thread(new Producer(pool));
        Thread consumer = new Thread(new Consumer(pool));
        Thread consumer2 = new Thread(new Consumer(pool));
//
//        producer.start();
        consumer.start();
        consumer2.start();

//        final Semaphore semaphore = new Semaphore(5, true);
//        semaphore.acquire();
        
        

    }

}
