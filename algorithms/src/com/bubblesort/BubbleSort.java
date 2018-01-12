package com.bubblesort;

public class BubbleSort {
    private BubbleSort(){}

    public static void sort(Comparable[] arr) {
        int n = arr.length;

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j+1].compareTo(arr[j]) < 0) {
                    swap(arr, j+1, j);
                }

                // 打印每次循环结果
//                for (Object obj: arr) {
//                    System.out.print(obj + " ");
//                }
//                System.out.println();
            }
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr [i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] integers = {10, 8, 12, 17, 6, 5, 2, 1};
        BubbleSort.sort(integers);

        for(int num: integers) {
            System.out.print(num + " ");
        }
    }
}
