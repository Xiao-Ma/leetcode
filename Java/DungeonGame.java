/**
 * @author Xiao
 * LeetCode: Dungeon Game
 * Description: The demons had captured the princess (P) and imprisoned her in 
 *              the bottom-right corner of a dungeon. The dungeon consists of 
 *              M x N rooms laid out in a 2D grid. Our valiant knight (K) was 
 *              initially positioned in the top-left room and must fight his way
 *              through the dungeon to rescue the princess.
 *              The knight has an initial health point represented by a positive
 *              integer. If at any point his health point drops to 0 or below, 
 *              he dies immediately.
 *              Some of the rooms are guarded by demons, so the knight loses 
 *              health (negative integers) upon entering these rooms; other 
 *              rooms are either empty (0's) or contain magic orbs that increase
 *              the knight's health (positive integers).
 *              In order to reach the princess as quickly as possible, the 
 *              knight decides to move only rightward or downward in each step.
 *              Write a function to determine the knight's minimum initial 
 *              health so that he is able to rescue the princess.
 * Idea: DP. First thinking about calculating from top-left to bottom-right, 
 *       however, it does not guarantee the best solution reaching the end.
 *       So I consider calculating backwardly, for each grid hp[i][j], it stands
 *       for the the least hp needed walking from dungeon[i][j] to Princess.
 */
 

public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0) {
            return 0;
        }
        int height = dungeon.length;
        int width = dungeon[0].length;
        int[][] hp = new int[height][width];
        for (int i = height - 1; i >= 0; i--) {
            for (int j = width - 1; j >= 0; j--) {
                if (i == height - 1) {
                    if (j == width - 1) {
                        hp[height-1][width-1] = dungeon[height-1][width-1]<0?1 - dungeon[height-1][width-1]:1;
                    } else {
                        hp[i][j] = Math.max(hp[i][j+1] - dungeon[i][j], 1);
                    }
                } else if (j == width - 1) {
                    hp[i][j] = Math.max(hp[i+1][j] - dungeon[i][j], 1);
                } else {
                    hp[i][j] = Math.max(Math.min(hp[i+1][j], hp[i][j+1]) - dungeon[i][j], 1);
                }
            }
        }
        return hp[0][0];
    }
}