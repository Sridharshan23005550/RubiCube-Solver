package cube;

public class Move {

    // Rotate one face clockwise
    public static void rotateFaceClockwise(char[][] face) {

        // Temporary array
        char[][] temp = new char[3][3];

        // Rotate values
        for(int i = 0; i < 3; i++) {

            for(int j = 0; j < 3; j++) {

                temp[j][2 - i] = face[i][j];
            }
        }

        // Copy rotated values back
        for(int i = 0; i < 3; i++) {

            for(int j = 0; j < 3; j++) {

                face[i][j] = temp[i][j];
            }
        }
    }

    public static void rotateFront(Cube cube) {

    rotateFaceClockwise(cube.cube[0]);

    char[] top = cube.getRow(2, 2);

    char[] left = cube.getColumn(4, 2);

    char[] bottom = cube.getRow(3, 0);

    char[] right = cube.getColumn(5, 0);

    cube.setColumn(5, 0, top);

    cube.setRow(3, 0, right);

    cube.setColumn(4, 2, bottom);

    cube.setRow(2, 2, left);
}

    public static void rotateBack(Cube cube) {

    rotateFaceClockwise(cube.cube[1]);

    //System.out.println("Back Face Rotated");
}

public static void rotateLeft(Cube cube) {

    rotateFaceClockwise(cube.cube[4]);

   // System.out.println("Left Face Rotated");
}

public static void rotateRight(Cube cube) {

    rotateFaceClockwise(cube.cube[5]);

    char[] top = cube.getColumn(2, 2);

    char[] front = cube.getColumn(0, 2);

    char[] bottom = cube.getColumn(3, 2);

    char[] back = cube.getColumn(1, 0);

    cube.setColumn(0, 2, top);

    cube.setColumn(3, 2, front);

    cube.setColumn(1, 0, bottom);

    cube.setColumn(2, 2, back);
}

public static void rotateUp(Cube cube) {

    rotateFaceClockwise(cube.cube[2]);

    char[] front = cube.getRow(0, 0);

    char[] right = cube.getRow(5, 0);

    char[] back = cube.getRow(1, 0);

    char[] left = cube.getRow(4, 0);

    cube.setRow(5, 0, front);

    cube.setRow(1, 0, right);

    cube.setRow(4, 0, back);

    cube.setRow(0, 0, left);
}

public static void rotateDown(Cube cube) {

    rotateFaceClockwise(cube.cube[3]);

    //System.out.println("Down Face Rotated");
}
}