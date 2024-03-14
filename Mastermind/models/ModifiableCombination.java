package Mastermind.models;

import java.util.Arrays;

/**
 * Combinaison modifiable de pions
 */
public abstract class ModifiableCombination extends Combination {
    protected ModifiableCombination(IPawn[] pawns) {
        super(pawns);
    }

    public void set(IPawn[] pawns) {
        this.pawns.clear();
        this.pawns.addAll(Arrays.asList(pawns));
    }
}