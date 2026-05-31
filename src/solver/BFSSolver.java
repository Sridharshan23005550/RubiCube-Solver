package solver;

import java.util.*;

public class BFSSolver {

    public String solve(String startState) {

        Queue<CubeState> queue = new LinkedList<>();

        HashSet<String> visited = new HashSet<>();

        queue.offer(
            new CubeState(startState, "")
        );

        visited.add(startState);

        while(!queue.isEmpty()) {

            CubeState current = queue.poll();

            if(current.state.equals(startState)) {

                return current.moves;
            }
        }

        return "No Solution";
    }
}