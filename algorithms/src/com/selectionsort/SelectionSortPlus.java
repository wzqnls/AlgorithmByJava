package com.selectionsort;

public class SelectionSortPlus {

    // 禁止算法类实例化
    private SelectionSortPlus(){}

    public static void sort(Comparable[] arr) {
        int n = arr.length;

        for(int i = 0; i < n; i++) {
            // 当前最小值索引
            int minIndex = i;

            for(int j = i + 1; j < n; j++) {
                if(arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr [i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] integers = {10, 8, 12, 17, 6, 5, 2, 1};
        SelectionSortPlus.sort(integers);

        for(int num: integers) {
            System.out.print(num + " ");
        }
        System.out.println();

        Double[] doubles = {4.4, 3.3, 2.2, 1.1};
        SelectionSortPlus.sort(doubles);

        for(double d: doubles) {
            System.out.print(d + " ");
        }
        System.out.println();

        String[] strings = {"D", "C", "B", "A"};
        SelectionSortPlus.sort(strings);

        for(String s: strings) {
            System.out.print(s + " ");
        }
    }
}
