package Mastermind.models;

import Mastermind.views.ClassicStrategy;
import Mastermind.views.CorrectionStrategy;
import Mastermind.views.EasyStrategy;
import Mastermind.views.NumericStrategy;

/**
 * A record of all game-related parameters
 */
public class GameConfig {
    public static final GameConfig DEFAULT_CONFIG = new GameConfig(
            new Player("Anonymous"),
            Difficulty.Easy,
            4,
            10,
            8,
            3
    );

    private final Player player;
    private final Difficulty difficulty;
    private final int secretCodeSize;
    private final int nbOfRounds;
    private final int nbOfTurns;
    private final int nbOfColors;


    /**
     * @param difficulty     difficulty of the game
     * @param secretCodeSize size of the secret code combination
     * @param nbOfRounds     number of rounds / attempts player have to win
     */
    public GameConfig(Player player, Difficulty difficulty, int secretCodeSize, int nbOfRounds, int nbOfColors, int maxNbOfTurn) {
        this.player = player;
        this.difficulty = difficulty;
        this.secretCodeSize = secretCodeSize;
        this.nbOfRounds = nbOfRounds;
        this.nbOfColors = nbOfColors;
        this.nbOfTurns = maxNbOfTurn;
    }

    public Player getPlayer() {
        return player;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public int getSecretCodeSize() {
        return secretCodeSize;
    }

    public int getNbOfRounds() {
        return nbOfRounds;
    }

    public int getMaxNbOfTurns() {
        return nbOfTurns;
    }

    public int getNbOfColors() {
        return nbOfColors;
    }

    public CorrectionStrategy getStrategyDraft() {
        CorrectionStrategy strategy;
        if (getDifficulty() == Difficulty.Easy) {
            strategy = new EasyStrategy();
        } else if (getDifficulty() == Difficulty.Classic) {
            strategy = new ClassicStrategy();
        } else {
            strategy = new NumericStrategy();
        }
        return strategy;
    }
}
