package Mastermind.models;

public interface ICombination {
    boolean contains(IPawn pawn);

    IPawn get(int index);

    int size();
}

