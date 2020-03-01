public class Solution {
    private int count = 0;
    public int distributeCoins(TreeNode root) {
        count = 0;
        dfs(root);
        return count;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        count += Math.abs(left) + Math.abs(right);
        return node.val + left + right - 1;
    }
}
