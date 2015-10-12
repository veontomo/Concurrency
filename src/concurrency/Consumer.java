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

    private static final int MAX_SIZE = 5;

    private final String name;

    private final Pool pool;

    public Consumer(Pool pool, String name) {
        this.pool = pool;
        this.name = name;
    }

    @Override
    public void run() {
        Random randomGenerator = new Random();
        int pause;
        String item;
        while (true) {
            try {
                pause = randomGenerator.nextInt(500);
                Thread.sleep(pause);
            } catch (InterruptedException ex) {
                System.out.println("consumer " + name + " failed to wait");
            }
            try {
                item = pool.get();
                System.out.println("consumer " + name + " gets " + item);
            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("consumer " + name + " failed");
                e.printStackTrace();
            } catch (NullPointerException e){
                System.out.println("consumer " + name + " failed due to " + e.getLocalizedMessage());
            } catch (InterruptedException ex) {
                System.out.println("consumer " + name + " failed to wait");
            }
        }
    }
}
