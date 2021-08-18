package string;

import java.util.*;

/**
 * @Description: 720. 词典中最长的单词
 * 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，
 * 该单词是由words词典中其他单词逐步添加一个字母组成。
 * 若其中有多个可行的答案，则返回答案中字典序最小的单词。
 * 若无答案，则返回空字符串。
 * <p>
 * 示例 1：
 * 输入：
 * words = ["w","wo","wor","worl", "world"]
 * 输出："world"
 * 解释：
 * 单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
 * <p>
 * 示例 2：
 * 输入：
 * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * 输出："apple"
 * 解释：
 * "apply"和"apple"都能由词典中的单词组成。但是"apple"的字典序小于"apply"。
 * <p>
 * 提示：
 * 所有输入的字符串都只包含小写字母。
 * words数组长度范围为[1,1000]。
 * words[i]的长度范围为[1,30]。
 * --------------------------------------
 * @ClassName: LongestWord_S_720.java
 * @Date: 2021/8/17 19:26
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class LongestWord_S_720 {
    public static void main(String[] args) {
        String[] words = new String[]{"b", "br", "bre", "brea", "break", "breakf", "breakfa",
                "breakfas", "breakfast", "l",
                "lu", "lun", "lunc", "lunch", "d", "di", "din", "dinn", "dinne", "dinner"};
        System.out.println(longestWord(words));
    }


    public static String longestWord(String[] words) {
        Set<String> result = new TreeSet<>();
        Set<String> wordSet = new HashSet();
        for (String word : words) {
            wordSet.add(word);
        }
        // 先筛选，后排序
        for (String temp : words) {
            boolean flag = true;
            for (int j = 0; j < temp.length(); j++) {
                // 通过Set.contains()判断是否含有子元素
                if (!wordSet.contains(temp.substring(0, j + 1))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(temp);
            }
        }
        //
        if (result.isEmpty()) {
            return "";
        }

        // 筛选
        int maxLength = 0;
        for (String s : result) {
            if (s.length() > maxLength) {
                maxLength = s.length();
            }
        }

        Set<String> a = new TreeSet<>();
        for (String s : result) {
            if (s.length() == maxLength) {
                a.add(s);
            }
        }
        return ((TreeSet<String>) a).first();
    }

}

