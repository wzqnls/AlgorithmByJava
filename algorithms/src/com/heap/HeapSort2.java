package com.heap;

import com.utils.SortTest;

public class HeapSort2 {

    private HeapSort2(){}

    /**
     * 使用heapify过程进行堆创建，时间复杂度为O(n)
     * 将元素依次取出，时间复杂度为O(nlogn)
     * 相对heapSort1性能更加，因为堆创建时间复杂度低
     * @param arr
     */
    public static void sort(Comparable[] arr) {
        int n = arr.length;

        MaxHeap<Comparable> maxHeap = new MaxHeap<Comparable>(arr);
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = maxHeap.extratMax();
        }

    }

    public static void main(String[] args) {
        int N = 1000000;
        Integer[] arr = SortTest.generateRandomArray(N, 0, 1000000);
        SortTest.testSort("com.heap.HeapSort2", arr);
    }
}
