/**
 * @author Xiao
 * LeetCode: Max Points on a Line
 * Description: Given n points on a 2D plane, find the maximum number of points 
 *              that lie on the same straight line.
 * Idea: First idea: Use gradient and intercept to indicate a line exclusively,
 *       but I didn't consider when there are duplicate points. (Duplicates 
 *       should be count in here.)
 *       Second idea: for each point, count the number of its duplicates and the
 *       max points on the same line with the current point. Adding the number 
 *       of duplicates will be the max points on a line through the current 
 *       point. Find this mas among all points. (The will cause repeating 
 *       calculations for duplicate points...)
 */
 
/*
class Point {
    int x;
    int y;
    Point() {x = 0; y = 0;}
    Point(int a, int b) {x = a; y = b;}
}
*/
public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }
        int num = 1;
        Hashtable<Double, Integer> h = new Hashtable<Double, Integer>();
        for (int i = 0; i < points.length; i++) {
            h.clear();
            int cnt = 0;
            int dup = 1;
            for (int j = 0; j < points.length; j++) {
                if (j == i) {
                    continue;
                }
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    dup++;
                    continue;
                }
                double gradient = 0.0;
                if (points[i].x == points[j].x) {
                    gradient = Double.MAX_VALUE;
                } else {
                    gradient = (points[i].y - points[j].y) * 1.0 / (points[i].x - points[j].x);
                }
                if (h.containsKey(gradient)) {
                    h.put(gradient, h.get(gradient) + 1);
                } else {
                    h.put(gradient, 1);
                }
            }
            for (Double d : h.keySet()) {
                if (h.get(d) > cnt) {
                    cnt = h.get(d);
                }
            }
            if (cnt + dup > num) {
                num = cnt + dup;
            }
        }
        return num;
    }
}