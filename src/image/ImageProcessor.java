package image;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import image.ColorDetector;
import cube.Cube;
public class ImageProcessor {

    static {

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public void processImage(String path ,
    Cube cube,
    int faceNumber) {

        Mat image = Imgcodecs.imread(path);

if(image.empty()) {

    System.out.println("Image Not Loaded");

    return;
}

System.out.println("Image Loaded Successfully");

ColorDetector detector = new ColorDetector();

int startX = image.width() / 6;

int startY = image.height() / 3;

int gapX = image.width() / 4;

int gapY = image.height() / 5;

for(int row = 0; row < 3; row++) {

    for(int col = 0; col < 3; col++) {

        int x = startX + (col * gapX);

        int y = startY + (row * gapY);

        int red = 0;
int green = 0;
int blue = 0;
int count = 0;

for(int dy = -10; dy <= 10; dy++) {

    for(int dx = -10; dx <= 10; dx++) {

        double[] pixel = image.get(
            y + dy,
            x + dx
        );

        if(pixel != null) {

            blue += (int)pixel[0];
            green += (int)pixel[1];
            red += (int)pixel[2];

            count++;
        }
    }
}

red /= count;
green /= count;
blue /= count;

char detected =
        detector.detectColor(
                red,
                green,
                blue
        );
        System.out.println(
    "x=" + x +
    " y=" + y
);
        System.out.println(
    "R=" + red +
    " G=" + green +
    " B=" + blue +
    " -> " + detected
);

        System.out.print(detected + " ");
        cube.setFaceColor(

    faceNumber,
    row,
    col,
    detected
);
    }

    System.out.println();
}}
public String getFaceString(
        Cube cube,
        int faceNumber) {

    StringBuilder sb =
            new StringBuilder();

    for(int row = 0;
        row < 3;
        row++) {

        for(int col = 0;
            col < 3;
            col++) {

            sb.append(
                cube.cube
                [faceNumber]
                [row]
                [col]
            );

            sb.append(" ");
        }

        sb.append("\n");
    }

    return sb.toString();
}
}