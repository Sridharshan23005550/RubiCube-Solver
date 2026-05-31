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

int startX = image.width() / 4;

int startY = image.height() / 4;

int gap = 50;

for(int row = 0; row < 3; row++) {

    for(int col = 0; col < 3; col++) {

        int x = startX + (col * gap);

        int y = startY + (row * gap);

        double[] pixel = image.get(y, x);

        char detected = detector.detectColor(

            (int)pixel[2],
            (int)pixel[1],
            (int)pixel[0]
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
}