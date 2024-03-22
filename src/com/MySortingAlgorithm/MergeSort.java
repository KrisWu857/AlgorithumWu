package com.MySortingAlgorithm;

public class MergeSort {
        public static void mergeSort(int[] arr) {
            // base case :
            int n = arr.length;
            if (n < 2) {
                return;
            }

            int mid = n / 2;
            int[] left = new int[mid];
            int[] right = new int[n - mid];

            // 将原始数组分成左右两部分
            System.arraycopy(arr, 0, left, 0, mid);
            System.arraycopy(arr, mid, right, 0, n - mid);

            // 递归地对左右两部分进行归并排序
            mergeSort(left);
            mergeSort(right);

            // 合并两部分
            merge(arr, left, right);
        }

        public static void merge(int[] arr, int[] left, int[] right) {
            int nL = left.length;
            int nR = right.length;
            int i = 0, j = 0, k = 0;

            while (i < nL && j < nR) {
                if (left[i] <= right[j]) {
                    arr[k++] = left[i++];
                } else {
                    arr[k++] = right[j++];
                }
            }

            while (i < nL) {
                arr[k++] = left[i++];
            }

            while (j < nR) {
                arr[k++] = right[j++];
            }
        }


        public static void main(String[] args) {
            int[] arr = {38, 27, 43, 3, 9, 82, 10};
            System.out.println("Original Array:");
            for (int num : arr) {
                System.out.print(num + " ");
            }

            mergeSort(arr);

            System.out.println("\nSorted Array:");
            for (int num : arr) {
                System.out.print(num + " ");
            }
        }
    }
