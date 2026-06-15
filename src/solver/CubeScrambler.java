package solver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CubeScrambler {

    public List<String> scramble() {

        String[] moves =
        {"F","R","U"};

        Random random =
                new Random();

        List<String> result =
                new ArrayList<>();

        for(int i=0;i<10;i++) {

            result.add(
                moves[
                    random.nextInt(
                        moves.length
                    )
                ]
            );
        }

        return result;
    }
}