package zadanie4;

import java.util.ArrayList;
import java.util.List;

public class StringOperations {
	
  public String reverse(String a) {
	  
	  if(a == null || a.length() == 0)
		  throw new NullPointerException();
	  
	  List<String> tempArray = new ArrayList<String> (a.length());
	  for (int i=0; i< a.length(); i++) {
		  tempArray.add(a.substring(i, i+1));
	  }
	  StringBuilder reversedString = new StringBuilder(a.length());
	  for (int i = tempArray.size()-1; i>=0; i--) {
		  reversedString.append(tempArray.get(i));
	  }
	  return reversedString.toString();
  }
  
  public String concat(String a, String b) {
	  
	  String retVal = null;
	    if (a != null) {
	      StringBuilder sb = new StringBuilder();
	      sb.append(a);
	        if (b != null) {
	          sb.append(b);
	        }
	        else{
	        	throw new NullPointerException();
	        }
	      retVal = sb.toString();
	    }
	    else{
	    	throw new NullPointerException();
	    }
	    return retVal;
  }
  
  public boolean isPalindrome(String a) {
	  
	  if(a == null)
		  throw new NullPointerException();
	  
	  if(a.length()<=1){
			return true;
		}
	  return a.equals(new StringBuilder(a).reverse().toString());
  }
  
}