/*
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support: get() and set().
 * 
 * get(key) - get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * 
 * set(key, value) - set or insert the value if the key is not already present. When the cache reached its capacity, 
 * 									 it should invalidate the least recently used item before inserting a new item
 * 
 * 7:10
 * 7:45
 */

//Have the user define the capacity in the constructor
import java.util.HashMap;

public class LRUCache {
	public static void main(String[] args){
		LRUCache a = new LRUCache(10);
		a.set(5, 5);
		a.set(6, 6);
		a.set(3, 3);
		System.out.println("Expect 3: " + a.head.val);
		System.out.println("Expect 6: " + a.get(6));
		System.out.println("Expect 6: " + a.head.val);
	}
	
	int capacity;
	HashMap<Integer, CacheNode> map;
	CacheNode head, end;
	
	public LRUCache(int capacity){
		this.capacity = capacity;
		this.map = new HashMap<>();
		this.head = null;
		this.end = null;
	}
	
	public int get(int key){
		int value = -1;
		if(map.containsKey(key)){
			CacheNode n = map.get(key);
			value = n.val;
			remove(n);
			setHead(n);			
		}		
		return value;
	}
	
	public void set(int key, int val){
		if(map.containsKey(key)){
			CacheNode n = map.get(key);
			n.val = val;
			remove(n);
			setHead(n);
		} else {
			CacheNode n = new CacheNode(key, val);
			if(map.size() < capacity){
				map.put(key, n);
				setHead(n);			
			} else {
				map.put(key, n);
				remove(end);
				setHead(n);
				map.remove(end.key);
			}
		}
	}
	
	private void remove(CacheNode n){
		if(n.prev != null){
			n.prev.next = n.next;
		} else {
			head = n.next;
		}
		
		if(n.next != null){
			n.next.prev = n.prev;
		} else {
			end = n.prev;
		}
	}
	
	private void setHead(CacheNode n){
		n.next = head;
		n.prev = null;
		
		if(head != null){
			head.prev = n;
		}
		
		head = n;
		
		if(end == null){
			end = head;
		}
	}
}

class CacheNode{
	CacheNode next;
	CacheNode prev;
	int val;
	int key;
	
	public CacheNode(int key, int val){
		this.key = key;
		this.val = val;
	}	
}
