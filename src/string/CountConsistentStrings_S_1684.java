package string;

import java.util.HashSet;

/**
 * @Description: 1684. 统计一致字符串的数目
 * 给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。
 * 如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字符串 。
 * 请你返回 words 数组中 一致字符串 的数目。
 * <p>
 * 示例 1：
 * 输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * 输出：2
 * 解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
 * <p>
 * 示例 2：
 * 输入：allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
 * 输出：7
 * 解释：所有字符串都是一致的。
 * <p>
 * 示例 3：
 * 输入：allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
 * 输出：4
 * 解释：字符串 "cc"，"acd"，"ac" 和 "d" 是一致字符串。
 * <p>
 * 提示：
 * 1 <= words.length <= 104
 * 1 <= allowed.length <= 26
 * 1 <= words[i].length <= 10
 * allowed 中的字符 互不相同 。
 * words[i] 和 allowed 只包含小写英文字母。
 * <p>
 * --------------------------------------
 * @ClassName: CountConsistentStrings_S_1684.java
 * @Date: 2021/8/17 16:00
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class CountConsistentStrings_S_1684 {
    public static void main(String[] args) {
        String allowed = "cad";
        String[] words = {"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"};
        System.out.println(countConsistentStrings2(allowed, words));
    }

    /**
     * 字符串判断字符是否存在
     */
    public static int countConsistentStrings(String allowed, String[] words) {
        // 状态位标记
        boolean isAdd = true;
        int result = 0;
        for (String word : words) {
            int length = word.length();
            char[] chars = word.toCharArray();
            for (int i = 0; i < length; i++) {
                // 不存在
                if (allowed.indexOf(chars[i]) == -1) {
                    isAdd = false;
                    break;
                }
            }
            if (isAdd) {
                result++;
            }
            isAdd = true;
        }
        return result;
    }


    public static int countConsistentStrings2(String allowed, String[] words) {
        char[] set = new char[128];
        int len = allowed.length();

        // 采用字符数组事前存储每个字符的个数
        for (int i = 0; i < len; i++) {
            set[allowed.charAt(i)]++;
        }

        int result = 0;
        for (String word : words) {
            boolean isAdd = true;
            int length = word.length();
            for (int i = 0; i < length; i++) {
                // 判断字符数组中是否存在重复的字符
                if (set[word.charAt(i)] == 0) {
                    isAdd = false;
                    break;
                }
            }
            if (isAdd) {
                result++;
            }
        }
        return result;
    }

}
