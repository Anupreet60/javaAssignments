import java.util.Random;
import java.io.*;
import java.util.*;
//Start Lab3
public class Lab1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random ran = new Random();

        // Declare topics and the name of files
        String[] topics ={ "Seasons","Countries","Colors"};
       String[] files ={"seasons.txt","countries.txt","colors.txt"};//files

        boolean playAgain = true;
       //Start the Game
        while (playAgain) {
           //Show menu of topic
            System.out.println("Chosse a topic:");
            for(int i = 0; i < topics.length; i++){
                System.out.println(topics[i]);
            }
            System.out.println("Enter your choice(1/2/3):");
            int choice =scanner.nextInt();

            //validating user choice
            if(choice<1 || choice>3) {
                System.out.println("Invalid choice.Please select a valid topic");
                continue;
            }
            //Load words from file
            List<String> words = loadWordsFromFile(files[choice - 1]);
            if(words.isEmpty()){
                System.out.println("NO words found in the topic");
                continue;
            }
            //Select a word
            String selectedWord = words.get(ran.nextInt(words.size()));
            char[] hiddenWord = new char[selectedWord.length()];
            Arrays.fill(hiddenWord,'*');


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

    private static List<String>loadWordsFromFile(String filename) {
        List<String> words = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while((line = reader.readLine()) != null)

            {
                if (!line.trim().isEmpty()) {
                    words.add(line.trim());

                }
            }
        }catch(IOException e) {
          System.out.println("Error reading" +filename);

        }
        return words;
    }
}

