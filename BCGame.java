import java.util.Scanner;

/*
 * Developer: Brady Mills
 * Project: Bulls & Cows | Game Class
 * Last Updated Date: 5/9/2023
 * Description: Driver class for Bulls & Cows. The game supports Single Player and Two Player modes.
 */

public class BCGame
{
    private static Scanner in = new Scanner(System.in);

    private static BCPlayer player = new BCPlayer();

    public static void main(String[] args)
    {
        BCBoard.displayInstructions();

        boolean running = true;

        while (running)
        {
            System.out.println("\n=========================");
            System.out.println("        MAIN MENU");
            System.out.println("=========================");
            System.out.println("1. Single Player");
            System.out.println("2. Two Player");
            System.out.println("3. Statistics");
            System.out.println("4. Quit");

            System.out.print("\nSelect an option: ");

            String choice = in.nextLine().trim();

            switch (choice)
            {
                case "1":
                    playSinglePlayer();
                    break;

                case "2":
                    playTwoPlayer();
                    break;

                case "3":
                    player.playerStats();
                    break;

                case "4":
                    running = false;
                    break;

                default:
                    System.out.println(
                        "\nInvalid option. Please enter 1-4.");
            }
        }

        System.out.println("\nThank you for playing Bulls & Cows!");
    }

    // Single Player Mode
    public static void playSinglePlayer()
    {
        System.out.println("\n--- Single Player Mode ---");

        BCBoard.randWord();

        boolean won = BCBoard.guessWord();

        if (won)
        {
            player.addWin();
        }
        else
        {
            player.addLoss();
        }
    }

    // Two Player Mode
    public static void playTwoPlayer()
    {
        System.out.println("\n--- Two Player Mode ---");

        BCBoard.chooseSecretWord();

        boolean won = BCBoard.guessWord();

        if (won)
        {
            System.out.println("\nPlayer 2 guessed the word!");
        }
        else
        {
            System.out.println("\nPlayer 1 wins!");
        }
    }
}