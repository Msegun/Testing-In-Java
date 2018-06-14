package Projekt1;

import java.util.Random;

public class Kontrakt implements Psikus {
	
	private Integer liczba;
	public Kontrakt() {}

	public Kontrakt(Integer liczba) {
		this.liczba = liczba;
	}

	/* Metoda CyfroKrad działa w ten sposób, że w liczbie
	 * przekazanej jako argument, usuwa losowo jedną cyfrę.
	 * Gdy jednocyfrowa zwraca null.
	 * */
	public Integer CyfroKrad(Integer liczba) {
		
		// Return IllegalArgumentException if argument is null
		ArgumentNullChecker(liczba);
		
		//If out value is negative we need to change it to positive 
		boolean isNegativeFlag = false;
		if (liczba < 0) {
			isNegativeFlag = true;
			liczba = -liczba;
		}
		
		int amountOfNumbers = liczba.toString().length();
		
		if (amountOfNumbers == 1)
			return null;
		
		Random rand = new Random();
		// We chose random index of the number we're gonna delete
		int deleteIndex = rand.nextInt(amountOfNumbers);
		
		String newLiczba = "";	
		
		newLiczba = liczba.toString().substring(0, deleteIndex) + liczba.toString().substring(deleteIndex + 1);
		
		liczba = Integer.parseInt(newLiczba);
		
		// If the number was negative we turn it back to negative
		if (isNegativeFlag)
			liczba = -liczba;
		
		return liczba;
	}

	// Metoda HultajChochla działa w ten sposób, że losowo zmienia wystąpienia dwóch cyfr w liczbie będącej argumentem.
	public Integer HultajChochla(Integer liczba) throws NieudanyPsikusException {
		
		// We check for null Input
		ArgumentNullChecker(liczba);
		
		// If the number is negative we turn it to positive
		boolean isNegativeFlag = false;
		if (liczba < 0) {
			isNegativeFlag = true;
			liczba = -liczba;
		}
		
		int amountOfNumbers  = liczba.toString().length();
		
		// If the length of the number is 1 we throw NPException
		if (amountOfNumbers  == 1)
			throw new NieudanyPsikusException();
		
		Random rand = new Random();
		int changeIndexOne = rand.nextInt(amountOfNumbers);
		int changeIndexTwo = rand.nextInt(amountOfNumbers);
		
		// The indexes should differ
		while (changeIndexOne == changeIndexTwo)
			changeIndexTwo = rand.nextInt(amountOfNumbers);
		
		String newNumber = "";
		
		for(int i = 0; i < amountOfNumbers ; i++) {
			if (i == changeIndexOne)
				newNumber += liczba.toString().charAt(changeIndexTwo);
			else if (i == changeIndexTwo)
				newNumber += liczba.toString().charAt(changeIndexOne);
			else
				newNumber += liczba.toString().charAt(i);
		}
		
		// If the number was negative we turn it back to negative
		liczba = Integer.parseInt(newNumber);
		if (isNegativeFlag)
			liczba = -liczba;
		
		return liczba;
	}

	// Metoda Nieksztaltek działa w ten sposób,
	// że w zadanej liczbie dokonuje jednej
	// losowej zmiany cyfr według schematu:
	// 3 -> 8
	// 7 -> 1
	// 6 -> 9
	public Integer Nieksztaltek(Integer liczba) {
		// We check for null Input
		ArgumentNullChecker(liczba);
		
		int numberOfValidNumbers = 0;
		
		// We're looking for the number of occurances of certain numbers
		for(char c : liczba.toString().toCharArray()) {
			if(c == '3' || c == '7' || c == '6')
				numberOfValidNumbers++;
		}
		
		// If the number of 3's 7's n 8's is 0 we return a number without changes
		if(numberOfValidNumbers == 0)
			return liczba;
		
		Random rand = new Random();
		
		// We're checking which number we should check
		int nuberToChange = rand.nextInt(numberOfValidNumbers);
		
		String newNumber = "";
		int WhichNumberToChangeFlag = 0;
		
		for(int i = 0; i < liczba.toString().length(); i++) {
			
			char SingleNumber = liczba.toString().charAt(i);
			
			// If the number(in the form of char) we're checking is 3 6 or 7 we check if its the number we're supposed to change 
			if (SingleNumber == '3' || SingleNumber == '6' || SingleNumber == '7') {
				
				// If it's the number we're supposed to change we change it concordantly to schema
				if (WhichNumberToChangeFlag == nuberToChange)	
					SingleNumber = NumberChanger(SingleNumber);
					
				WhichNumberToChangeFlag++;
			}
			newNumber += SingleNumber;
		}
		
		liczba = Integer.parseInt(newNumber);
		
		return liczba;
	}
	
	//A Checker metod to change numbers
	public char NumberChanger(char SingleNumber) {
		
		if(SingleNumber == '3')
			return '8';
		
		if(SingleNumber == '7')
			return '1';
		
		if(SingleNumber == '6')
			return '9';
		
		return SingleNumber;
	}

	public Integer Heheszki(Integer liczba) {
		
		ArgumentNullChecker(liczba);
		
		if (liczba < 0)
			throw new IllegalArgumentException();
		
		if (liczba == 0)
			return 0;
		
		Random rand = new Random();
		int newNumber = rand.nextInt(liczba);
		
		return newNumber;
	}

	public boolean Titit(Integer liczba_dziel) {
		
		ArgumentNullChecker(liczba_dziel);
		
		if (liczba_dziel == 0)
			throw new IllegalArgumentException();
		
		
		return liczba%liczba_dziel == 0;
	};
	
	public void ArgumentNullChecker(Integer liczba) {
		if (liczba == null)
			throw new IllegalArgumentException();
	}
}
