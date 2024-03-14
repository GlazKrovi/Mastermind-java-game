package Mastermind.views;

import Mastermind.models.Correction;

import javax.swing.*;

public class NumericStrategy extends CorrectionStrategy {
    public NumericStrategy() {
        super();
    }

    @Override
    public JPanel execute(int size) {
        // create new panel instance
        NumericHintPanel hintPanel = new NumericHintPanel();

        // save it
        this.panels.add(hintPanel);

        // pass to next active panel
        activePanel = panels.size() - 1;

        return hintPanel;
    }

    @Override
    public int getScoreBonus() {
        return 0;
    }

    @Override
    protected void updateValues(Correction hints, CorrectionView view) {
        ((NumericHintPanel) view).setRightsNumber(hints.getRights());
        ((NumericHintPanel) view).setWrongsNumber(hints.getWrongs() + hints.getMisplaced());

        // is init, so unable it
        view.unable = true;
    }
}
