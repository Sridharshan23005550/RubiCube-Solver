package solver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cube.Cube;
import cube.Move;
    


public class Solver {
    
private java.util.List<String> scrambleHistory =
        new java.util.ArrayList<>();
    public List<String> solve() {

        List<String> moves = new ArrayList<>();

        moves.add("F");
        moves.add("R");
        moves.add("U");
        moves.add("R'");
        moves.add("U'");
        moves.add("F'");

        return moves;
    }

    public List<String> scramble() {

    scrambleHistory.clear();

    String[] possibleMoves = {
        "F","R","U"
    };

    java.util.Random random =
            new java.util.Random();

    for(int i = 0; i < 10; i++) {

        String move =
                possibleMoves[
                        random.nextInt(
                                possibleMoves.length
                        )
                ];

        scrambleHistory.add(move);
    }

    return scrambleHistory;
}   

public java.util.List<String> getSolution() {

    java.util.List<String> solution =
            new java.util.ArrayList<>();

    for(int i = scrambleHistory.size() - 1;
        i >= 0;
        i--) {

        solution.add(
                scrambleHistory.get(i)
        );
    }

    return solution;
}
    public void applyMove(Cube cube, String move) {

    switch(move) {

        case "F":
            Move.rotateFront(cube);
            break;

        case "B":
            Move.rotateBack(cube);
            break;

        case "L":
            Move.rotateLeft(cube);
            break;

        case "R":
            Move.rotateRight(cube);
            break;

        case "U":
            Move.rotateUp(cube);
            break;

        case "D":
            Move.rotateDown(cube);
            break;
    }
}
public void applySolution(
        Cube cube,
        List<String> solution) {

    for(String move : solution) {

        switch(move) {

            case "F":
                Move.rotateFrontInverse(cube);
                break;

            case "R":
                Move.rotateRightInverse(cube);
                break;

            case "U":
                Move.rotateUpInverse(cube);
                break;
        }
    }
}   
}