
import mastermind.Combinaisons.Answer;
import mastermind.Combinaisons.Guess;
import mastermind.Combinaisons.exeptions.BadCombinationException;
import mastermind.Combinaisons.exeptions.UnknownPegException;
import mastermind.Game.Board;
import mastermind.Game.Peg;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class TestGuess {


    @Test
    public void testGetNumberOfRPPegs(){
        List<Peg> secretCombination = new ArrayList<>(){{add(Peg.THREE); add(Peg.THREE); add(Peg.ONE); add(Peg.TWO); add(Peg.FOUR);}};
        List<Peg> combination = new ArrayList<>(){{add(Peg.THREE); add(Peg.ONE); add(Peg.THREE); add(Peg.FOUR); add(Peg.FOUR);}};
        Guess guess = new Guess();

        Assertions.assertEquals(2, guess.getNumberOfRPPegs(combination, secretCombination));
        Assertions.assertEquals(3, secretCombination.size());
        Assertions.assertEquals(3, combination.size());
    }

    @Test
    public void testGetNumberOfWPPegs(){
        List<Peg> secretCombination = new ArrayList<>(){{add(Peg.THREE); add(Peg.THREE); add(Peg.ONE); add(Peg.TWO); add(Peg.FOUR);}};
        List<Peg> combination = new ArrayList<>(){{add(Peg.THREE); add(Peg.ONE); add(Peg.THREE); add(Peg.FOUR); add(Peg.FOUR);}};
        Guess guess = new Guess();

        Assertions.assertEquals(5, guess.getNumberOfWPPegs(combination, secretCombination));
    }

    @Test
    public void testComputeAnswer(){
        Board.secretCode = new ArrayList<>(){{add(Peg.THREE); add(Peg.THREE); add(Peg.ONE); add(Peg.TWO); add(Peg.FOUR);}};
        Guess guess = new Guess(new ArrayList<>(){{add(Peg.THREE); add(Peg.ONE); add(Peg.THREE); add(Peg.FOUR); add(Peg.FOUR);}});

        Answer answer = guess.computeAnswer();

        Assertions.assertEquals(2, answer.getRP_Pegs());
        Assertions.assertEquals(2, answer.getWP_Pegs());
    }

    @Test
    public void testRightGuess(){
        Board.secretCode = new ArrayList<>(){{add(Peg.FIVE); add(Peg.SIX); add(Peg.TWO); add(Peg.ONE); }};
        Guess guess = new Guess(new ArrayList<>(){{add(Peg.FIVE); add(Peg.SIX); add(Peg.TWO); add(Peg.ONE);}});

        Answer answer = guess.computeAnswer();

        Assertions.assertEquals(4, answer.getRP_Pegs());
        Assertions.assertEquals(0, answer.getWP_Pegs());
    }

    @Test
    public void testGuessStrToCombination() throws UnknownPegException, BadCombinationException {
        String combination = "1234";
        Guess guess = new Guess(combination);
        Assertions.assertEquals(4,  guess.getCombination().size());
        Assertions.assertEquals(new ArrayList<Peg>(){{add(Peg.ONE); add(Peg.TWO); add(Peg.THREE); add(Peg.FOUR);}}, guess.getCombination());

        combination = "3456";
        guess = new Guess(combination);
        Assertions.assertEquals(4,  guess.getCombination().size());
        Assertions.assertEquals(new ArrayList<Peg>(){{add(Peg.THREE); add(Peg.FOUR); add(Peg.FIVE); add(Peg.SIX);}}, guess.getCombination());

        Assertions.assertEquals("Guess{combination=[THREE, FOUR, FIVE, SIX]}", guess.toString());
    }

    @Test
    public void testGuessStrToCombinationError(){
        String combination = "12345";
        try {
            Guess guess = new Guess(combination);
        } catch (BadCombinationException | UnknownPegException e){
            System.out.println(e.getMessage());
        }

        combination = "7458";
        try {
            Guess guess = new Guess(combination);
        } catch (UnknownPegException | BadCombinationException e){
            System.out.println(e.getMessage());
        }

        combination = "abcd";
        try {
            Guess guess = new Guess(combination);
        } catch (UnknownPegException | BadCombinationException e){
            System.out.println(e.getMessage());
        }


    }
}
