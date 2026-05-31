package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import image.ImageProcessor;
import cube.Cube;
import cube.Move;
import solver.Solver;

public class CubeUI {

    public void showUI() {

        JFrame frame = new JFrame("RubiCube Solver");

        frame.setSize(600, 400);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JLabel label = new JLabel("Upload Cube Images");

        JButton uploadButton = new JButton("Upload Image");

        JButton solveButton = new JButton("Solve Cube");
        JButton resetButton = new JButton("Reset");
        JButton scrambleButton = new JButton("Scramble");
        JButton debugButton = new JButton("Debug");
        JButton statusButton =
        new JButton("Status");
        JTextArea outputArea = new JTextArea(10, 40);
        final Cube[] cube = { new Cube() };

ImageProcessor processor = new ImageProcessor();
Solver solver = new Solver();

final int[] currentFace = {0};

        JScrollPane scrollPane = new JScrollPane(outputArea);

        panel.add(label);

        panel.add(uploadButton);

        panel.add(solveButton);
        panel.add(resetButton);
        panel.add(scrambleButton);
        panel.add(debugButton);
        panel.add(statusButton);

        panel.add(scrollPane);

        frame.add(panel);

        frame.setVisible(true);

        uploadButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser chooser = new JFileChooser();

                if(currentFace[0] >= 6) {

    outputArea.append(
        "All 6 faces already scanned\n"
    );

    return;
}

                int result = chooser.showOpenDialog(frame);

                if(result == JFileChooser.APPROVE_OPTION) {

    String path = chooser.getSelectedFile().getAbsolutePath();

    processor.processImage(
        path,
        cube[0],
        currentFace[0]
    );

    outputArea.append(
    "Face " +
    (currentFace[0] + 1) +
    " of 6 Scanned\n"
);

    outputArea.append(
        "Selected Image:\n"
    );

    outputArea.append(
        path + "\n\n"
    );

    currentFace[0]++;
}
            }
        });

        solveButton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {

        outputArea.append("\n====================\n");

        outputArea.append("CURRENT CUBE STATE\n");

        outputArea.append(cube[0].encodeState());

        outputArea.append("\n\n");

        Solver solver = new Solver();

        outputArea.append("SOLUTION STEPS\n");

        java.util.List<String> solution =
        solver.getSolution();

outputArea.append(
    "Solution Moves: "
);

for(String move : solution) {

    outputArea.append(
        move + " "
    );
}

outputArea.append("\n");

solver.applySolution(
        cube[0],
        solution
);

outputArea.append(
        "\nCube State After Solve:\n"
);

outputArea.append(
        cube[0].encodeState()
);
outputArea.append("\n");

outputArea.append(
    "Solved Status: "
);

outputArea.append(
    String.valueOf(
        cube[0].isSolved()
    )
);

outputArea.append("\n");

outputArea.append("\n");

        outputArea.append("====================\n");
    }
});

        resetButton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {

        outputArea.setText("");
        cube[0] = new Cube();
        currentFace[0] = 0;

        outputArea.append("Cube Reset Successfully\n");
    }
});

scrambleButton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {

        Solver solver = new Solver();

outputArea.append("\nScramble Moves:\n");

java.util.List<String> scrambleMoves =
        solver.scramble();

for(String move : scrambleMoves) {

    solver.applyMove(cube[0], move);

    outputArea.append(move + " ");
}

outputArea.append("\n");

outputArea.append("\nCube State After Scramble:\n");

outputArea.append(cube[0].encodeState());

outputArea.append("\n\n");
outputArea.append("\n");
    }
});

debugButton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {

        outputArea.append("\nBEFORE F MOVE:\n");

        outputArea.append(cube[0].encodeState());

        outputArea.append("\n");

        Move.rotateFront(cube[0]);

Move.rotateRight(cube[0]);

Move.rotateUp(cube[0]);

        outputArea.append("\nAFTER F MOVE:\n");

        outputArea.append(cube[0].encodeState());

        outputArea.append("\n");
    }
});

statusButton.addActionListener(
    new ActionListener() {

        @Override
        public void actionPerformed(
                ActionEvent e) {

            outputArea.append(
                "\nCube Status:\n"
            );

            outputArea.append(
                cube[0].encodeState()
            );

            outputArea.append(
                "\nSolved: "
            );

            outputArea.append(
                String.valueOf(
                    cube[0].isSolved()
                )
            );

            outputArea.append(
                "\n"
            );
        }
    }
);
    }
}