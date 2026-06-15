package solver;

import java.util.*;

public class BFSCubeSolver {

    public List<String> solve(String state) {

        Queue<SearchNode> queue =
                new LinkedList<>();

        HashSet<String> visited =
                new HashSet<>();

        queue.offer(
    new SearchNode(
        state,
        new ArrayList<>(),
        "START"
    )
);

        visited.add(state);
        

int limit = 0;
        while(!queue.isEmpty()) {
            limit++;

if(limit > 1000) {

    break;
}
            SearchNode current =
                    queue.poll();
                    System.out.println(
        "Visited: "
        + visited.size()
);

            if(isGoal(
                    current.getState()
            )) {

                return current.getPath();
            }
            MoveGenerator generator =
        new MoveGenerator();

List<String> neighbours =
        generator.generateMoves(
                current.getState()
        );

for(String nextState : neighbours) {

    if(!visited.contains(
            nextState
    )) {

        visited.add(nextState);

        List<String> newPath =
                new ArrayList<>(
                        current.getPath()
                );

        newPath.add(
                nextState
        );

       queue.offer(
    new SearchNode(
        nextState,
        newPath,
        "MOVE"
    )
);
    }
}
        }

        return new ArrayList<>();
    }

    private boolean isGoal(
            String state) {

        return state.equals(
"WWWWWWWWWRRRRRRRRRGGGGGGGGGYYYYYYYYYOOOOOOOOOBBBBBBBBB"
);
    }
}