package Mastermind.models;

import java.util.List;

public class Turn implements ITurn {
    private final SecretCode secretCode;
    private final Difficulty difficulty;
    private final List<IRound> rounds;
    private final int secretCodeSize;
    private final int colorPalletSize;
    private int scoreTotal;
    private IRound currentRound;


    public Turn(Difficulty difficulty, SecretCode secretCode, List<IRound> rounds, int colorPalletSize) {
        this.difficulty = difficulty;
        this.secretCode = secretCode;
        this.rounds = rounds;
        this.colorPalletSize = colorPalletSize;
        this.secretCodeSize = secretCode.size();
        this.currentRound = this.rounds.getFirst();
        this.scoreTotal = 0;
    }

    @Override
    public List<IRound> getRounds() {

        return rounds;
    }

    @Override
    public int getSecretCodeSize() {
        return secretCodeSize;
    }

    @Override
    public Difficulty getDifficulty() {
        return difficulty;
    }

    @Override
    public int getScoreTotal() {
        return this.scoreTotal;
    }

    @Override
    public SecretCode getSecretCode() {
        return secretCode;
    }

    @Override
    public int getNbOfColors() {
        return this.colorPalletSize;
    }

    @Override
    public IRound getCurrentRound() {
        return this.currentRound;
    }

    @Override
    public void setCurrentRound(IRound round) {
        this.currentRound = round;
    }

    @Override
    public int getScore() {
        int res = 0;
        for (IRound round : rounds) {
            res += round.getScore();
        }
        return res;
    }

    @Override
    public void setScore(int score) {
        this.scoreTotal = score;
    }
}
