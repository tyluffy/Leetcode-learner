package com.stackAndQueue.learn.stack.getNum;

import java.util.LinkedList;

public class GetNum {

    public static int getNum(int[] arr, int num) {
        if (arr == null || arr.length == 0 || num < 0) {
            return 0;
        }

        //队列头部压如最小值
        LinkedList<Integer> qmax = new LinkedList<>();
        //队列头部压如最大值
        LinkedList<Integer> qmin = new LinkedList<>();

        int i = 0;
        int j = 0;
        int res = 0;

        while (i < arr.length) {
            while (j < arr.length) {
                if (qmin.isEmpty() || qmin.peekLast() != j) {
                    while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
                        qmin.pollLast();
                    }
                    qmin.addLast(j);

                    while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {
                        qmax.pollLast();
                    }
                    qmax.addLast(j);
                }

                if (arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > num) {
                    break;
                }
                j++;
            }
            res = res + j - i - 1;
            if (qmax.peekFirst() == i) {
                qmax.pollFirst();
            }
            if (qmin.peekFirst() == i) {
                qmin.pollFirst();
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2, 3};
        System.out.println(getNum(arr, 2));
    }
}
