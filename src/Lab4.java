import java.util.Random;
import java.util.Scanner;

public class Lab4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        String[] options = {"scissors", "rock", "paper", "lizard", "spock"};

        int userScore = 0;
        int computerScore = 0;

        while (true) {
            System.out.print("\nChoose your move (scissors, rock, paper, lizard, spock), or type 'exit' to quit: ");
            String playerChoice = scan.nextLine().trim().toLowerCase();

            if (playerChoice.equals("exit")) {
                System.out.println("Final Score - You: " + userScore + ", Computer: " + computerScore);
                System.out.println("Thanks for playing!");
                break;
            }

            if (!playerChoice.equals("scissors") && !playerChoice.equals("rock") &&
                    !playerChoice.equals("paper") && !playerChoice.equals("lizard") &&
                    !playerChoice.equals("spock")) {
                System.out.println("Invalid input. Please enter 'scissors', 'rock', 'paper', 'lizard', 'spock', or 'exit'.");
                continue;
            }

            String computerChoice = options[random.nextInt(options.length)];
            System.out.println("Computer chose: " + computerChoice);

            if (playerChoice.equals(computerChoice)) {
                System.out.println("It's a tie!");
            } else if (
                    (playerChoice.equals("scissors") && (computerChoice.equals("paper") || computerChoice.equals("lizard"))) ||
                            (playerChoice.equals("rock") && (computerChoice.equals("scissors") || computerChoice.equals("lizard"))) ||
                            (playerChoice.equals("paper") && (computerChoice.equals("rock") || computerChoice.equals("spock"))) ||
                            (playerChoice.equals("lizard") && (computerChoice.equals("spock") || computerChoice.equals("paper"))) ||
                            (playerChoice.equals("spock") && (computerChoice.equals("scissors") || computerChoice.equals("rock")))
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
