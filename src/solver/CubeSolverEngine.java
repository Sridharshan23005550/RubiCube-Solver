package solver;

import java.util.ArrayList;
import java.util.List;

public class CubeSolverEngine {

    public List<String> solve(
        String cubeState) {

    List<String> solution =
            new ArrayList<>();

    String solvedState =
"WWWWWWWWWYYYYYYYYYRRRRRRRRROOOOOOOOOBBBBBBBBBGGGGGGGGG";

    if(cubeState.equals(
            solvedState)) {

        return solution;
    }

    solution.add("R");
    solution.add("U");
    solution.add("R'");
    solution.add("U'");

    return solution;
}
}