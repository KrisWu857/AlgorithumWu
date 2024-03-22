package com.itkris.JavaHomeWork;

import java.util.Random;

public class Test3 {
    public Test3() {
    }

    public static void main(String[] args) {
            int[] arr = new int[8];
            // 生成随机整数并存储在数组中
            Random random = new Random();
            for (int i = 0; i < 8; i++) {
                arr[i] = random.nextInt(101); // 生成0到100的随机整数
            }
            System.out.println("随机生成的整数数组:");
            printArray(arr);

            // 冒泡排序
            bubbleSort(arr);


            System.out.println("升序排序后的数组:");
            printArray(arr);
        }

        public static void bubbleSort(int[] arr) {
            int n = arr.length;
            boolean swapped;

            for (int i = 0; i < n - 1; i++) {
                swapped = false;

                for (int j = 0; j < n - 1 - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        // 交换arr[j]和arr[j+1]
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        swapped = true;
                    }
                }

                // 如果在一轮遍历中没有发生交换，数组已经有序，无需继续
                if (!swapped) {
                    break;
                }
            }
        }

        public static void printArray(int[] arr) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }


    }

