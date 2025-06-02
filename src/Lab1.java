import java.util.Random;
import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random ran = new Random();

        // Declare an array to store words
        String[] words = {"Spring", "Summer", "Autumn", "Winter", "Canada", "Japan", "Brazil", "Australia", "Germany", "Red", "Blue", "Green", "Yellow", "Purple"};

        boolean playAgain = true;

        while (playAgain) {
            // Randomly select a word
            String selectedWord = words[ran.nextInt(words.length)];
            char[] hiddenWord = new char[selectedWord.length()];
            for (int i = 0; i < hiddenWord.length; i++) {
                hiddenWord[i] = '*';
            }

            int incorrectGuesses = 0;
            boolean isWordGuessed = false;
            StringBuilder guessedChars = new StringBuilder();

            // Start the guessing game
            while (!isWordGuessed) {

                System.out.print("(Guess) Enter a letter in word " + new String(hiddenWord) + " > ");
                char guess = scanner.next().charAt(0);

                // Check if the letter has already been guessed
                if (guessedChars.toString().contains(String.valueOf(guess))) {
                    System.out.println(guess + " has already been guessed.");
                    continue;
                }
                guessedChars.append(guess);

                boolean isCorrectGuess = false;
                for (int i = 0; i < selectedWord.length(); i++) {
                    if (selectedWord.charAt(i) == guess) {
                        hiddenWord[i] = guess;
                        isCorrectGuess = true;
                    }
                }

                // Check if the guess was incorrect
                if (!isCorrectGuess) {
                    System.out.println(guess + " is not in the word.");
                    incorrectGuesses++;
                }

                // Check if the word has been guessed
                if (new String(hiddenWord).equals(selectedWord)) {
                    isWordGuessed = true;
                    System.out.println("The word is " + selectedWord + ". You missed " + incorrectGuesses + " time(s).");
                }
            }

            // Ask if the user wants to play again
            System.out.print("\nDo you want to guess another word? (y/n): ");
            char userChoice = scanner.next().toLowerCase().charAt(0);
            playAgain = (userChoice == 'y');
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
