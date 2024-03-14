package Mastermind.views;

import Mastermind.models.Correction;

public class EasyStrategy extends BlockyCorrectionStrategy {

    public EasyStrategy() {
    }

    @Override
    public int getScoreBonus() {
        return 0;
    }

    @Override
    protected void updateValues(Correction hints, CorrectionView view) {
        BlockyCorrectionView active = (BlockyCorrectionView) view;
        active.setColors(hints);

        // is init, so unable it
        active.unable = true;
    }
}
