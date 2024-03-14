package Mastermind.models;

import Mastermind.observers.IBoardObserver;

public interface IBoard {
    IPlayer getPlayer();

    ITurn getActualTurn();

    void setActualTurn(ITurn turn);

    GameConfig getConfig();

    void setConfig(GameConfig config);

    void addObserver(IBoardObserver IBoardObserver);

    void removeObserver(IBoardObserver IBoardObserver);

    void notifyPlayer();

    void notifyTurn();
}
