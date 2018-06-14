package zadanie1;

import java.util.ArrayList;
import java.util.Arrays;

public class Table {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(array);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Table other = (Table) obj;
		if (!Arrays.equals(array, other.array))
			return false;
		return true;
	}

	int array[];
	
	public Table(int size) {
		array = new int[size];
	}
	
	public Table() {
		array = null;
	}
	
	public int largest() {
		
		if(array == null)
			throw new IllegalStateException();
		
		if(array.length == 0)
			throw new IllegalStateException();
		
		int max = array[0];
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] > max)
				max = array[i];
		}
		
		return max;
	}
	
	public int smallest() {
		
		if(array == null)
			throw new IllegalStateException();
		
		if(array.length == 0)
			throw new IllegalStateException();
		
		int min = array[0];
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] < min)
				min = array[i];
		}
		
		return min;
	}
	
	public boolean isSorted() {
		
		if(array == null)
			throw new IllegalStateException();
		
		if(array.length == 0)
			return true;
		
		for(int i = 0; i < array.length - 1; i++) {
			if(array[i] > array[i + 1])
				return false;
		}
		
		return true;
	}
	
	
	
}