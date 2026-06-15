package image;

public class ColorDetector {

   public char detectColor(int r, int g, int b) {

    // White
    if(r > 180 && g > 180 && b > 180)
        return 'W';

    // Yellow
    if(r > 180 && g > 180 && b < 120)
        return 'Y';

    // Orange
    if(r > 180 && g > 80 && g < 180 && b < 120)
        return 'O';

    // Red
    if(r > 120 && r > g + 20 && r > b + 20)
        return 'R';

    // Green
    if(g > 120 && g > r + 20 && g > b + 20)
        return 'G';

    // Blue
    if(b > 120 && b > r + 20 && b > g + 20)
        return 'B';

    return 'X';   // Unknown
}
}   