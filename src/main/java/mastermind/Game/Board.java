package mastermind.Game;

import lombok.Getter;
import lombok.Setter;
import mastermind.Combinaisons.Answer;
import mastermind.Combinaisons.Guess;
import mastermind.Combinaisons.exeptions.BadCombinationException;
import mastermind.Combinaisons.exeptions.UnknownPegException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@Getter
@Setter
public class Board {

    private List<Play> guesses;
    public static List<Peg> secretCode;

    public Board() {
        this.guesses = new ArrayList<>();
    }

    public void startPlaying(Scanner scanner){
        Answer answer = new Answer();

        while(this.testIfPlayerHasFinished(answer)){
            answer = newPlay(scanner, answer);
        }

        endGame(answer);
    }

    private void endGame(Answer lastAnswer) {
        if(Objects.equals(lastAnswer.getRP_Pegs(), Rules.NUMBERS_OF_PEGS)){
            System.out.println("\nCongrats you did it within " + (this.getGuesses().size()) + " guesses");
        } else {
            System.out.println("You have no more tries, the secret code was : " + Board.secretCode);
        }
    }

    private Answer newPlay(Scanner scanner, Answer answer) {
        System.out.println("--------------------------  GUESS n-" + (this.getGuesses().size()+1) + "  --------------------------");
        System.out.print("Enter A Combinaison ---> ");
        String combinationStr = scanner.nextLine();
        try {
            Guess guess = new Guess(combinationStr);
            Play newPlay = new Play(guess);
            this.getGuesses().add(newPlay);
            answer = newPlay.getAnswer();
        } catch (BadCombinationException | UnknownPegException exception) {
            System.out.println(exception.getMessage());
        }
        System.out.println("-----------------------------------------------------------------\n\n");
        return answer;
    }

    private boolean testIfPlayerHasFinished(Answer answer) {
        return !Objects.equals(answer.getRP_Pegs(), Rules.NUMBERS_OF_PEGS) && (this.getGuesses().size()+1 <= Rules.NUMBER_OF_ROWS);
    }


}
