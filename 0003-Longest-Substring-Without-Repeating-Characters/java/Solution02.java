import java.util.HashMap;
import java.util.Map;

public class Solution02 {

    /**
     * 求字串中的最长唯一字串
     * @param s 字串
     * @return 长度
     */
    public static int findMaxLen(String s) {
        int left = 0;
        int right = 0;
        int len = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            Integer index = map.get(s.charAt(right));
            map.put(s.charAt(right), right);
            if (index != null && index >= left) {
                left = index + 1;
            }
            if (right - left + 1 > len) {
                len = right - left + 1;
            }
            right ++ ;
        }

        return len;
    }

    public static void main(String[] args) {
        int  len = findMaxLen("dcsftaa");
        System.out.println(len);
    }
}
