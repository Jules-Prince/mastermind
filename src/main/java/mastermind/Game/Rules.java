package mastermind.Game;

import java.util.Arrays;

public class Rules {

    //RULES
    public static final Integer NUMBERS_OF_PEGS = 4;
    public static final Boolean IS_DUPLICATES_ALLOWED = Boolean.FALSE;
    public static final Integer NUMBER_OF_ROWS = 10;

    public static void printRules() {
        System.out.println("----------------------------  RULES  ----------------------------");
        System.out.println("NUMBERS_OF_PEGS : " + Rules.NUMBERS_OF_PEGS);
        System.out.println("IS_DUPLICATES_ALLOWED : " + Rules.IS_DUPLICATES_ALLOWED);
        System.out.println("NUMBER_OF_ROWS : " + Rules.NUMBER_OF_ROWS);
        System.out.println("Pegs available : " + Arrays.toString(Peg.values()));
        System.out.println("-----------------------------------------------------------------\n");
    }
}
