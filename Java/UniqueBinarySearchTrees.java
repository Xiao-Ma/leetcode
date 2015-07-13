/**
 * @author Xiao 
 * LeetCode: Unique Binary Search Trees
 * Description: Given n, how many structurally unique BST's (binary search 
 *              trees) that store values 1...n?
 * Idea: Note the post-order traversal should be 1...n. When node i is root,
 *       it's left child tree is 0..(i-1), it's right child tree is (i+1)..n.
 *       The number of unique trees when root is i is decided by the number of 
 *       unique left child trees and right child trees.
 */

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1; //when n = 0, the unque BST is an empty tree.
        }
        int[] num = new int[n + 1];
        num[0] = 1;
        num[1] = 1;
        for (int i = 2; i <= n; i++) { //total number of nodes
            for (int j = 1; j <= i; j++) { //root from 0 to i
                num[i] += num[j - 1] * num[i - j];
            }
        }
        return num[n];
    }
}