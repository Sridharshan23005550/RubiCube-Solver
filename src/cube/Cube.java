package cube;

public class Cube {

    public char[][][] cube;

    public Cube() {

        cube = new char[6][3][3];

        char[] colors = {'W', 'Y', 'R', 'O', 'B', 'G'};
        cube[0][0][0] = '1';
cube[0][0][1] = '2';
cube[0][0][2] = '3';

cube[0][1][0] = '4';
cube[0][1][1] = '5';
cube[0][1][2] = '6';

cube[0][2][0] = '7';
cube[0][2][1] = '8';
cube[0][2][2] = '9';

        for (int face = 0; face < 6; face++) {

            for (int i = 0; i < 3; i++) {

                for (int j = 0; j < 3; j++) {

                    cube[face][i][j] = colors[face];
                }
            }
        }
    }

    public void displayCube() {

        for (int face = 0; face < 6; face++) {

            System.out.println("Face " + face);

            for (int i = 0; i < 3; i++) {

                for (int j = 0; j < 3; j++) {

                    System.out.print(cube[face][i][j] + " ");
                }

                System.out.println();
            }

            System.out.println();
        }
    }
    public String encodeState() {

    StringBuilder sb = new StringBuilder();

    for(int face = 0; face < 6; face++) {

        for(int row = 0; row < 3; row++) {

            for(int col = 0; col < 3; col++) {

                sb.append(cube[face][row][col]);
            }
        }
    }

    return sb.toString();
}
public char[] getRow(int face, int row) {

    return cube[face][row].clone();
}
public void setRow(int face, int row, char[] values) {

    for(int i = 0; i < 3; i++) {

        cube[face][row][i] = values[i];
    }
}
public char[] getColumn(int face, int col) {

    char[] result = new char[3];

    for(int i = 0; i < 3; i++) {

        result[i] = cube[face][i][col];
    }

    return result;
}
public void setColumn(int face, int col, char[] values) {

    for(int i = 0; i < 3; i++) {

        cube[face][i][col] = values[i];
    }
}
public boolean isSolved() {

    // Check every face
    for(int face = 0; face < 6; face++) {

        // First color of face
        char color = cube[face][0][0];

        // Compare all cells
        for(int row = 0; row < 3; row++) {
            
            for(int col = 0; col < 3; col++) {

                if(cube[face][row][col] != color) {

                    return false;
                }
            }
        }
    }

    return true;
}

public void setFaceColor(

    int face,
    int row,
    int col,
    char color
) {

    cube[face][row][col] = color;
}   
public Cube copy() {

    Cube newCube = new Cube();

    for(int face = 0; face < 6; face++) {

        for(int row = 0; row < 3; row++) {

            for(int col = 0; col < 3; col++) {

                newCube.cube[face][row][col] =
                    this.cube[face][row][col];
            }
        }
    }

    return newCube;
}
public void printFrontFace() {

    System.out.println("\nFRONT FACE:");

    for(int i = 0; i < 3; i++) {

        for(int j = 0; j < 3; j++) {

            System.out.print(cube[0][i][j] + " ");
        }

        System.out.println();
    }
}
}
