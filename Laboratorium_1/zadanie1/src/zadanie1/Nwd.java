package zadanie1;

public class Nwd {
	int nwd(int a, int b){
		if( a == 0 && b == 0){
			throw new IllegalArgumentException();
		}
		if( a < 0 || b < 0){
			throw new IllegalArgumentException();
		}
		if(b == 0){
			return a;
		} else{
			return nwd(b, (a % b));
		}
	}
}