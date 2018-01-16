package com.heap;

import com.utils.SortTest;

public class HeapSort1 {

    private HeapSort1(){}

    /**
     * 将所有元素依次添加到堆中
     * 然后将所有元素依次取出即完成排序
     * 时间复杂度均为O(nlogn)
     */
    public static void sort(Comparable[] arr) {

        int n = arr.length;

        MaxHeap<Comparable> maxHeap = new MaxHeap<Comparable>(n);
        for(int i = 0; i < n; i++) {
            maxHeap.insert(arr[i]);
        }

        for (int i = n -1; i >= 0; i--) {
            arr[i] = maxHeap.extratMax();
        }
    }

    public static void main(String[] args) {
        int N = 1000000;
        Integer[] arr = SortTest.generateRandomArray(N, 0, 1000000);
        SortTest.testSort("com.heap.HeapSort1", arr);
    }
}
