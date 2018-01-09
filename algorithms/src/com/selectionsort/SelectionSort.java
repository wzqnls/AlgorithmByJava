package com.selectionsort;

public class SelectionSort {

    /**禁止算法类实例 */
    private SelectionSort(){}

    public static void sort(int[] arr) {
        int n = arr.length;

        for(int i = 0; i < n; i++) {
            // 当前最小值索引
            int minIndex = i;

            for(int j = i + 1; j < n; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr [i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 8, 12, 17, 6, 5, 2, 1};
        SelectionSort.sort(arr);

        for(int num: arr) {
            System.out.print(num + " ");
        }
    }
}
