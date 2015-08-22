/**
 * @author Xiao
 * LeetCode: Summary Ranges
 * Description: Given a sorted integer array without duplicates, return the 
 *              summary of its ranges. For example, given [0,1,2,4,5,7], return 
 *              ["0->2","4->5","7"].
 */
 
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int prev = nums[0];
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                if (prev == cur) {
                    result.add(String.valueOf(prev));
                } else {
                    result.add(String.valueOf(prev) + "->" + String.valueOf(cur));
                }
                prev = nums[i];
                cur = nums[i];
            } else {
                cur = nums[i];
            }
        }
        if (prev == cur) {
            result.add(String.valueOf(prev));
        } else {
            result.add(String.valueOf(prev) + "->" + String.valueOf(cur));
        }
        return result;
    }
}