package classes;

public enum Difficulty {
    EASY(1),
    MEDIUM(2),
    HARD(3);

    private final int diff;

    Difficulty(int df) {
        diff = df;
    }

    public int getDiff() { return diff; }

    public static Difficulty fromNum(int df) {
        switch (df) {
            case 1: return Difficulty.EASY;
            case 2: return Difficulty.MEDIUM;
            case 3: return Difficulty.HARD;
        }
        return null;
    }
}

