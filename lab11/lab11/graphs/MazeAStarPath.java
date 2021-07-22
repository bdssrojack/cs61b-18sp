package lab11.graphs;
import java.util.PriorityQueue;
/**
 *  @author Josh Hug
 */
public class MazeAStarPath extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private class Node implements Comparable<Node> {
        public int index;//当前节点的序号
        public int dist;//到原点的距离
        public int priority;//优先级是距离加h
        public Node parent;//父节点
        public Node (int index, int dist, Node parent) {
            this.index = index;
            this.dist = dist;
            this.priority = dist + h(index);
            this.parent = parent;
        }
        @Override
        public int compareTo(Node n) {
            return this.priority - n.priority;
        }
    }

    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze;
    private boolean[] vertexDone = new boolean[marked.length]; //储存已出队的节点，astar()对其不再访问

    public MazeAStarPath(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s;
    }

    /** Estimate of the distance from v to the target. */
    private int h(int v) {
        return Math.abs(maze.toX(v) - maze.toX(t)) + Math.abs(maze.toY(v) - maze.toY(t));
    }

    /** Finds vertex estimated to be closest to target. */
    private int findMinimumUnmarked() {
        return -1;
        /* You do not have to use this method. */
    }

    /** Performs an A star search from vertex s. */
    private void astar(int s) {
        marked[s] = true;
        announce();

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0, null));

        while (!pq.isEmpty() && targetFound == false) {

        }
    }

    @Override
    public void solve() {
        astar(s);
    }

}

