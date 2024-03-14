package Mastermind.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * An immutable combination (group) of pawns
 */
public abstract class Combination implements ICombination {
    protected final List<IPawn> pawns;

    protected Combination(IPawn[] pawns) {
        fill(pawns); // security (avoid null)
        this.pawns = new ArrayList<>();
        this.pawns.addAll(Arrays.asList(pawns));
    }

    @Override
    public boolean contains(IPawn pawn) {
        for (IPawn p : pawns) {
            if (p == null) {
                return false;
            }
            if (p.getPColor() == pawn.getPColor()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public IPawn get(int index) {
        return pawns.get(index);
    }

    @Override
    public int size() {
        return pawns.size();
    }

    /**
     * Fills any empty cells in the table with a default pawn.
     * NB: Automatically called up when the combination is created!
     *
     * @param pawns Partially filled or empty pawn array
     */
    protected abstract void fill(IPawn[] pawns);
}
