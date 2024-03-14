package Mastermind.models;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TurnBuilder {
    /**
     * @param size       Size of secret code to be generated
     * @param dispersion Size of color range to choose from
     * @return The generated secret code (pawn combination)
     */
    private static SecretCode generateSecretCode(int size, int dispersion) {
        Random rand = new Random();
        IPawn[] pawns = new IPawn[size];
        for (int i = 0; i < size; i++) {
            pawns[i] = new PlayerPawn(Pawn.getEnumPColor(rand.nextInt(dispersion)));
            System.out.println("Secret code [" + i + "] = " + pawns[i].getPColor());
        }
        System.out.println("---");
        return new SecretCode(pawns);
    }

    private static List<IRound> generateRounds(int nbRounds, int secretCodeSize) {
        List<IRound> rounds = new ArrayList<>();
        IPawn[] pawns = new IPawn[secretCodeSize];
        IPawn[] hints = new IPawn[secretCodeSize];
        for (int i = 0; i < nbRounds; i++) {
            rounds.add(new Round(i));

            for (int j = 0; j < secretCodeSize; j++) {
                pawns[j] = new PlayerPawn(PawnColor.WHITE);
                rounds.get(i).getAttempt().set(pawns);
            }
            for (int j = 0; j < secretCodeSize; j++) {
                hints[j] = new PlayerPawn(PawnColor.WHITE);
                rounds.get(i).getHints().set(hints);
            }
        }
        return rounds;
    }

    public static Turn createTurn(GameConfig config) {
        return new Turn(config.getDifficulty(), generateSecretCode(config.getSecretCodeSize(), config.getNbOfColors()), generateRounds(config.getNbOfRounds(), config.getSecretCodeSize()), config.getNbOfColors());
    }
}