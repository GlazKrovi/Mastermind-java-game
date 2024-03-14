package Mastermind.views;

import Mastermind.models.Correction;

import javax.swing.*;
import java.util.ArrayList;

public abstract class CorrectionStrategy {
    protected final ArrayList<CorrectionView> panels;
    protected int activePanel;
    protected boolean allIsInitialized;
    // panel management prevents modification of the last panel. Here is an exceptional authorization:
    protected boolean lastToModify;

    protected CorrectionStrategy() {
        panels = new ArrayList<>();
        activePanel = -1;
        allIsInitialized = false;
        lastToModify = false;
    }

    public abstract JPanel execute(int size);

    public void update(Correction hints) {
        if (panels.get(activePanel).unable
                && activePanel == panels.size() - 1
                && !lastToModify) {
            activePanel = 0;
            allIsInitialized = true;
            lastToModify = true;
        }

        if (activePanel >= 0) {
            updateValues(hints, panels.get(activePanel));
            panels.get(activePanel).unable = true;
        }

        if (allIsInitialized) {
            activePanel++;
        }
    }

    public abstract int getScoreBonus();

    protected abstract void updateValues(Correction hints, CorrectionView view);
}
