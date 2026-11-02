import java.util.Random;
import java.util.Scanner;

/**
 * Task 2: Number Guessing Game.
 * The computer picks a random number between 1 and 100 (inclusive),
 * the player guesses until the number is found.
 */
public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        // nextInt(100) gives 0..99, so +1 gives 1..100 (inclusive)
        int randomNumber = rand.nextInt(100) + 1;

        int attempts = 0;            // counts the number of guesses
        boolean gameRunning = true;  // loop condition

        // Welcome message with the game rules
        System.out.println("=== Number Guessing Game ===");
        System.out.println("I am thinking of a number between 1 and 100.");
        System.out.println("Try to guess it! I will tell you if your guess is too small or too big.");
        System.out.println();

        // Repeat until the correct number is guessed
        while (gameRunning) {

            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++; // every guess counts as one attempt

            if (userGuess < randomNumber) {
                System.out.println("Too small!");
            } else if (userGuess > randomNumber) {
                System.out.println("Too big!");
            } else {
                // userGuess == randomNumber (use == for comparison, not =)
                System.out.println("You guessed it!");
                gameRunning = false; // end the game
            }
        }

        // Congratulatory message with the number of attempts
        System.out.println();
        System.out.println("Congratulations! The number was " + randomNumber + ".");
        System.out.println("It took you " + attempts + " attempt(s).");

        scanner.close();
    }
}