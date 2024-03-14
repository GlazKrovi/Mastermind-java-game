package Mastermind.models;

import java.awt.*;
import java.util.Hashtable;
import java.util.Map;

public abstract class Pawn implements IPawn {
    /* COMMON */
    private static final Map<PawnColor, Color> COLORS_ASSOCIATIONS = new Hashtable<>();

    static {
        COLORS_ASSOCIATIONS.put(PawnColor.RED, Color.RED);
        COLORS_ASSOCIATIONS.put(PawnColor.GREEN, Color.GREEN);
        COLORS_ASSOCIATIONS.put(PawnColor.BLUE, Color.BLUE);
        COLORS_ASSOCIATIONS.put(PawnColor.YELLOW, Color.YELLOW);
        COLORS_ASSOCIATIONS.put(PawnColor.ORANGE, Color.ORANGE);
        COLORS_ASSOCIATIONS.put(PawnColor.PINK, Color.PINK);
        COLORS_ASSOCIATIONS.put(PawnColor.GRAY, Color.GRAY);
        COLORS_ASSOCIATIONS.put(PawnColor.BROWN, Color.decode("#7B241C"));
        COLORS_ASSOCIATIONS.put(PawnColor.PURPLE, Color.MAGENTA);
        COLORS_ASSOCIATIONS.put(PawnColor.VIOLET, Color.decode("#8F24DE"));
        COLORS_ASSOCIATIONS.put(PawnColor.DUCKBLUE, Color.decode("#138D75"));
        COLORS_ASSOCIATIONS.put(PawnColor.AQUA, Color.CYAN);
        COLORS_ASSOCIATIONS.put(PawnColor.BLACK, Color.BLACK);
        COLORS_ASSOCIATIONS.put(PawnColor.WHITE, Color.WHITE);
    }

    /* OWN */
    private final PawnColor color;

    protected Pawn(PawnColor color) {
        this.color = color;
    }

    /**
     * @param pawnColor a PawnColor enum elm
     * @return The java color associated with the specified PawnColor
     */
    public static Color TranslateToJColor(PawnColor pawnColor) {
        return COLORS_ASSOCIATIONS.get(pawnColor);
    }

    /**
     * @param color a java color
     * @return The PawnColor associated with the specified java color
     */
    public static PawnColor TranslateToPColor(Color color) {
        for (Map.Entry<PawnColor, Color> entry : COLORS_ASSOCIATIONS.entrySet()) {  // equivalent of KeyValuePair<> in csharp
            if (entry.getValue().equals(color)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static Color getEnumJColor(int index) {
        return TranslateToJColor(PawnColor.values()[index]);
    }

    public static PawnColor getEnumPColor(int index) {
        return PawnColor.values()[index];
    }

    @Override
    public PawnColor getPColor() {
        return this.color;
    }

    @Override
    public Color getJColor() {
        return TranslateToJColor(this.color);
    }
}
