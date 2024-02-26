import mastermind.Game.Board;
import mastermind.Game.Mastermind;
import mastermind.Game.Rules;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMastermind {

    @Test
    public void initMastermind(){
        Mastermind mastermind = new Mastermind();
        Assertions.assertEquals(Rules.NUMBERS_OF_PEGS, Board.secretCode.size());
    }
}
