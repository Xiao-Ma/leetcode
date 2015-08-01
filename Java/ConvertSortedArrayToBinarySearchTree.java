/**
 * @author Xiao
 * LeetCode: Convert Sorted Array to Binary Search Tree
 * Description: Given an array where elements are sorted in ascending order, 
 *              convert it to a height balanced BST.
 * Idea: similar to Convert Sorted Linked List to Binary Search Tree.
 */
 
/*
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
*/
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }
    private TreeNode helper(int[] nums, int start, int end) {
        if (start == end) {
            return new TreeNode(nums[start]);
        } else if (start > end) {
            return null;
        }
        int mid = start + (end - start)/2;
        TreeNode n = new TreeNode(nums[mid]);
        n.left = helper(nums, start, mid - 1);
        n.right = helper(nums, mid + 1, end);
        return n;
    }
}