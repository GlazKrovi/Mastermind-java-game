package Mastermind.models;

import Mastermind.observers.IRoundObserver;
import Mastermind.views.RoundView;

import java.util.ArrayList;
import java.util.List;


public class Round implements IRound {
    private final int number;
    private final List<IRoundObserver> observers;
    private int score;
    private Attempt attempt;
    private Correction hints;

    public Round(int number) {
        this.number = number;
        this.score = 0;
        this.attempt = new Attempt(new Pawn[4]);
        this.hints = new Correction(new Hint[4]);
        this.observers = new ArrayList<>();
    }

    @Override
    public int getNumber() {
        return this.number;
    }

    @Override
    public int getScore() {
        return this.score;
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public Attempt getAttempt() {
        return this.attempt;
    }

    @Override
    public void setAttempt(Attempt attempt) {
        if (!this.attempt.equals(attempt)) { // Assuming Attempt class has an overridden equals method
            this.attempt = attempt;
            notifyAttempts();
        }
    }

    @Override
    public Correction getHints() {
        return this.hints;
    }

    @Override
    public void setHints(Correction hints) {
        if (!this.hints.equals(hints)) { // Assuming HintsCombination class has an overridden equals method
            this.hints = hints;
            notifyHints();
        }
    }

    @Override
    public void addObserver(RoundView roundView) {
        this.observers.add(roundView);
    }

    @Override
    public void removeObserver(RoundView roundView) {
        this.observers.remove(roundView);
    }

    private void notifyHints() {
        for (IRoundObserver observer : this.observers) {
            observer.updateHints(this.hints);
        }
    }

    private void notifyAttempts() {
        for (IRoundObserver observer : this.observers) {
            observer.updateOneAttempt(this.attempt);
        }
    }
}
