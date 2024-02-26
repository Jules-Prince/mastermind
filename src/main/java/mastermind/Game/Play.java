package mastermind.Game;

import lombok.Getter;
import lombok.Setter;
import mastermind.Combinaisons.Answer;
import mastermind.Combinaisons.Guess;

@Getter
@Setter
public class Play {

    private Guess guess;
    private Answer answer;

    public Play(Guess guess) {
        this.guess = guess;
        this.answer = new Answer();
        this.evalPlay();
    }

    public void evalPlay(){
        this.setAnswer(this.getGuess().computeAnswer());
        System.out.println("There is " + this.getAnswer().getRP_Pegs() + " Peg.s at the right position and " 
        + this.getAnswer().getWP_Pegs() + " right Peg.s at the wrong spot");
    }
}
