/**
 * @author Xiao
 * LeetCode: Gas Station
 * Description: There are N gas stations along a circular route, where the 
 *              amount of gas at station i is gas[i]. You have a car with an 
 *              unlimited gas tank and it costs cost[i] of gas to travel from 
 *              station i to its next station (i+1). You begin the journey with
 *              an empty tank at one of the gas stations. Return the starting
 *              gas station's index if you can travel around the circuit once, 
 *              otherwise return -1. The solution is guaranteed to be unique.
 * Idea: if sum(cost - gas) < 0, there is no solution. For the start point i, it 
 *       must have cost[i] - gas[i] >= 0, and for the following point, it must
 *       keep the sum of cost[j] - gas[j] (j >= i) positive.
 */
 
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int tmp = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            sum += diff;
            if (tmp + diff >= 0) {
                tmp += diff;
            } else {
                tmp = 0;
                start = i + 1;
            }
        }
        if (sum < 0) {
            return -1;
        } else {
            return start;
        }
    }
}