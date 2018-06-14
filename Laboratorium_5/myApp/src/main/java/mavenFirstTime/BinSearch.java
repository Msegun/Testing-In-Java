package mavenFirstTime;

public class BinSearch {
	
	public static int binarySearch(int[] sortedArray, int key, int low, int high) {
		
		if(sortedArray.length == 0 || high == -1)
			return -1;
		
		if(sortedArray == null)
			throw new NullPointerException();
		
		int index = Integer.MAX_VALUE;
	     
	    while (low <= high) {
	        int mid = (low + high) / 2;
	        if (sortedArray[mid] < key) {
	            low = mid + 1;
	        } else if (sortedArray[mid] > key) {
	            high = mid - 1;
	        } else if (sortedArray[mid] == key) {
	            index = mid;
	            break;
	        }
	    }
	    return index;
	}
}
