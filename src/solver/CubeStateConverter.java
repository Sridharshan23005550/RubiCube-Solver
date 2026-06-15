package solver;

import cube.Cube;

public class CubeStateConverter {

    public Cube fromString(
            String state) {

        Cube cube = new Cube();

        int index = 0;

        for(int face = 0;
            face < 6;
            face++) {

            for(int row = 0;
                row < 3;
                row++) {

                for(int col = 0;
                    col < 3;
                    col++) {

                    cube.cube[face][row][col] =
                            state.charAt(index);

                    index++;
                }
            }
        }

        return cube;
    }

    public String toString(
            Cube cube) {

        return cube.encodeState();
    }
}