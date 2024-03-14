package Mastermind.models;

/**
 * Une combinaison spécifique et immuable de pions, celle recherchée par le joueur lors d'un tour
 */
public class SecretCode extends Combination {
    public SecretCode(IPawn[] pawns) {
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
