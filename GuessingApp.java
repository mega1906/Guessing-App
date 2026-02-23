/**
 * Guessing App - Use Case 3: Hint Generation
 * 
 * MAIN CLASS
 * 
 * Coordinates the game flow:
 * 1. Initialize game
 * 2. Accept user guesses
 * 3. Validate guesses
 * 4. Give hints
 * 5. Stop when game ends
 * 
 * @author Developer
 * @version 3.0
**/
import java.util.*;

class GuessingApp{
    public static void main(String[] args){
        System.out.println("Welcome to the Guessing App!");
        GameConfig config = new GameConfig();
        config.showRules();

        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        int hintCount = 1;
        String hint = new String();

        /*
         * Game loop runs until the player exhausts the maximum attempts
         */
        while (attempts < config.getMaxAttempts()){
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            String result = GuessValidator.validateGuess(guess, config.getTargetNumber());
        
            /*
             * Stop the loop immediately if the correct number is guessed
             */
            if ("CORRECT".equals(result)){
                System.out.println(result);
                break;
            }

            /*
             * Print hint if the hintCount is less than 4 
             */
            if (hintCount < 4) {
                hint = HintService.generateHint(config.getTargetNumber(), hintCount);
                hintCount++;
                System.out.println(hint);
            }

            /*
             * Print the result message 
             */
            System.out.println(result);
        }
    }
}