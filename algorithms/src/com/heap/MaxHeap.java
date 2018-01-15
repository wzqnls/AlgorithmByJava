package com.heap;

import com.utils.PrintableMaxHeap;

public class MaxHeap<Item extends Comparable> {

    protected Item[] data;
    protected int count;
    protected int capacity;

    public MaxHeap(int capacity) {
        data = (Item[])new Comparable[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(Item item) {
        assert count + 1 <= capacity;
        data[count + 1] = item;
        count++;
        shiftUp(count);
    }

    // 取出堆顶元素
    public Item extratMax() {
        assert count > 0;
        Item ret = data[1];

        swap(1, count);
        count--;
        shiftDown(1);

        return ret;
    }

    // 获取堆顶元素
    public Item getMax() {
        assert count > 0;
        return data[1];
    }


    public void printData() {
        for (int i = 0; i < this.size(); i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    private void swap(int i, int j) {
        Item t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    private void shiftUp(int k) {
        while (k > 1 && data[k / 2].compareTo(data[k]) < 0) {
            swap(k, k / 2);
            k /= 2;
        }
    }

    private void shiftDown(int k) {
        while(2 * k <= count) {
            // j代表左儿子的位置
            int j = 2 *k;

            // 如果右儿子存在且比左二子大，则k与右儿子比较交换
            if (j + 1 <= count && data[j + 1].compareTo(data[j]) > 0) {
                j++;
            }

            if (data[k].compareTo(data[j]) < 0) {
                swap(k, j);
                k = j;
            }
            else {
                break;
            }

        }
    }

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
        // 堆中元素个数
        int N = 20;
        // 堆中元素取值范围
        int M = 100;
        for (int i = 0; i < N; i++) {
            maxHeap.insert(new Integer((int)(Math.random() * M)));
        }

        // 打印堆大小
        System.out.println(maxHeap.size());

        Integer[] arr = new Integer[N];
        /**
         * 将maxheap中数据按从大到小取出来
         */
        for (int i = 0; i < N; i++) {
            arr[i] = maxHeap.extratMax();
            System.out.print(arr[i] + " ");
        }
    }
}
