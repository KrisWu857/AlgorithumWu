package com.DataStructureTest;

public class TestOne {
    public class KMP {
        public static void getNextAndNextVal(String pattern, int[] next, int[] nextval) {
            int m = pattern.length();
            next[0] = -1;
            int i = 0;
            int j = -1;

            while (i < m) {
                if (j == -1 || pattern.charAt(i) == pattern.charAt(j)) {
                    i++;
                    j++;
                    next[i] = j;
                    if (i < m) {
                        if (pattern.charAt(i) == pattern.charAt(j)) {
                            nextval[i] = nextval[j];
                        } else {
                            nextval[i] = j;
                        }
                    }
                } else {
                    j = next[j];
                }
            }
        }

        public static void main(String[] args) {
            String pattern = "abcaabbabcab";
            int m = pattern.length();
            int[] next = new int[m];
            int[] nextval = new int[m];

            getNextAndNextVal(pattern, next, nextval);

            System.out.println("Next数组：");
            for (int i = 0; i < m; i++) {
                System.out.print(next[i] + " ");
            }
            System.out.println();

            System.out.println("NextVal数组：");
            for (int i = 0; i < m; i++) {
                System.out.print(nextval[i] + " ");
            }
        }
    }

}
