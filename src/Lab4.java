import java.util.Random;
import java.util.Scanner;
//Lab6
public class Lab4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        String[] options = {"scissors", "rock", "paper"};

        int userScore = 0;
        int computerScore = 0;

        while (true) {
            System.out.print("\nChoose your move (scissors, rock, paper), or type 'exit' to quit: ");
            String playerChoice = scan.nextLine().trim().toLowerCase();
            //Adding the quit option
            if (playerChoice.equals("exit")) {
                System.out.println("Final Score - You: " + userScore + ", Computer: " + computerScore);
                System.out.println("Thanks for playing!");
                break;
            }

            // Validate user input
            if (!playerChoice.equals("scissors") && !playerChoice.equals("rock") && !playerChoice.equals("paper")) {
                System.out.println("Invalid input. Please enter 'scissors', 'rock', 'paper', or 'exit'.");
                continue;
            }

            // Generate computer choice
            int computerIndex = random.nextInt(3);
            String computerChoice = options[computerIndex];
            System.out.println("Computer chose: " + computerChoice);

            if (playerChoice.equals(computerChoice)) {
                System.out.println("It's a tie!");
            } else if (
                    (playerChoice.equals("scissors") && computerChoice.equals("paper")) ||
                            (playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
                            (playerChoice.equals("paper") && computerChoice.equals("rock"))
            ) {
                System.out.println("You win!");
                userScore++;
            } else {
                System.out.println("You lose!");
                computerScore++;
            }

            System.out.println("Score => You: " + userScore + ", Computer: " + computerScore);
        }

        scan.close();
    }
}