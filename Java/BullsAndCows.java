/**
 * @author Xiao
 * LeetCode: Bulls and Cows
 * Description: Given a target and a guess, provide a hint that indicates how 
 *              many digits in said guess match your secret number exactly in 
 *              both digit and position (called "bulls") and how many digits 
 *              match the secret number but locate in the wrong position 
 *              (called "cows").
 */
 
public class BullsAndCows {
   public String getHint(String secret, String guess) {
        int a = 0;
        int b = 0;
        HashMap<Character, Integer> h = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            char c = secret.charAt(i);
            if (c == guess.charAt(i)) {
                a++;
            } else if (h.containsKey(c)){
                h.put(c, h.get(c) + 1);
            } else {
                h.put(c, 1);
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            if (i >= secret.length()) {
                break;
            }
            char c = guess.charAt(i);
            if (c == secret.charAt(i)) {
                continue;
            } else if (h.containsKey(c)) {
                b++;
                if (h.get(c) == 1) {
                    h.remove(c);
                } else {
                    h.put(c, h.get(c) - 1);
                }
            }
        }
        return a + "A" + b + "B";
    }
    
    public String getHintSol2(String secret, String guess) {
        int a = 0; 
        int b = 0;
        HashMap<Character, Integer> h = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            char c_sec = secret.charAt(i);
            char c_gue = guess.charAt(i);
            if (c_sec == c_gue) {
                a++;
            } else {
                if (!h.containsKey(c_sec)) {
                    h.put(c_sec, 1);
                } else {
                    int n = h.get(c_sec) + 1;
                    if (n <= 0) {
                        b++;
                    }
                    h.put(c_sec, n);
                }
                if (!h.containsKey(c_gue)) {
                    h.put(c_gue, -1);
                } else {
                    int n = h.get(c_gue) - 1;
                    if (n >= 0) {
                        b++;
                    }
                    h.put(c_gue, n);
                }
            }
        }
        return a + "A" + b + "B";
    }
}