import java.util.Scanner;

public class Lab4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Generate a Random Integer
        int computer = (int)(Math.random() * 3);

        //Prompt the user to enter a integer
        System.out.print("scissor (0), rock (1), paper (2): ");
        int user = input.nextInt();

        System.out.print("The computer is ");
        switch (computer)
        {
            case 0: System.out.print("scissor."); break;
            case 1: System.out.print("rock."); break;
            case 2: System.out.print("paper.");
        }

        System.out.print(" You are ");
        switch (user)
        {
            case 0: System.out.print("scissor"); break;
            case 1: System.out.print("rock"); break;
            case 2: System.out.print("paper ");
        }

       //Display Results
        if (computer == user)
            System.out.println(" too. It is a draw");
        else
        {
            boolean win = (user == 0 && computer == 2) ||
                    (user == 1 && computer == 0) ||
                    (user == 2 && computer == 1);
            if (win)
                System.out.println(". You won");
            else
                System.out.println(". You lose");
        }
    }
}