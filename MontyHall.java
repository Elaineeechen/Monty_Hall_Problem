package MyPackage;

import java.util.Random;

/**
 * Monty Hall Problem Simulation
 * @author elaineeechen
 * Date created: 21st August
 */

public class MontyHall {

	public static void main(String[] args) {
		
		// Initializes the number of times winning the car without or after switching doors.
		int numWinSwitched = 0;
		int numWinDidntSwitch = 0;
		
		Random r = new Random();
		
		// This for loop simulates 100 rounds of the gambling game.
		for (int i = 0; i < 1000; i++) {
			
			int doorChosen = r.nextInt(3); // Randomly chooses and assigns the index of the door that is chosen by the audience.
			int doorOpened = r.nextInt(3); // Randomly chooses and assigns the index of the door that is opened by the emcee.
			
			int doorWCar = r.nextInt(3); // Randomly chooses and assigns the index of the door that has the car behind.
			
			// This while loop ensures that the door chosen by the audience isn't the same door opened by the emcee or the same door that has a car behind.
			// It first tests whether the indices of the two doors are the same. If the condition is true, a new, random index is generated and assigned to door Opened. 
			while (doorOpened == doorChosen | doorOpened == doorWCar) {
				doorOpened = r.nextInt(3);
			}
			
			int doorRemained = 3 - doorChosen - doorOpened; // Represents the index of door that was neither opened nor chosen initially. 
			
			// Aggregates the number of times winning the car without or after switching doors.
			if (doorChosen == doorWCar) {
				numWinDidntSwitch++;
			} else if (doorRemained == doorWCar) {
				numWinSwitched++;
			}
			
		}
		
		System.out.println("The number of times winning the car by switching the door: " + numWinSwitched);
		System.out.println("The number of times winning the car without switching the door: " + numWinDidntSwitch);
		
		if (numWinDidntSwitch > numWinSwitched) {
			System.out.println("The probability of winning the car without switching the door is greater.");
		} else if (numWinDidntSwitch < numWinSwitched) {
			System.out.println("The probability of winning the car by switching the door is greater.");
		} else if (numWinDidntSwitch == numWinSwitched) {
			System.out.println("It doesn't matter if the audience switch/don't switch the door. The probabilty of winning the car is equal.");
		}
	}

}
