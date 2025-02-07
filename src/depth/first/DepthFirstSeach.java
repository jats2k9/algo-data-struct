package depth.first;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSeach {

    /**
     * https://leetcode.com/problems/path-sum/
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        if (root == null) {
            return paths;
        }

        dfs(paths, path, root, targetSum);

        return paths;
    }

    private void dfs(List<List<Integer>> paths, List<Integer> path, TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        targetSum -= root.val;
        path.add(root.val);

        if (root.right == null && root.left == null && targetSum == 0) {
            paths.add(new ArrayList<>(path));
        }
        dfs(paths, path, root.right, targetSum);
        dfs(paths, path, root.left, targetSum);
        path.removeLast();
    }

    boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        boolean leftSum = hasPathSum(root.left, targetSum - root.val);
        boolean rightSum = hasPathSum(root.right, targetSum - root.val);
        return leftSum || rightSum;
    }
}

