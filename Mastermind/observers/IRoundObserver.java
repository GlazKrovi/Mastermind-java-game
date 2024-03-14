package Mastermind.observers;

import Mastermind.models.Attempt;
import Mastermind.models.Correction;
import Mastermind.models.PlayerPawn;

public interface IRoundObserver {
    void updateOneAttempt(PlayerPawn attemptPawn);

    void updateOneAttempt(Attempt attempt);

    void updateHints(Correction hints);
}
