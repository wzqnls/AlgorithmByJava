package com.heap;

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

    public void printData() {
        for (int i = 0; i < this.size(); i++) {
            System.out.println(data[i]);
        }
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

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
        // 堆中元素个数
        int N = 50;
        // 堆中元素取值范围
        int M = 100;
        for (int i = 0; i < N; i++) {
            maxHeap.insert(new Integer((int)(Math.random() * M)));
        }
        System.out.println(maxHeap.size());
        maxHeap.printData();
    }
}
