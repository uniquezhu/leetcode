import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        int[] color = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (dfs(i, color, graph)) {
                result.add(i);
            }
        }
        return result;
    }

    // 0: 节点未被访问过
    // 1：节点被访问过1次
    // 2：安全节点
    private boolean dfs(int node, int[] color, int[][] graph) {
        if (color[node] > 0) {
            return color[node] == 2;
        }

        color[node] = 1;
        for (int nextNode : graph[node]) {
            if (color[node] == 2) {
                continue;
            }
            if (color[nextNode] == 1 || !dfs(nextNode, color, graph)) {
                return false;
            }
        }
        color[node] = 2;
        return true;
    }

    public static void main(String args[]) {

    }
}
