/**
 * Guessing App - Use Case 4: Error Handling & Validation
 * 
 * MAIN CLASS
 * 
 * This class coordinates the game execution while ensuring all user inputs are safely validated before processing
 * 
 * Responsibilites:
 *  - Intialize game configuration
 *  - Accept user input
 *  - Validate input using ValidationService
 *  - Handle game flow without crashing on invalid input
 * 
 * @author Developer
 * @version 4.0
**/
import java.util.*;

class GuessingApp{
    public static void main(String[] args) throws InvalidInputException {
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
            /*
             * User input is validated before being used in the game logic 
             */
            int guess = ValidationService.validateInput(scanner.nextLine());
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
            if (hintCount < config.getMaxHints()) {
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