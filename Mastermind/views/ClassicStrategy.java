package Mastermind.views;

import Mastermind.models.Correction;
import Mastermind.models.Hint;
import Mastermind.models.PawnColor;

public class ClassicStrategy extends BlockyCorrectionStrategy {
    public ClassicStrategy() {
        super();
    }

    @Override
    public int getScoreBonus() {
        return 4;
    }

    @Override
    protected void updateValues(Correction hints, CorrectionView view) {
        // create a new correction with the good order
        Hint[] orderedHints = new Hint[hints.size()];
        // add "wrongs" pawns
        for (int i = 0; i < hints.getWrongs() + hints.getMisplaced(); i++) {
            orderedHints[i] = new Hint(PawnColor.WHITE);
        }
        // add "rights" pawns
        for (int i = 0; i < hints.getRights(); i++) {
            orderedHints[i] = new Hint(PawnColor.BLACK);
        }
        BlockyCorrectionView active = (BlockyCorrectionView) view;
        active.setColors(new Correction(orderedHints));

        // is init, so unable it
        active.unable = true;
    }
}
