package telran.util;

import java.util.Iterator;

public abstract class AbstractMap<K, V> implements Map<K, V> {
	 protected Set<Entry<K, V>> set;

	@Override
	public V get(K key) {
		Entry<K, V> entry = set.get(new Entry<>(key, null));
		return entry == null ? null : entry.getValue();
	}

	@Override
	public V put(K key, V value) {
		Entry<K, V> entry = set.get(new Entry<>(key, null));
		V res = null;
		if (entry != null) {
			res = entry.getValue();
			entry.setValue(value);
		} else {
			set.add(new Entry<>(key, value));
		}
		return res;
	}
	@Override
	//Returns true if this map contains a mapping for the specified key. 
	//More formally, returns true if and only if this map contains a mapping 
	//for a key k such that (key==null ? k==null : key.equals(k)).
//	public boolean containsKey(K key) {
//		if(key == null) {
//			 throw new NullPointerException();
//		}
//		Entry<K, V> entry = set.get(new Entry<>(key, null));
//		return entry == null ? false : entry.getKey().equals(key);
//	}
	
	public boolean containsKey(K key) {
		if(key == null) {
			 throw new NullPointerException();
		}
		
		return set.stream().anyMatch(entry -> entry.getKey().equals(key));
	}
	
	@Override
	//Returns true if this map maps one or more keys to the specified value. 
	//More formally, returns true if and only if this map contains at least 
	//one mapping to a value v such that (value==null ? v==null : value.equals(v)).
	
//	public boolean containsValue(V value) {
//		if(value == null) {
//			 throw new NullPointerException();
//		}
//		boolean res = false;
//		int size = 0;
//		Iterator<Entry<K, V>> it = set.iterator();
//		while(it.hasNext() && !res ) {
//			Entry<K,V> entry = it.next();
//			res = entry == null? false : entry.getValue().equals(value);
//		}
//		return res;
//	}
	

	public boolean containsValue(V value) {
		if(value == null) {
			 throw new NullPointerException();
		}		
		return set.stream().anyMatch(entry -> entry.getValue().equals(value));
	}

	@Override
	public Set<K> keySet() {
		Set<K> res = getKeySet();
		set.stream().map(entr -> entr.getKey()).forEach(key -> res.add(key));
		return res;				
	}

	protected abstract Set<K> getKeySet();
	protected abstract Collection<V> getCollectionValue();
	

	@Override
	public Collection<V> values() {
		Collection<V> collection = getCollectionValue();
		set.stream().map(entry -> entry.getValue()).forEach(v -> collection.add(v));
		return collection;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {		
		return set;
	}
	@Override
	//returns the previous value associated with key, 
	//or null if there was no mapping for key.
	public V remove(K key) {
		if(key == null) {
			 throw new NullPointerException();
		}
		Entry<K, V> entry = set.get(new Entry<>(key, null));
		V value = null;
		if(entry != null) {
		value =  entry.getValue();	
		set.remove(entry);
		}		
		return value;
	}

}
