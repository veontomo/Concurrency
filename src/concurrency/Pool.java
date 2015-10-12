/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrency;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Andrea
 */
class Pool {

    private static final int MAX_SIZE = 3;

    private final ArrayList<String> list;

    public Pool() {
        list = new ArrayList<>();
    }

    public synchronized void put(String item) throws InterruptedException {
        while (list.size() >= MAX_SIZE) {
            System.out.println("pool is full, wait to put " + item);
            wait();
        }
        System.out.println("put " + item);
        list.add(item);
        notifyAll();
    }

    public synchronized String get() throws InterruptedException {
        
        while (list.isEmpty()) {
            System.out.println("pool is empty, waiting until it becomes non-empty");
            wait();
        }
        int s = list.size();
        String elem = list.remove(s - 1);
        //System.out.println("pool[" + (s - 1) + "] = " + elem);
        notifyAll();
        return elem;
    }

}
