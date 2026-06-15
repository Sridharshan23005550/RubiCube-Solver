package solver;

public class ColorValidator {

    public boolean validateColors(String state) {

        int w=0,y=0,r=0,o=0,b=0,g=0;

        for(char c : state.toCharArray()) {

            switch(c) {

                case 'W': w++; break;
                case 'Y': y++; break;
                case 'R': r++; break;
                case 'O': o++; break;
                case 'B': b++; break;
                case 'G': g++; break;
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