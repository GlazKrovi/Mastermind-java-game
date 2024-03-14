package Mastermind.models;

/**
 * A player's attempt
 */
public class Attempt extends ModifiableCombination {
    public Attempt(IPawn[] pawns) {
        super(pawns);
    }

    @Override
    protected void fill(IPawn[] pawns) {
        {
            for (int i = 0; i < pawns.length; i++) {
                if (pawns[i] == null) {
                    pawns[i] = new PlayerPawn(PawnColor.WHITE);
                }
            }
        }
    }
}
