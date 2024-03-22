package com.class63;

import java.util.HashSet;
import java.util.List;

// 单词接龙
// 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列
// 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk ：
// 每一对相邻的单词只差一个字母。
// 对于 1 <= i <= k 时，每个 si 都在 wordList 中
// 注意， beginWord 不需要在 wordList 中。sk == endWord
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList
// 返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目
// 如果不存在这样的转换序列，返回 0 。
// 测试链接 : https://leetcode.cn/problems/word-ladder/

public class Code01_WordLadder {

    public static int ladderLength(String begin , String end , List<String> wordlist) {
        // 总词表
        HashSet<String > dict = new HashSet<>(wordlist);
        if (!dict.contains(end)){
            return 0 ;
        }
        // 数量小的一侧
        HashSet<String> smalllevel = new HashSet<>();
        //数量大的一侧
        HashSet<String> biglevel = new HashSet<>();
        //由数量小的一侧,拓展出来的下一层列表
        HashSet<String > nextLevel = new HashSet<>();
        smalllevel.add(begin);
        biglevel.add(end);
        for (int len = 2 ;  !smalllevel.isEmpty();len++){
            for (String w : smalllevel) {
                //从小的一侧开始扩展
                char[] word = w.toCharArray();      // 将字符串转换为字符数组
                for (int j = 0 ;j <word.length;j++) { //外层循环,遍历字符串中的每个字符
                    //每一位的字符都要比较
                    char old = word[j];
                    for (char change = 'a' ; change <= 'z' ; change++) { // 内层玄幻,对当前字符进行替换
                        // 每一位的字符都从a到z换一遍
                        if (change != old) {
                            word[j] = change;
                            String next = String.valueOf(word);
                            if (biglevel.contains(next)) {
                                return len;
                            }
                            if (dict.contains(next)){
                                dict.remove(next);
                                nextLevel.add(next);
                            }
                        }
                    }
                    word[j] = old ;
            }
        }
            //如果当前小的一侧的下一层依然比big小,就维持small,否则的话,就交换
            if (nextLevel.size() <= biglevel.size()){
                HashSet<String> temp = smalllevel;
                smalllevel = nextLevel;
                nextLevel = temp;
            }else{
                HashSet<String> temp = smalllevel;
                smalllevel = nextLevel;
                nextLevel = temp ;
            }
            nextLevel.clear();
        }
            return 0;
    }
}
