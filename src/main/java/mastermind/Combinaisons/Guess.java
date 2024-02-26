package mastermind.Combinaisons;

import lombok.Getter;
import lombok.Setter;
import mastermind.Combinaisons.exeptions.BadCombinationException;
import mastermind.Combinaisons.exeptions.UnknownPegException;
import mastermind.Game.Board;
import mastermind.Game.Mastermind;
import mastermind.Game.Peg;
import mastermind.Game.Rules;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Guess {

    private List<Peg> combination;

    public Guess() {
        this.combination = new ArrayList<>();
    }



    public Guess(String combinationStr) throws BadCombinationException, UnknownPegException {
        this();

        if (combinationStr.length() > Rules.NUMBERS_OF_PEGS ||
                combinationStr.length() < Rules.NUMBERS_OF_PEGS) {
            throw new BadCombinationException("The combination doesn't have the right amount of pegs, it should be " + Rules.NUMBERS_OF_PEGS);
        }

        for (Character peg : combinationStr.toCharArray()) {
            if (Character.isDigit(peg)) {
                switch (peg) {
                    case '1':
                        this.getCombination().add(Peg.ONE);
                        break;
                    case '2':
                        this.getCombination().add(Peg.TWO);
                        break;
                    case '3':
                        this.getCombination().add(Peg.THREE);
                        break;
                    case '4':
                        this.getCombination().add(Peg.FOUR);
                        break;
                    case '5':
                        this.getCombination().add(Peg.FIVE);
                        break;
                    case '6':
                        this.getCombination().add(Peg.SIX);
                        break;
                    default:
                        throw new UnknownPegException("The peg can only be \'1\', \'2\', \'3\', \'4\', \'5\' or \'6\'");
                }
            } else {
                throw new UnknownPegException("Pegs should be digits only");
            }
        }
    }

    public Guess(List<Peg> pegs) {
        this.combination = pegs;
    }

    public Answer computeAnswer() {
        List<Peg> copyCombination = new ArrayList<>(this.getCombination());
        List<Peg> copySecretCombination = new ArrayList<>(Board.secretCode);

        return new Answer(getNumberOfRPPegs(copyCombination, copySecretCombination),
                getNumberOfWPPegs(copyCombination, copySecretCombination));
    }

    public int getNumberOfWPPegs(List<Peg> combination, List<Peg> secretCombination) {
        int numberOfWPPegs = 0;
        for (Peg currentPeg : combination) {
            for (Peg secretPeg : secretCombination) {
                if (currentPeg.equals(secretPeg)) { //if i == j then its a RP
                    numberOfWPPegs++;
                    break;
                }
            }
        }
        return numberOfWPPegs;
    }

    public int getNumberOfRPPegs(List<Peg> combination, List<Peg> secretCombination) {
        int numberOfRPPegs = 0;

        for (int i = 0; i < secretCombination.size(); i++) {
            Peg currentPeg = combination.get(i);
            Peg secretPeg = secretCombination.get(i);
            if (currentPeg.equals(secretPeg)) {
                numberOfRPPegs++;
                combination.remove(i);
                secretCombination.remove(i);
                i--;
            }
        }
        return numberOfRPPegs;
    }


    @Override
    public String toString() {
        return "Guess{" +
                "combination=" + combination +
                '}';
    }
}
