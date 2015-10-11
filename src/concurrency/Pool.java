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
   private static final int MAX_AVAILABLE = 100;
   private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);

   public int get() throws InterruptedException {
     available.acquire();
     return getNextAvailableItem();
   }

   public void put(int x) {
     if (markAsUnused(x))
       available.release();
   }

   // Not a particularly efficient data structure; just for demo

   protected int[] items = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
   protected boolean[] used = new boolean[MAX_AVAILABLE];

   protected synchronized int getNextAvailableItem() {
     for (int i = 0; i < MAX_AVAILABLE; ++i) {
       if (!used[i]) {
          used[i] = true;
          return items[i];
       }
     }
     return -1; // not reached
   }

   protected synchronized boolean markAsUnused(int item) {
     for (int i = 0; i < MAX_AVAILABLE; ++i) {
       if (item == items[i]) {
          if (used[i]) {
            used[i] = false;
            return true;
          } else
            return false;
       }
     }
     return false;
   }

 }