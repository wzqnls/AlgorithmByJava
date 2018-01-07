package com.mergesort;

import java.util.Arrays;

public class MergeSort {

    private MergeSort(){}

    private static void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] temp = Arrays.copyOfRange(arr, l, r+1);

        int i = l, j = mid + 1;
        for(int k = l; k <= r; k++) {

            /**
             * 先判断两部分边界
             * 再对未完成的部分进行处理
             */
            if(i > mid) {
                arr[k] = temp[j-l];
                j++;
            }else if (j > r) {
                arr[k] = temp[i-l];
                i++;
            }else if(temp[i-l].compareTo(temp[j-l]) < 0) {
                arr[k] = temp[i-l];
                i++;
            }else {
                arr[k] = temp[j-l];
                j++;
            }
        }
    }

    private static void sort(Comparable[] arr, int l, int r) {

        if(l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid+1, r);
        merge(arr, l, mid, r);
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        Integer[] integers = {3, 5, 6, 9, 4, 2, 8, 10};

        MergeSort.sort(integers);
        for ( int a: integers) {
            System.out.print(a + " ");
        }
    }
}
