package com.mergesort;

import java.util.Arrays;

/**
 * 自底向上归并排序算法
 */
public class MergeSortBU {

    private MergeSortBU(){}

    private static void merge(Comparable[] arr, int l, int mid, int r) {

        Comparable[] aux = Arrays.copyOfRange(arr, l, r+1);

        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid+1;
        for( int k = l ; k <= r; k ++ ){

            if( i > mid ){  // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j-l]; j ++;
            }
            else if( j > r ){   // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i-l]; i ++;
            }
            else if( aux[i-l].compareTo(aux[j-l]) < 0 ){  // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i-l]; i ++;
            }
            else{  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j-l]; j ++;
            }
        }
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;

        for(int sz = 1; sz < n; sz += sz) {
            for(int i = 0; i + sz < n; i += sz * 2 -1) {
                merge(arr, i, i + sz -1,  Math.min(i + sz * 2 - 1, n-1));
            }
        }
    }

    public static void main(String[] args) {
        Integer[] integers = {3, 5, 6, 9, 4, 2, 8, 10};

        MergeSortBU.sort(integers);
        for ( int a: integers) {
            System.out.print(a + " ");
        }
    }
}
