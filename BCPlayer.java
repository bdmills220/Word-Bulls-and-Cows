/*
 * Developer: Brady Mills
 * Project: Bulls & Cows | Player Class
 * Last Updated Date: 5/9/2023
 * Description: Stores player statistics.
 */

public class BCPlayer
{
    private int wins;
    private int losses;

    // Default constructor
    public BCPlayer()
    {
        wins = 0;
        losses = 0;
    }

    // Add one win
    public void addWin()
    {
        wins++;
    }

    // Add one loss
    public void addLoss()
    {
        losses++;
    }

    // Display statistics
    public void playerStats()
    {
        System.out.println("\nStatistics");
        System.out.println("----------");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
    }

    @Override
    public String toString()
    {
        return "Wins: " + wins +
               " | Losses: " + losses;
    }
}