/*
 * Feature 5 - Fetch Most Recently Watched Titles - PROBLEM - LRU Cache
 */

import java.util.HashMap;

public class LRUCache {
    int capacity;
    HashMap<Integer, ListNode> cache;
    ListNode cacheVals;

    public LRUCache(int capacity){
        this.capacity = capacity;
        cache = new HashMap<Integer, ListNode>(capacity);
        cacheVals = new ListNode();
    }

    ListNode get(int key){
        if(!cache.containsKey(key)){
            return null;
        }

        else {
            int value = cache.get(key).data;
            cacheVals.removeNode(cache.get(key);
            cacheVals.insertAtTail(key, value);
            return cacheVals.getTail();
        }
    }

    void set(int key, int value){
        if(!cache.containsKey(key)){
            evictIfNeeded();
            cacheVals.insertAtTail(key, value);
            cache.put(key, cacheVals.getTail());
        }

        else{
            cacheVals.removeNode(cache.get(key));
            cacheVals.insertAtTail(key, value);
            cache.put(key, cacheVals.getTail());
        }
    }

    void evictIfNeeded(){
        if (cacheVals.size >= capacity){
            ListNode node = cacheVals.removeHead();
            cache.remove(node.key);

        }
    }
}
