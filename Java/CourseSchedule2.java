/**
 * @author XIAO
 * LeetCode: Course Schedule II
 * Description: https://leetcode.com/problems/course-schedule-ii/
 * Idea: topological sort problem
 *       BFS: similar to Course Schedule, use extra array to store ordered id.
 */

public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] empty = new int[0];
        if (numCourses == 0) {
	    return empty;
        }
        ListNode[] course = new ListNode[numCourses];
        for (int i = 0; i < numCourses; i++) {
            course[i] = new ListNode(0);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            course[prerequisites[i][0]].val += 1;
            ListNode tmp = new ListNode(prerequisites[i][0]);
            tmp.next = course[prerequisites[i][1]].next;
            course[prerequisites[i][1]].next = tmp;
        }
        return BFS(course);
    }
    public int[] BFS(ListNode[] c) {
        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        int[] order = new int[c.length];
        int cnt = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i].val == 0) {
                queue.add(i);
            }
        }
        while (queue.size() != 0) {
            int cur = queue.poll();
            if (!set.contains(cur)) {
                set.add(cur);
                order[cnt] = cur;
                cnt += 1;
            } else {
                break;
            }
            ListNode p = c[cur].next;
            while (p != null) {
                c[p.val].val--;
                if (c[p.val].val == 0) {
                    queue.add(p.val);
                }
                p = p.next;
            }
        }
        if (set.size() == c.length) {
            return order;
        } else {
            return new int[0];
        }
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        this.val = x;
    }
}