package Mastermind.observers;

import Mastermind.models.IPlayer;
import Mastermind.models.ITurn;

public interface IBoardObserver {
    /**
     * To send name, score and nb of turn played
     *
     * @param player
     */
    void updatePlayer(IPlayer player);

    void updateActualTurn(ITurn turn);
}
