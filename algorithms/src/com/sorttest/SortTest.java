package com.sorttest;

import java.lang.reflect.Method;

public class SortTest {

    private SortTest(){}

    /**
     * 生成一个随机数组
     * @param n 数组大小
     * @param rangeL 最小值
     * @param rangeR 最大值
     * @return 数组
     */
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert rangeL <= rangeR;

        Integer[] arr = new Integer[n];

        for(int i = 0; i < n; i++) {
            arr[i] = new Integer((int)(Math.random() * (rangeR - rangeL + 1) + rangeL));
        }
        return arr;
    }


    /**
     * 生成一个近乎有序的数组
     * @param n 数组大小
     * @param swaptTimes 交换次数
     * @return
     */
    public static Integer[] generateNearOrderedArray(int n , int swaptTimes) {
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++) {
            arr[i] = new Integer(i);
        }

        for(int i = 0; i < swaptTimes; i++) {
            int a = (int)(Math.random() * n);
            int b = (int)(Math.random() * n);
            int t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        }
        return arr;
    }

    public static void printArray(Object[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i+1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static void testSort(String sortClassName, Comparable[] arr) {

        try {
            // 通过sortClassName获得排序函数的Class对象
            Class sortClass = Class.forName(sortClassName);

            // 通过排序函数的Class对象获得排序方法
            Method sortMethod = sortClass.getMethod("sort", new Class[]{Comparable[].class});

            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();

            sortMethod.invoke(null, params);

            long endTime = System.currentTimeMillis();

            assert isSorted(arr);
            System.out.println(sortClass.getSimpleName()+ " : " + (endTime-startTime) + "ms");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
