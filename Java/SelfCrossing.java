/**
 * @author Xiao
 * LeetCode: Self Crossing
 * Description: You are given an array x of n positive numbers. You start at 
 *              point (0,0) and moves x[0] metres to the north, then x[1] metres
 *              to the west, x[2] metres to the south, x[3] metres to the east 
 *              and so on. In other words, after each move your direction 
 *              changes counter-clockwise. Write a one-pass algorithm with O(1) 
 *              extra space to determine, if your path crosses itself, or not.
 */
 
public class SelfCrossing {
    public boolean isSelfCrossing(int[] x) {
        if (x.length <= 3) return false;
        boolean isShorter1 = x[2] <= x[0];
        boolean isShorter2 = x[3] >= x[1];
        
        return false;
    }
}