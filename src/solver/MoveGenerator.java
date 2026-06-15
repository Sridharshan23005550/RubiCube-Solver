package solver;

import cube.Cube;
import cube.Move;

import java.util.ArrayList;
import java.util.List;

public class MoveGenerator {

    public List<String> generateMoves(
            String state) {

        List<String> neighbours =
                new ArrayList<>();

        CubeStateConverter converter =
                new CubeStateConverter();

        Cube cube;

        cube = converter.fromString(state);

        Move.rotateFront(cube);

        neighbours.add(
                converter.toString(cube)
        );

        cube = converter.fromString(state);

        Move.rotateRight(cube);

        neighbours.add(
                converter.toString(cube)
        );

        cube = converter.fromString(state);

        Move.rotateUp(cube);

        neighbours.add(
                converter.toString(cube)
        );

        return neighbours;
    }
}