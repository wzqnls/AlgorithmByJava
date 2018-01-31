package com.minimumspantrees;

public class MinHeap<Item extends Comparable> {
    protected Item[] data;
    protected int count;
    protected int capacity;

    /**
     * 构造一个空堆
     * @param capacity
     */
    public  MinHeap(int capacity) {
        this.count = 0;
        data  = (Item[])new Comparable[capacity+1];
        this.capacity = capacity;
    }

    /**
     * 通过给定数组创建一个最小堆
     * 时间复杂度为O(n)
     * @param arr
     */
    public MinHeap(Item arr[]) {
        int n = arr.length;
        data = (Item[])new Comparable[n+1];
        capacity = n;
        count = n;

        for (int i = 0; i < n; i++) {
            data[i+1] = arr[i];
        }

        for (int i = count/2; i >= 1; i--) {
            shiftDown(i);
        }
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

    public Item extractMin() {
        assert count > 0;
        Item ret = data[1];
        swap(1, count);
        count--;
        shiftDown(1);
        return ret;
    }

    public Item getMin() {
        assert count > 0;
        return data[1];
    }

    private void swap(int i, int j) {
        Item temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    /**
     * shiftUp
     */
    private void shiftUp(int k) {
        while( k > 1 && data[k/2].compareTo(data[k]) > 0) {
            swap(k, k/2);
            k /= 2;
        }
    }

    private void shiftDown(int k) {
        while(2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && data[j+1].compareTo(data[j]) < 0) {
                j++;
            }

            if (data[k].compareTo(data[j]) <= 0) {
                break;
            }

            swap(k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        MinHeap<Integer> minHeap = new MinHeap<Integer>(100);
        int N = 100;
        int M = 100;
        for (int i = 0; i < N; i++) {
            minHeap.insert(new Integer((int)(Math.random() * M)));
        }
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = minHeap.extractMin();
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        //确保arr从小到大排序
        for (int i = 0; i < N-1; i++) {
            assert arr[i] <= arr[i+1];
        }
    }
}
