/**
 * Guessing App - Use Case 6: Game Restart & Exit
 * 
 * MAIN CLASS
 * 
 * This class coordinates the complete game lifecycle, allowing the player to replay or exit gracefully
 * 
 * Responsibilites:
 *  - Start a new game session
 *  - Execute the guessing flow
 *  - Persist game results
 *  - Restart or exit based on user choice
 * 
 * @author Developer
 * @version 6.0
**/
import java.util.*;

class GuessingApp{
    public static void main(String[] args) throws InvalidInputException {
        System.out.println("============================");
        System.out.println("Welcome to the Guessing App!");
        System.out.println("============================");

        Scanner scanner = new Scanner(System.in);
        boolean restart;

        /*
         * Outer loop controls whether a new game session should start 
         */
        do {
        /*
         * Player name is captured once
         * and stored along with game results 
         */
        System.out.print("Enter Player Name: ");
        String player = scanner.nextLine();

        GameConfig config = new GameConfig();
        config.showRules();

        int attempts = 0;
        int hintCount = 1;
        String hint = new String();

        /*
         * Tracks whether the player successfully guessed the number 
         */
        boolean win = false;

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
                win = true;
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
        StorageService.saveResult(player, attempts, win);
        restart = GameController.restartGame(scanner);
        } while (restart);
    }
}