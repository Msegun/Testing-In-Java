package zadanie6;

import java.util.ArrayList;

public class Table<E extends Comparable> {
	
	ArrayList<E> array;
	
	public Table(){
		array = new ArrayList<E>();
	}
	
	public void add(E value) {
		array.add(value);
	}
	
	public E largest(){
		
		if(array.size() == 0 || array == null)
			throw new IllegalStateException();
		
		E max = array.get(0);
		for(int i = 0; i < array.size(); i++) {
			if(array.get(i).compareTo(max) > 0)
				max = array.get(i);
		}
		return max;
	}
	
	public E smallest(){
		
		if(array.size() == 0 || array == null)
			throw new IllegalStateException();
		
		E min = array.get(0);
		for(int i = 0; i < array.size(); i++) {
			if(array.get(i).compareTo(min) < 0)
				min = array.get(i);
		}
		
		return min;
	}
	
	public boolean isSorted() {
		
		if(array.size() == 0)
			return true;
		
		if(array == null)
			throw new IllegalStateException();
		
		for(int i = 0; i < array.size() - 1; i++) {
			if(array.get(i).compareTo(array.get(i + 1)) > 0)
				return false;
		}
		
		return true;
	}
}
