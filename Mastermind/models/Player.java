package Mastermind.models;

public class Player implements IPlayer {
    private final String name;
    private int score;
    private int turnsAlreadyPlayed;

    public Player() {
        this.name = "Anonymous";
    }

    public Player(String name) {
        if (name.isEmpty()) this.name = "Anonymous";
        else this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getTotalScore() {
        return score;
    }

    @Override
    public void setTotalScore(int score) {
        this.score = score;
    }

    @Override
    public int getPlayedTurnsNumber() {
        return turnsAlreadyPlayed;
    }

    @Override
    public void setPlayedTurnsNumber(int amount) {
        this.turnsAlreadyPlayed = amount;
    }
}
