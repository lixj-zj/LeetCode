package string;

import java.util.Arrays;

/**
 * @Description: 821. 字符的最短距离
 * 给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
 * 返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。
 * 两个下标 i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。
 * <p>
 * 示例 1：
 * 输入：s = "loveleetcode", c = "e"
 * 输出：[3,2,1,0,1,0,0,1,2,2,1,0]
 * 解释：字符 'e' 出现在下标 3、5、6 和 11 处（下标从 0 开始计数）。
 * 距下标 0 最近的 'e' 出现在下标 3 ，所以距离为 abs(0 - 3) = 3 。
 * 距下标 1 最近的 'e' 出现在下标 3 ，所以距离为 abs(1 - 3) = 2 。
 * 对于下标 4 ，出现在下标 3 和下标 5 处的 'e' 都离它最近，但距离是一样的 abs(4 - 3) == abs(4 - 5) = 1 。
 * 距下标 8 最近的 'e' 出现在下标 6 ，所以距离为 abs(8 - 6) = 2 。
 * <p>
 * 示例 2：
 * 输入：s = "aaab", c = "b"
 * 输出：[3,2,1,0]
 * <p>
 * 提示：
 * 1 <= s.length <= 104
 * s[i] 和 c 均为小写英文字母
 * 题目数据保证 c 在 s 中至少出现一次
 *
 * 思路：
 * 以当前位置为基准，左右双指针遍历。
 * --------------------------------------
 * @ClassName: ShortestToChar_S_821.java
 * @Date: 2021/8/16 19:17
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class ShortestToChar_S_821 {
    public static void main(String[] args) {
        String s = "aaab";
        char c = 'b';
        System.out.println(Arrays.toString(shortestToChar(s, c)));
    }

    /**
     * 从当前下标出发，分别向左、右两个方向去寻找目标字符 C。
     * 只在一个方向找到的话，直接计算字符距离。
     * 两个方向都找到的话，取两个距离的最小值。
     */
    public static int[] shortestToChar(String s, char c) {
        int[] result = new int[s.length()];
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == c) {
                continue;
            }

            // 定义两个指针 left, right 分别向左、右两个方向寻找目标字符 C，取最短距离
            int left = i;
            int right = i;
            int dist = 0;

            // 往左、往右遍历
            while (left >= 0 || right <= s.length() - 1) {
                if (chars[left] == c) {
                    dist = i - left;
                    break;
                }
                if (chars[right] == c) {
                    dist = right - i;
                    break;
                }
                if (left > 0) {
                    left--;
                }
                if (right < s.length() - 1) {
                    right++;
                }
            }
            result[i] = dist;
        }
        return result;
    }

}
