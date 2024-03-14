package Mastermind.models;

import java.util.List;


/**
 * Assembling of IRound
 * AKA "manche"
 */
public interface ITurn {
    List<IRound> getRounds();

    int getSecretCodeSize();

    Difficulty getDifficulty();

    int getScoreTotal();

    SecretCode getSecretCode();

    int getNbOfColors();

    IRound getCurrentRound();

    void setCurrentRound(IRound round);

    /**
     * @return The sum of all rounds' score
     */
    int getScore();

    void setScore(int score);
}
