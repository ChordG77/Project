package Day230924;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LRUCache {
    public HashMap<Integer,Integer> cache = new LinkedHashMap<>();
    public int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        int value = -1;
        if(cache.containsKey(key)){
            value = cache.get(key);
            cache.remove(key);
            cache.put(key,value);
        }
        return value;

    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.remove(key);
        }
        else if (cache.size() == capacity){
            cache.remove(cache.keySet().iterator().next());
        }
        cache.put(key,value);

    }
}
