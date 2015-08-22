/**
 * @author Xiao
 * LeetCode: Rectangle Area
 * Description: Find the total area covered by two rectilinear rectangles in a 
 *              2D plane. Each rectangle is defined by its bottom left corner 
 *              and top right corner as shown in the figure.
 */
 
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int S = (C - A) * (D - B) + (H - F) * (G - E);
        if (F >= D || H <= B || E >= C || G <= A) {
            return S;
        } else {
            int left = A >= E ? A : E;
            int right = C <= G ? C : G;
            int buttom = B >= F ? B : F;
            int top = D <= H ? D : H;
            return S - (right - left) * (top - buttom);
        }
    }
}