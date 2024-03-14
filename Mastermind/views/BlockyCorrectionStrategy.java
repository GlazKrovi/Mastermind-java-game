package Mastermind.views;

import javax.swing.*;

public abstract class BlockyCorrectionStrategy extends CorrectionStrategy {
    @Override
    public JPanel execute(int size) {
        // create new panel instance
        BlockyCorrectionView hintPanel = new BlockyCorrectionView(size);

        // save it
        this.panels.add(hintPanel);

        // pass to next active panel
        activePanel = panels.size() - 1;

        return hintPanel;
    }
}
