package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import image.ImageProcessor;
import cube.Cube;
import cube.Move;
import solver.Solver;
import solver.CubeValidator;
import solver.ColorCounter; 
import solver.CubeInput;
import solver.ColorValidator;
import solver.CubeSolverEngine;
import solver.RealSolverAdapter;
import solver.BFSCubeSolver;

public class CubeUI {

    public void showUI() {

        JFrame frame = new JFrame("RubiCube Solver");

        frame.setSize(600, 400);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JLabel label = new JLabel("Upload Cube Images");

        JButton uploadButton = new JButton("Upload Image");

        JButton solveButton = new JButton("Solve Cube");
        JButton bfsButton =
        new JButton("Use BFS");

JButton realSolverButton =
        new JButton("Use Real Solver");
        JButton resetButton = new JButton("Reset");
        JButton scrambleButton = new JButton("Scramble");
        JButton debugButton = new JButton("Debug");
        JButton statusButton =
        new JButton("Status");
        JButton infoButton =
        new JButton("Project Info");
        JButton inputButton =
        new JButton("Manual Input");
        JTextArea outputArea = new JTextArea(10, 40);
        final Cube[] cube = { new Cube() };

ImageProcessor processor = new ImageProcessor();
Solver solver = new Solver();

CubeSolverEngine engine =
        new CubeSolverEngine();
BFSCubeSolver bfsSolver =
        new BFSCubeSolver();

RealSolverAdapter realSolver =
        new RealSolverAdapter();


CubeInput cubeInput =
        new CubeInput();

final int[] currentFace = {0};

        JScrollPane scrollPane = new JScrollPane(outputArea);

        panel.add(label);

        panel.add(uploadButton);

        panel.add(solveButton);
        panel.add(bfsButton);

panel.add(realSolverButton);
        panel.add(resetButton);
        panel.add(scrambleButton);
        panel.add(debugButton);
        panel.add(statusButton);
        panel.add(infoButton);
        panel.add(inputButton);

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

    outputArea.append(
    processor.getFaceString(
            cube[0],
            currentFace[0]
    )
);

outputArea.append("\n");

    currentFace[0]++;
}
            }
        });

        solveButton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {

        outputArea.append("\n====================\n");

        outputArea.append("CURRENT CUBE STATE\n");

        CubeValidator validator =
        new CubeValidator();

boolean valid =
        validator.isValid(
                cube[0].encodeState()
        );

outputArea.append(
        "Cube Valid: "
        + valid
        + "\n"
);

        outputArea.append(cube[0].encodeState());
        ColorCounter counter =
        new ColorCounter();

counter.printCounts(
        cube[0].encodeState()
);

        outputArea.append("\n\n");

        Solver solver = new Solver();
       /*  CubeNotationConverter converter =
        new CubeNotationConverter();

String notation =
        converter.convert(
                cubeInput.getState()
        );

RealSolverAdapter adapter =
        new RealSolverAdapter();

java.util.List<String> moves =
        adapter.solve(notation);
        outputArea.append(
        "\nGenerated Moves:\n"
);

for(String move : moves) {

    outputArea.append(
            move + " "
    );
}

outputArea.append("\n"); */

        java.util.List<String> steps =
        engine.solve(
            cube[0].encodeState()
        );

outputArea.append(
        "\nSolve Steps:\n"
);

if(steps.isEmpty()) {

    outputArea.append(
        "Cube Already Solved\n"
    );
}

for(String step : steps) {

    outputArea.append(
            step + " "
    );
}

outputArea.append("\n");

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
inputButton.addActionListener(
    new ActionListener() {

        @Override
        public void actionPerformed(
                ActionEvent e) {

            String state =
                    JOptionPane.showInputDialog(
                            frame,
                            "Enter 54-character cube state:"
                    );

            if(state != null &&
               state.length() == 54) {
                cubeInput.setState(state);
                ColorValidator validator =
        new ColorValidator();

boolean valid =
        validator.validateColors(state);

outputArea.append(
        "Color Valid: "
        + valid
        + "\n"
);

                outputArea.append(
                    "\nManual State Loaded:\n"
                );

                outputArea.append(
                    state + "\n"
                );
            }
            else {

                outputArea.append(
                    "\nInvalid Input\n"
                );
            }
        }
    }
);
bfsButton.addActionListener(
    new ActionListener() {

        @Override
        public void actionPerformed(
                ActionEvent e) {

            java.util.List<String> moves =
                    bfsSolver.solve(
                            cubeInput.getState()
                    );

            outputArea.append(
                    "\nBFS Result:\n"
            );

            outputArea.append(
                    moves.toString()
            );

            outputArea.append("\n");
        }
    }
);
realSolverButton.addActionListener(
    new ActionListener() {

        @Override
        public void actionPerformed(
                ActionEvent e) {

            java.util.List<String> moves =
        realSolver.solve(
                solver.getScrambleHistory()
        );
        for(String move : moves) {

    solver.applyInverseMove(
            cube[0],
            move
    );
}

            outputArea.append(
                    "\nReal Solver Result:\n"
            );

            outputArea.append(
                    moves.toString()
            );

            outputArea.append(
    "\nMoves Count: "
    + moves.size()
    + "\n"
);
            outputArea.append(
        "\nCube After Solve:\n"
);

outputArea.append(
        cube[0].encodeState()
);

outputArea.append(
        "\nSolved: "
        + cube[0].isSolved()
        + "\n"
);

            outputArea.append("\n");
        }
    }
);

infoButton.addActionListener(
    new ActionListener() {

        @Override
        public void actionPerformed(
                ActionEvent e) {

            outputArea.append(
                "\n=== PROJECT INFO ===\n"
            );

            outputArea.append(
                "Project: RubiCube Solver\n"
            );

            outputArea.append(
                "Language: Java\n"
            );

            outputArea.append(
                "OOP: Classes, Objects, Encapsulation, Abstraction\n"
            );

            outputArea.append(
                "DSA: BFS, Queue, HashSet, State Encoding\n"
            );

            outputArea.append(
                "GUI: Java Swing\n"
            );

            outputArea.append(
                "Image Processing: OpenCV\n"
            );
        }
    }
);
    }
}