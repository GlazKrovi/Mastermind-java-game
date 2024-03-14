package Mastermind.controllers;

import Mastermind.models.*;

import java.util.Hashtable;


public class RoundController {
    private IRound model;

    public RoundController(IRound model) {
        this.model = model;
    }

    public void modifyAttemptAt(Pawn PlayerPawn, int index) {
        IPawn[] pawn = new IPawn[this.model.getAttempt().size()];
        for (int i = 0; i < this.model.getAttempt().size(); i++) {
            if (i == index) {

                pawn[i] = PlayerPawn;

            } else {
                pawn[i] = this.model.getAttempt().get(i);
            }
        }
        Attempt attempt = new Attempt(pawn);
        this.model.setAttempt(attempt);
    }

    private Hint[] compare(SecretCode secretCode) {
        Hashtable<PawnColor, Integer> colorOccurrences = new Hashtable<>();
        for (int i = 0; i < secretCode.size(); i++) {
            PawnColor color = secretCode.get(i).getPColor();
            colorOccurrences.put(color, colorOccurrences.getOrDefault(color, 0) + 1);
        }

        Hint[] newHint = new Hint[this.model.getAttempt().size()];
        for (int i = 0; i < this.model.getAttempt().size(); i++) {
            PawnColor attemptColor = this.model.getAttempt().get(i).getPColor();
            if (attemptColor == secretCode.get(i).getPColor()) {
                newHint[i] = new Hint(PawnColor.GREEN);
                colorOccurrences.put(attemptColor, colorOccurrences.get(attemptColor) - 1);
            }
        }

        for (int i = 0; i < this.model.getAttempt().size(); i++) {
            PawnColor attemptColor = this.model.getAttempt().get(i).getPColor();
            if (newHint[i] == null) {
                if (secretCode.contains(this.model.getAttempt().get(i)) && colorOccurrences.get(attemptColor) > 0) {
                    newHint[i] = new Hint(PawnColor.WHITE);
                    colorOccurrences.put(attemptColor, colorOccurrences.get(attemptColor) - 1);
                } else {
                    newHint[i] = new Hint(PawnColor.BLACK);
                }
            }
        }

        return newHint;
    }

    private void modifyHint(Hint[] hint) {
        Correction hints = new Correction(hint);
        this.model.setHints(hints);
    }

    private int scoreCalculation() {
        int score = 0;
        for (int i = 0; i < this.model.getHints().size(); i++) {
            if (this.model.getHints().get(i).getPColor() == PawnColor.GREEN) {
                score += 3;
            } else if (this.model.getHints().get(i).getPColor() == PawnColor.WHITE) {
                score += 1;
            }
        }
        return score;
    }

    public void updateScore() {
        this.model.setScore(scoreCalculation());
    }

    public void check(SecretCode secretCode) {
        Hint[] hint = compare(secretCode);
        modifyHint(hint);
        updateScore();
    }

    public void setModel(IRound model) {
        this.model = model;
    }
}
