package design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 使用链表LinkedList和HashMap实现缓存lru算法
 */
public class LRUCache {

    private LinkedList<String> list = new LinkedList<String>();

    private Map<String,String> map;

    private int size = 0;

    public LRUCache(int size){
        this.size = size;
        this.map = new HashMap<>(size);
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(3);
        lru.put("1","a");
        lru.put("2","b");
        lru.put("3","c");
        System.out.println(lru);
        lru.put("4","d");
        System.out.println(lru);
        lru.get("2");
        System.out.println(lru);
    }

    public void put(String key,String value){
        if(list.size() == size){
            //移除头节点
            map.remove(list.removeFirst());
        }
        list.add(key);
        map.put(key, value);
    }

    public String get(String key){
        if(!map.containsKey(key)){
            return null;
        }
        list.remove(key);
        list.add(key);
        System.out.println(map.get(key));
        return map.get(key);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
