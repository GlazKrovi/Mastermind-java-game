package Mastermind.views;

import Mastermind.models.PlayerPawn;

import java.awt.*;

public class ColorMediator implements IColorMediator {

    private RoundView roundView;

    public void setRoundView(RoundView roundView) {
        this.roundView = roundView;
    }

    @Override
    public void update(Color color) {
        PlayerPawn pawn = new PlayerPawn(PlayerPawn.TranslateToPColor(color));
        roundView.updateOneAttempt(pawn);
    }
}
