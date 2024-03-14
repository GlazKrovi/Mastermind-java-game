package Mastermind.models;

public class Correction extends ModifiableCombination {
    private final IPawn[] pawns;

    public Correction(IPawn[] pawns) {
        super(pawns);
        this.pawns = pawns;
    }

    @Override
    protected void fill(IPawn[] pawns) {
        for (int i = 0; i < pawns.length; i++) {
            if (pawns[i] == null) {
                pawns[i] = new Hint(PawnColor.WHITE);
            }
        }
    }

    /**
     * @return the number of wrong placed pawns
     */
    public int getWrongs() {
        int res = 0;
        for (IPawn pawn : this.pawns) {
            if (pawn.getPColor() == PawnColor.BLACK) {
                res++;
            }
        }
        return res;
    }

    /**
     * @return the number of misplaced pawns
     */
    public int getMisplaced() {
        int res = 0;
        for (IPawn pawn : this.pawns) {
            if (pawn.getPColor() == PawnColor.WHITE) {
                res++;
            }
        }
        return res;
    }

    /**
     * @return the number of right placed pawns
     */
    public int getRights() {
        int res = 0;
        for (IPawn pawn : this.pawns) {
            if (pawn.getPColor() == PawnColor.GREEN) {
                res++;
            }
        }
        return res;
    }
}
