import java.util.Random;
import java.util.Scanner;

/*
 * Developer: Brady Mills
 * Project: Bulls & Cows | Board Class
 * Last Updated Date: 5/9/2023
 * Description: Handles word selection, guessing, and Bulls & Cows calculations.
 */

public class BCBoard
{
    private static Scanner in = new Scanner(System.in);

    // Collection of possible secret words
    static String[] wordBank =
    {
        "cake", "joke", "duck", "fish",
        "sand", "clam", "rain", "tree",
        "frog", "time", "love", "fire",
        "girl", "book", "song", "bear",
        "belt", "band", "bath"
    };

    static String secret = "";
    static String currentGuess = "";

    // Display game instructions
    public static void displayInstructions()
    {
        System.out.println("=================================");
        System.out.println("         BULLS & COWS");
        System.out.println("=================================");

        System.out.println("\nWelcome to Bulls & Cows!");

        System.out.println("\nRules:");
        System.out.println("- Guess the secret 4-letter word.");
        System.out.println("- Bulls = correct letter in the correct position.");
        System.out.println("- Cows = correct letter in the wrong position.");
        System.out.println("- Repeated letters count only once.");
        System.out.println("- Bulls are counted before Cows.");
        System.out.println("- Type QUIT at any time.");
    }

    // Randomly selects a secret word
    public static void randWord()
    {
        Random gen = new Random();

        int index = gen.nextInt(wordBank.length);

        secret = wordBank[index];
    }

    // Allows Player 1 to choose the word
    public static void chooseSecretWord()
    {
        while (true)
        {
            System.out.print(
                "\nPlayer 1, enter a secret 4-letter word: ");

            secret = in.nextLine()
                       .toLowerCase()
                       .trim();

            if (secret.length() != 4)
            {
                System.out.println(
                    "Error: Word must contain exactly 4 letters.");
                continue;
            }

            if (!secret.matches("[a-zA-Z]+"))
            {
                System.out.println(
                    "Error: Letters only.");
                continue;
            }

            break;
        }

        // Hide the word from Player 2
        for (int i = 0; i < 50; i++)
        {
            System.out.println();
        }
    }

    /**
     * Main guessing loop
     * @return true if guessed correctly
     */
    public static boolean guessWord()
    {
        int turns = 1;

        while (true)
        {
            System.out.print(
                "\nTurn " + turns +
                " - Enter a 4-letter word (or QUIT): ");

            currentGuess =
                in.nextLine()
                  .toLowerCase()
                  .trim();

            // Quit option
            if (currentGuess.equals("quit"))
            {
                while (true)
                {
                    System.out.print(
                        "Are you sure you want to quit? (yes/no): ");

                    String response =
                        in.nextLine()
                          .toLowerCase()
                          .trim();

                    if (response.equals("yes"))
                    {
                        return false;
                    }
                    else if (response.equals("no"))
                    {
                        break;
                    }
                    else
                    {
                        System.out.println(
                            "Invalid input. Enter yes or no.");
                    }
                }

                continue;
            }

            // Validate length
            if (currentGuess.length() != 4)
            {
                System.out.println(
                    "Error: Enter exactly 4 letters.");
                continue;
            }

            // Validate letters only
            if (!currentGuess.matches("[a-zA-Z]+"))
            {
                System.out.println(
                    "Error: Letters only.");
                continue;
            }

            // Correct answer
            if (currentGuess.equals(secret))
            {
                System.out.println("\nCongratulations!");
                System.out.println(
                    "You guessed the word: " + secret);
                System.out.println(
                    "Total turns: " + turns);

                return true;
            }

            calcBullsAndCows();

            turns++;
        }
    }

    /**
     * Calculates Bulls and Cows.
     * Bulls are counted first.
     * Repeated letters count only once.
     */
    public static void calcBullsAndCows()
    {
        int bulls = 0;
        int cows = 0;

        boolean[] secretUsed =
            new boolean[secret.length()];

        boolean[] guessUsed =
            new boolean[currentGuess.length()];

        // Count Bulls first
        for (int i = 0; i < secret.length(); i++)
        {
            if (currentGuess.charAt(i)
                == secret.charAt(i))
            {
                bulls++;

                secretUsed[i] = true;
                guessUsed[i] = true;
            }
        }

        // Count Cows second
        for (int i = 0; i < currentGuess.length(); i++)
        {
            if (guessUsed[i])
            {
                continue;
            }

            for (int j = 0; j < secret.length(); j++)
            {
                if (!secretUsed[j]
                    &&
                    currentGuess.charAt(i)
                    == secret.charAt(j))
                {
                    cows++;

                    secretUsed[j] = true;

                    break;
                }
            }
        }

        System.out.println(
            "Result: " +
            bulls + " Bull(s), " +
            cows + " Cow(s)");
    }
}