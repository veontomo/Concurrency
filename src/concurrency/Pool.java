/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrency;

import java.util.ArrayList;

/**
 *
 * @author Andrea
 */
public class Pool {
    
    private final ArrayList<Integer> pool;
    
    public Pool(){
        
        pool = new ArrayList<>();

    }
    
    public void put(int n){
        pool.add(n);
    }
    
    public Integer get(){
        if (pool.isEmpty()){
            return null;
        }
        int size = pool.size();
        Integer n = pool.get(size - 1);
        pool.remove(n-1);
        return n;
    }
}
