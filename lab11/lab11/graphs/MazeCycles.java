package lab11.graphs;
import java.util.Stack;
/**
 *  @author Josh Hug
 */
public class MazeCycles extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */

    private boolean cycleFound = false; //当DFS遇到marked的节点就表明有环
    private boolean isOverlap; //在DFS的return阶段，用于判断是否到达环的起点，即终止遍历
    private int overlapPoint; //首次找到marked的节点时，将其设为重叠点，再次遇到时即环的return完毕
    private Stack<Integer> stack = new Stack<>(); //用于储存环中的节点


    public MazeCycles(Maze m) {
        super(m);
        distTo[0] = edgeTo[0] = 0;
    }

    @Override
    public void solve() {
        cycleFinder(0);
        while (!stack.isEmpty()) {
            int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
            edgeTo[top] = stack.peek();
            announce();
        }
    }

    // Helper methods go here
    private void cycleFinder(int v) {
        marked[v] = true;
        announce();

        for (int w : maze.adj(v)) {
            if (marked[w] && edgeTo[v] != w) {
                cycleFound = true;
                isOverlap = false;
                stack.push(w);
                overlapPoint = w;
                return;
            }
            if (!marked[w]) {
                edgeTo[w] = v;
                distTo[w] = distTo[v] + 1;
                announce();
                cycleFinder(w);
            }
            if (cycleFound) {
                if (!isOverlap) { //当目前的节点不是重叠点，压栈
                    stack.push(w);
                }
                if (overlapPoint == w) { //当目前的节点时重叠点，将isOverlap设为真，之后的节点不再压入，完成递归
                    isOverlap = true;
                } //将压栈放在判定前是因为出栈时要将edgeTo设为栈顶的元素，所以重叠点需要在头尾都出现一次，完成闭环
                return;
            }
        }
    }
}
