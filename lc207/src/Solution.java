public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][numCourses];
        int[] flag = new int[numCourses];

        for (int[] condition : prerequisites) {
            graph[condition[1]][condition[0]] = 1;
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, flag, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int[] flag, int i) {
        if (flag[i] == 1) {
            return false;
        }
        if (flag[i] == -1) {
            return true;
        }
        flag[i] = 1;

        for (int j = 0; j < graph.length; j++) {
            if (graph[i][j] == 1 && !dfs(graph, flag, j)) {
                return false;
            }
        }
        flag[i] = -1;
        return true;
    }


}
