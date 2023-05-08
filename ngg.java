package oasis;
import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int rangeMin = 1;
        int rangeMax = 100;
        int numRounds = 3; // number of rounds to play
        int roundCount = 0;
        int totalScore = 0;
        int score = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You will have " + numRounds + " rounds to guess the number between " + rangeMin + " and " + rangeMax + ".");
        System.out.println("Each correct guess earns you points based on the number of attempts taken.");
        
        while (roundCount < numRounds) {
            int targetNum = rand.nextInt(rangeMax - rangeMin + 1) + rangeMin;
            int attempts = 0;
            System.out.println("\nROUND " + (roundCount + 1) + ":");
            System.out.print("Guess the number: ");
            
            while (true) {
                int guess = sc.nextInt();
                attempts++;
                
                if (guess == targetNum) {
                    score = rangeMax - rangeMin + 1 - attempts;
                    totalScore += score;
                    System.out.println("Congratulations! You guessed the number " + targetNum + " in " + attempts + " attempts.");
                    System.out.println("You earned " + score + " points this round.");
                    break;
                } else if (guess < targetNum) {
                    System.out.print("Higher. Guess again: ");
                } else {
                    System.out.print("Lower. Guess again: ");
                }
                
                if (attempts == 10) { // limit the number of attempts
                    System.out.println("Sorry, you've reached the maximum number of attempts.");
                    break;
                }
            }
            
            roundCount++;
        }
        
        System.out.println("\nGAME OVER");
        System.out.println("Total score: " + totalScore);


	}

}
