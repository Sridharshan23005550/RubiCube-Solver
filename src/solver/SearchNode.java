package solver;

import java.util.List;

public class SearchNode {

    private String state;

    private List<String> path;

    private String move;

    public SearchNode(
            String state,
            List<String> path,
            String move) {

        this.state = state;
        this.path = path;
        this.move = move;
    }

    public String getState() {

        return state;
    }

    public List<String> getPath() {

        return path;
    }

    public String getMove() {

        return move;
    }
}