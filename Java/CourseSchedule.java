/**
 * @author XIAO
 * LeetCode: Course Schedule
 * Description: https://leetcode.com/problems/course-schedule/
 * Idea: topological sort problem
 *       BFS: use array to store indegree for each course, start from
 *       courses with 0 indegree, every time a course is visit, the 
 *       indegree for its follow-up course minus 1, and add the follow-up
 *       course to queue if its indegree becomes 0.
 */

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
	    return true;
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
    public boolean BFS(ListNode[] c) {
        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < c.length; i++) {
            if (c[i].val == 0) {
                queue.add(i);
            }
        }
        while (queue.size() != 0) {
            int cur = queue.poll();
            if (!set.contains(cur)) {
                set.add(cur);
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
            return true;
        } else {
            return false;
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