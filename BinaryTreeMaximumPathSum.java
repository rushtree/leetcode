package valid;

public class BinaryTreeMaximumPathSum {

    
    /* Definition for a binary tree node.*/

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    private class SumResult {
        // singlePath: 从root往下走到任意点的最大路径，这条路径可以不包含任何点
        // maxPath: 从树中任意到任意点的最大路径，这条路径至少包含一个点
        int singlePath;
        int maxPath;

        public SumResult(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }

    private SumResult getSum(TreeNode root) {
        if (root == null)
            return new SumResult(0, Integer.MIN_VALUE);

        SumResult leftSum = getSum(root.left);
        SumResult rightSum = getSum(root.right);

        int singleSumt = Math.max(leftSum.singlePath, rightSum.singlePath) + root.val;
        int singleSum = Math.max(singleSumt, 0);

        int maxSum = Math.max(Math.max(leftSum.maxPath, rightSum.maxPath), leftSum.singlePath + rightSum.singlePath + root.val);
        return new SumResult(singleSum, maxSum);
    }

    public int maxPathSum(TreeNode root) {

        return getSum(root).maxPath;

    }

}
