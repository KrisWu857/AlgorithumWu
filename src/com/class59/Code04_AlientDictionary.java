package com.class59;

import java.util.ArrayList;
import java.util.Arrays;

public class Code04_AlientDictionary {

    public static String alienOrder(String[] words) {
        // 入度表,26种字符
        int[] indegree= new int[26];
        Arrays.fill(indegree, - 1 );
        // 把所有字符串里的每一个字符的入度改为0 , 是-1 的就是没有出现的,是0的就是出现过的
        for (String w : words){
            for (int i = 0 ; i < w.length() ; i++) {
                indegree[w.charAt(i) - 'a'] = 0 ;
            }
        }
        //  'a' -> 0
        //  'b' -> 1
        // 'z' - > 25
        // x -> x - 'a'
        ArrayList<ArrayList<Integer>> graph  = new ArrayList<>();
        for (int i = 0 ; i< 26 ; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0, j , len ; i < words.length - 1 ; i++) {
            String  cur = words[i];
            String  next = words[i + 1 ];
            j = 0 ;
            len = Math.min(cur.length() , next.length() ) ;
            for ( ; j < len ; j++) {
                if (cur.charAt(j) != next.charAt(j)) {
                    graph.get(cur.charAt(j) - 'a').add(next.charAt(j) - 'a');
                    indegree[next.charAt(j) - 'a']++ ;
                    break;
                }
            }
            if ( j <cur.length() && j == next.length()) {
                return "" ;
            }
        }

        int[] queue = new int[26];
        int l = 0 ,r = 0 ;
        int kinds = 0 ;
        for (int i = 0 ; i< 26;i++) {
            if (indegree[i] != -1 ) {
                kinds++;
            }
            if (indegree[i] == 0 ) {
                queue[r++] = i ;
            }
        }
        StringBuilder ans = new StringBuilder();
        while (l < r ) {
            int cur = queue[l++];
            ans.append((char) (cur + 'a'));
            for (int next : graph.get(cur)) {
                if (--indegree[next] == 0 ) {
                    queue[r++] = next;
                }
            }
        }
        return ans.length()  == kinds ? ans.toString() : "" ;

    }


}
