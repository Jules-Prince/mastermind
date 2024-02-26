package mastermind.Combinaisons;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Answer {

    private Integer RP_Pegs;
    private Integer WP_Pegs; //Good peg but at the wrong position

    public Answer() {
    }

    Answer(Integer RP_Pegs, Integer WP_Pegs) {
        this.RP_Pegs = RP_Pegs;
        this.WP_Pegs = WP_Pegs;
    }

    @Override
    public String toString() {
        return "Answer (" +
                "RP_Pegs=" + RP_Pegs +
                ", WP_Pegs=" + WP_Pegs +
                ')';
    }
}
