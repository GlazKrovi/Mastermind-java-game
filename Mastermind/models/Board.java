package Mastermind.models;

import Mastermind.observers.IBoardObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * The complete board, where player plays his turns.
 */
public class Board implements IBoard {
    private final List<IBoardObserver> observers;
    private IPlayer player;
    private ITurn actualTurn;
    private GameConfig actualConfig;

    public Board() {
        this.player = new Player("Anonymous");
        this.observers = new ArrayList<>();
        this.actualConfig = GameConfig.DEFAULT_CONFIG;
        this.actualTurn = TurnBuilder.createTurn(actualConfig);
    }

    @Override
    public IPlayer getPlayer() {
        return this.player;
    }

    @Override
    public ITurn getActualTurn() {
        return this.actualTurn;
    }

    @Override
    public void setActualTurn(ITurn turn) {
        this.actualTurn = turn;
        notifyTurn();
        notifyPlayer();
    }

    @Override
    public GameConfig getConfig() {
        return actualConfig;
    }

    @Override
    public void setConfig(GameConfig config) {
        this.actualConfig = config;
        this.player = config.getPlayer();
        this.actualTurn = TurnBuilder.createTurn(config);
    }

    @Override
    public void addObserver(IBoardObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(IBoardObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyPlayer() {
        for (IBoardObserver observer : this.observers) {
            observer.updatePlayer(this.getPlayer());
        }
    }

    @Override
    public void notifyTurn() {
        for (IBoardObserver observer : this.observers) {
            observer.updateActualTurn(this.getActualTurn());
        }
    }
}

