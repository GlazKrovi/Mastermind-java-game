package Mastermind.models;

public interface IPlayer {
    /**
     * @return Name of player
     */
    String getName();

    /**
     * @return The player's score on all Turns already played
     */
    int getTotalScore();

    void setTotalScore(int score);

    /**
     * @return The number of Turns already played (and completed) by the player
     */
    int getPlayedTurnsNumber();

    void setPlayedTurnsNumber(int amount);
}
