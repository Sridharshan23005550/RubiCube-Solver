package image;

public class ColorDetector {

    public char detectColor(int r, int g, int b) {

        if(r > 200 && g > 200 && b > 200) {

            return 'W';
        }

        if(r > 200) {

            return 'R';
        }

        if(g > 200) {

            return 'G';
        }

        if(b > 200) {

            return 'B';
        }

        return 'Y';
    }
}