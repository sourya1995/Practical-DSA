/*
 * Feature 6 - Find most frequently watched titles - PROBLEM - LFU Cache
 */

import java.util.HashMap;
import java.util.LinkedHashSet;

class LFUCache {
    int min = -1;
    HashMap<Integer, Integer> values;
    HashMap<Integer, Integer> counts;
    HashMap<Integer, LinkedHashSet<Integer>> lists;
    int cap;

    public LFUCache(int capacity) {
        cap = capacity;
        values = new HashMap<>();
        counts = new HashMap<>();
        lists = new HashMap<>();
        lists.put(1, new LinkedHashSet());
    }
    
    public int get(int key) {
        if(values.containsKey(key) == false){
            return -1;
        }

        int count = counts.get(key);
        counts.put(key, count + 1);
        lists.get(count).remove(key);
        if(count == min && lists.get(count).size() == 0){
            min++;
        }
        lists.putIfAbsent(count + 1, new LinkedHashSet<>());
        lists.get(count + 1).add(key);

        return values.get(key);
    }
    
    public void put(int key, int value) {
        if(cap <= 0) return;

        if(values.containsKey(key)){
            values.put(key, value);
            get(key);
        } else {
            if(values.size() >= cap){
                int evict = lists.get(min).iterator().next();
                lists.get(min).remove(evict);
                values.remove(evict);
            }

            values.put(key, value);
            counts.put(key, 1);
            min = 1;
            lists.get(min).add(key);
        }
    }
}