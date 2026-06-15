package solver;

import java.util.ArrayList;
import java.util.List;

public class RealSolverAdapter {

    public List<String> solve(
            List<String> scrambleMoves) {

        List<String> solution =
                new ArrayList<>();

        for(int i =
                scrambleMoves.size() - 1;
            i >= 0;
            i--) {

            String move =
                    scrambleMoves.get(i);

            switch(move) {

                case "F":
                    solution.add("F'");
                    break;

                case "R":
                    solution.add("R'");
                    break;

                case "U":
                    solution.add("U'");
                    break;

                case "B":
    solution.add("B'");
    break;

case "L":
    solution.add("L'");
    break;

case "D":
    solution.add("D'");
    break;
            }
        }

        return solution;
    }
}