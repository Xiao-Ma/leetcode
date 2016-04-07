/**
 * @author Xiao
 * LeetCode: House Robber III
 * Description: The thief has found himself a new place for his thievery again. 
 *              There is only one entrance to this area, called the "root." 
 *              Besides the root, each house has one and only one parent house. 
 *              After a tour, the smart thief realized that "all houses in this 
 *              place forms a binary tree". It will automatically contact the 
 *              police if two directly-linked houses were broken into on the 
 *              same night.
 *              Determine the maximum amount of money the thief can rob tonight 
 *              without alerting the police.
 */
 
public class HouseRobber3 {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int withRoot = root.val;
        int woRoot = 0;
        if (root.left != null) {
            withRoot += rob(root.left.left);
            withRoot += rob(root.left.right);
            woRoot += rob(root.left);
        }
        if (root.right != null) {
            withRoot += rob(root.right.left);
            withRoot += rob(root.right.right);
            woRoot += rob(root.right);
        }
        return Math.max(withRoot, woRoot);
    }
}
