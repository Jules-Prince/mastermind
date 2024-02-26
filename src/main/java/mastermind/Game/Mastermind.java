package mastermind.Game;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
public class Mastermind {

    //Choose a secret code
    //Create the board
    //create the list of every possibility

    public Board board;
    private Scanner scanner;

    public Mastermind() {
        this.init();
        this.board = new Board();
        this.scanner = new Scanner(System.in);
    }

    private void init() {
        List<Peg> secretCode = this.generateCombinaison();
        Board.secretCode = secretCode;

    }

    public void play() {
        Rules.printRules();

        this.getBoard().startPlaying(this.getScanner());
    }

    public List<Peg> generateCombinaison() {
        List<Peg> guessPegs = new ArrayList<>();
        for(int i = 0; i < Rules.NUMBERS_OF_PEGS; i++ ){
            Peg randomPeg = Peg.randomPeg();
            if(!Rules.IS_DUPLICATES_ALLOWED) {
                if(guessPegs.contains(randomPeg)){
                    while(guessPegs.contains(randomPeg)) {
                        randomPeg = Peg.randomPeg();
                    }
                }
            }
            guessPegs.add(randomPeg);
        }
        return guessPegs;
    }
}
