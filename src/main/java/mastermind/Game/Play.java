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
        this.evalPlay();
    }

    public void evalPlay(){
        this.answer = this.getGuess().computeAnswer();
        System.out.println(guess.computeAnswer());
    }
}
