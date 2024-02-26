package mastermind.Game;

import lombok.Getter;

import java.util.Random;

@Getter
public enum Peg {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6");

    String value;
    private static final Random random = new Random();

    Peg(String value) {
    }

    public static Peg randomPeg()  {
        Peg[] pegs = values();
        return pegs[random.nextInt(pegs.length)];
    }

}
