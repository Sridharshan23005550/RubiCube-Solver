package solver;

public class ColorCounter {

    public void printCounts(String state) {

        int w=0,y=0,r=0,o=0,b=0,g=0,x=0;

        for(char c : state.toCharArray()) {

            switch(c) {

                case 'W': w++; break;
                case 'Y': y++; break;
                case 'R': r++; break;
                case 'O': o++; break;
                case 'B': b++; break;
                case 'G': g++; break;
                default: x++;
            }
        }

        System.out.println("W = " + w);
        System.out.println("Y = " + y);
        System.out.println("R = " + r);
        System.out.println("O = " + o);
        System.out.println("B = " + b);
        System.out.println("G = " + g);
        System.out.println("X = " + x);
    }
}   