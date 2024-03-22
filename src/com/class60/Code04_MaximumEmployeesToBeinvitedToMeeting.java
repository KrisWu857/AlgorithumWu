package com.class60;

public class Code04_MaximumEmployeesToBeinvitedToMeeting {
    public static int maximumInvitations(int[] favourite) {
        // 图 : favourite[a] = b : a-> b
        int n  = favourite.length;
        int[] indegree = new int[n];
        for (int i = 0 ; i < n ; i++) {
            indegree[favourite[i]]++ ;
        }
        int[] queue = new int[n];
        int l = 0 ;
        int r = 0 ;
        for (int i = 0 ; i <  n ; i++) {
            if (indegree[i] == 0 ) {
                queue[r++] = i ;
            }
        }
        // deep[i] :  不包括i在内, i之前的最长链的长度
        int[] deep = new int[n] ;
        while (l < r ) {
            int cur = queue[l++];
            int next = favourite[cur];
            deep[next] = Math.max(deep[next] , deep[cur] + 1 );
            if (--indegree[next] == 0 ) {
                queue[r++] = next ;
            }
        }

        //目前,图中的点,不在环上的都删除了!
        // indegree[i] == 0

        // 可能性1:  所有小环(中心个数 == 2) , 算上中心点 + 延伸点 , 总个数
        int sumOfSmallRings = 0 ;
        // 可能性2 :所有大环(中心个数 >2 ) , 只算中心点 ,,最大环的中心点的个数
        int bigRings = 0 ;
        for (int i = 0 ; i < n ; i++) {
            // 只关心环!
            if (indegree[i] > 0 ) {
                int ringSize = 1 ;
                indegree[i] = 0 ;
                for (int j = favourite[i] ; j != i ; j= favourite[j]) {
                    ringSize++;
                    indegree[j] = 0 ;
                }
                if (ringSize == 2 ) {
                    sumOfSmallRings += 2 + deep[i] + deep[favourite[i]] ;
                }else{
                    bigRings = Math.max(bigRings, ringSize) ;
                }
            }
        }
        return Math.max(bigRings, sumOfSmallRings) ;
    }
}
