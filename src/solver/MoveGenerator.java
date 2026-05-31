package solver;

import java.util.ArrayList;
import java.util.List;

public class MoveGenerator {

    public List<String> getMoves() {

        List<String> moves = new ArrayList<>();

        moves.add("F");
        moves.add("B");
        moves.add("L");
        moves.add("R");
        moves.add("U");
        moves.add("D");

        return moves;
    }
}