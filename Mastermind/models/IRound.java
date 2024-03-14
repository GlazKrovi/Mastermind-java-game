package Mastermind.models;

import Mastermind.views.RoundView;


/**
 * Assembling an attempt and a correction
 * AKA "tentative"
 */
public interface IRound {
    int getNumber();

    int getScore();

    void setScore(int score);

    Attempt getAttempt();

    void setAttempt(Attempt attempt);

    Correction getHints();

    void setHints(Correction hints);

    void addObserver(RoundView roundView);

    void removeObserver(RoundView roundView);
}
