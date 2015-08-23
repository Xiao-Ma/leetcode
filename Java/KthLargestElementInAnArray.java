/**
 * @author Xiao
 * LeetCode: Kth Largest Element in an Array
 * Description: Find the kth largest element in an unsorted array. Note that it 
 *              is the kth largest element in the sorted order, not the kth 
 *              distinct element. You may assume k is always valid, 1 ≤ k ≤ 
 *              array's length.
 * Idea: selection sort.
 */
 
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        int global = 0;
        for (int i = 0; i < k; i++) {
            global = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[global]) {
                    global = j;
                }
            }
            int tmp = nums[global];
            nums[global] = nums[i];
            nums[i] = tmp;
        }
        return nums[k - 1];
    }
    /*Using heap.*/
    public int findKthLargestSol2(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<Integer>();
        for (int i = 0; i < nums.length; i++) {
            q.add(nums[i]);
        }
        for (int i = 0; i < nums.length - k; i++) {
            q.poll();
        }
        return q.poll();
    }
}