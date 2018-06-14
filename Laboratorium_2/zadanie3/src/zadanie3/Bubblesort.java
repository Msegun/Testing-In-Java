package zadanie3;


public class Bubblesort {

	Integer[] table;
	
	public Bubblesort(Integer[] tab){
		table = tab;
	}
	
	public Bubblesort(){
		table = null;
	}
	
	public void bubbleSort(String n) {
		if(n != "M" && n!= "R")
			throw new IllegalArgumentException();
		
		if(n == null)
			throw new IllegalArgumentException();
			
		if (table == null)
			throw new IllegalArgumentException();
		if(n == "R"){
			if (table.length == 0)
				throw new NullPointerException();
			for (int i = 0; i < table.length; i++) {
            
					for (int j = 0; j < table.length - 1; j++) {
						if (table[j] > table[j + 1]) {
							int temp;
							temp = table[j + 1];
							table[j + 1] = table[j];
							table[j] = temp;
						}
					}
			}
		}
		
		if(n == "M"){
			if (table.length == 0)
				throw new NullPointerException();
			for (int i = 0; i < table.length; i++) {
            
					for (int j = 0; j < table.length - 1; j++) {
						if (table[j] < table[j + 1]) {
							int temp;
							temp = table[j + 1];
							table[j + 1] = table[j];
							table[j] = temp;
						}
					}
			}
		}
        
    }
	
	public boolean isSorted(String s) {
		
		if(s != "M" && s!= "R")
			throw new IllegalArgumentException();
		
		if(s == null)
			throw new IllegalArgumentException();
		
		if(table == null)
			throw new IllegalStateException();
		
		if(table.length == 0)
			return true;
		
		if(s == "R"){
			for(int i = 0; i < table.length - 1; i++) {
				if(table[i] > table[i + 1])
					return false;
			}
		
			return true;
		}
		
		if(s == "M"){
			for(int i = 0; i < table.length - 1; i++) {
				if(table[i] < table[i + 1])
					return false;
			}
		
			return true;
		}
		
		return true;
	}
}
