import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }

        if (x == z || y == z || x + y == z) {
            return true;
        }

        Queue<List<Integer>> queue = new LinkedList<>();
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> list = Arrays.asList(0, 0);
        queue.offer(list);
        set.add(list);

        while (!queue.isEmpty()) {
            List<Integer> temp = queue.poll();
            int cur_x = temp.get(0);
            int cur_y = temp.get(1);

            System.out.println(String.format("X = %d, Y = %d, Z=%d", cur_x, cur_y, z));
            if (cur_x == z || cur_y == z || cur_x + cur_y == z) {
                return true;
            }

            // 给X加满水
            List<Integer> fillX = Arrays.asList(x, cur_y);
            if (!set.contains(fillX)) {
                set.add(fillX);
                queue.offer(fillX);
            }

            // 给Y加满水
            List<Integer> fillY = Arrays.asList(cur_x, y);
            if (!set.contains(fillY)) {
                set.add(fillY);
                queue.offer(fillY);
            }

            // 清空X的水
            List<Integer> clearX = Arrays.asList(0, cur_y);
            if (!set.contains(clearX)) {
                set.add(clearX);
                queue.offer(clearX);
            }

            // 清空Y的水
            List<Integer> clearY = Arrays.asList(cur_x, 0);
            if (!set.contains(clearY)) {
                set.add(clearX);
                queue.offer(clearX);
            }

            // X给Y倒水
            List<Integer> putX2Y = (cur_x + cur_y > y)
                    ? Arrays.asList(cur_x + cur_y - y, y) : Arrays.asList(0, cur_x + cur_y);
            if (!set.contains(putX2Y)) {
                set.add(putX2Y);
                queue.offer(putX2Y);
            }

            // Y给X倒水
            List<Integer> putY2X = (cur_x + cur_y > x)
                    ? Arrays.asList(x, cur_x + cur_y - x) : Arrays.asList(cur_x + cur_y, 0);
            if (!set.contains(putY2X)) {
                set.add(putY2X);
                queue.offer(putY2X);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canMeasureWater(3, 5, 4));
        System.out.println(solution.canMeasureWater(2, 6, 5));
    }
}
