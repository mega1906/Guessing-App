# Guessing-App

## USE CASE 1
This use case serves as the application entry point
It initializes the game configuration and displays game rules
No user input or gameplay logic is implemented at this stage

## USE CASE 2
Coordinates the game flow:
1. Initialize game
2. Accept user guesses
3. Validate guesses
4. Stop when game ends

## USE CASE 3
Coordinates the game flow:
1. Initialize game
2. Accept user guesses
3. Validate guesses
4. Give hints
5. Stop when game ends

## USE CASE 4
This use case coordinates the game execution while ensuring all user inputs are safely validated before processing
Responsibilites:
- Intialize game configuration
- Accept user input
- Validate input using ValidationService
- Handle game flow without crashing on invalid input

## USE CASE 5
This use case coordinates the game flow and persists the final result after completion
Responsibilites:
- Intialize game configuration
- Accept and validate user guesses
- Generate hints when applicable
- Store game result at the end

## USE CASE 6
This use case coordinates the complete game lifecycle, allowing the player to replay or exit gracefully
Responsibilites:
- Start a new game session
- Execute the guessing flow
- Persist game results
- Restart or exit based on user choice
