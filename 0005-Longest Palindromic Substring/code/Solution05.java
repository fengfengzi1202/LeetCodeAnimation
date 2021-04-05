public class Solution05 {

    /**
     * todo
     * @param str
     * @return
     */
    public static String longestHuiwenChuan(String str) {
        // 挨个字符遍历 // 记录回文串和长度
        int maxLength = -1;
        String result = "";

        for (int i = 0, len = str.length(); i < len; i++) {
            // 编写一个函数，获取对应index的最大回文串， 结果返回回文串
            String newResult = getXXX(str, i);
            int length = newResult.length();
            if (length > maxLength) {
                maxLength = length;
                result = newResult;
            }
        }

        return result;
    }

    /**
     * 从index向左向右遍历
     * @param str str是原始的字符串
     * @param index 字符串索引
     * @return 最大回文串
     */
    public static String getXXX(String str, int index) {
        // assa asa
        // 左边索引 left 右边索引right 最终结果res
        int left = index, right = index;
        int len = str.length();
        StringBuilder res = new StringBuilder();

        while (right < len) {
            if (str.charAt(right) == str.charAt(index)) {
                res.append(str.charAt(right));
                right++;
            } else {
                break;
            }
        }

        left --;
        // 向左向右遍历，直到字符串的左右边界
        while (left >= 0 && right < len) {
            if (str.charAt(left) == str.charAt(right)) {
                char temp = str.charAt(left);
                res.insert(0, temp);
                res.append(temp);
                left --;
                right ++;
            } else {
                break;
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        // asa assa  asd
        String str1 = "asa";
        String str2 = "assa";
        String str3 = "asd";

        System.out.println(longestHuiwenChuan(str1));
        System.out.println(longestHuiwenChuan(str2));
        System.out.println(longestHuiwenChuan(str3));
    }
}
