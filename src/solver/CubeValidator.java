package solver;

public class CubeValidator {

    public boolean isValid(String state) {

        if(state.length() != 54) {

            return false;
        }

        int w = 0;
        int y = 0;
        int r = 0;
        int o = 0;
        int b = 0;
        int g = 0;

        for(char c : state.toCharArray()) {

            switch(c) {

                case 'W':
                    w++;
                    break;

                case 'Y':
                    y++;
                    break;

                case 'R':
                    r++;
                    break;

                case 'O':
                    o++;
                    break;

                case 'B':
                    b++;
                    break;

                case 'G':
                    g++;
                    break;

                default:
                    return false;
            }
        }

        return w == 9 &&
               y == 9 &&
               r == 9 &&
               o == 9 &&
               b == 9 &&
               g == 9;
    }
}