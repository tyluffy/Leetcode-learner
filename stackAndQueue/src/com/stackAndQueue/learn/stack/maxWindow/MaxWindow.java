package com.stackAndQueue.learn.stack.maxWindow;

import java.util.Arrays;
import java.util.LinkedList;

public class MaxWindow {

    public static int[] getMaxWindow(int[] arr, int w) {
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        LinkedList<Integer> qmax = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            //当队列的尾部值小于数组的值时，将队尾的值弹出
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            //如果此时窗口超了 则弹出队头
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            //i大于窗口时，每移动一步都会有一个窗口最大值
            if (i >= w - 1) {
                res[index ++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 5, 4, 3, 3, 6, 7};
        int w = 3;
        int[] maxWindow = getMaxWindow(arr, w);
        System.out.println(Arrays.toString(maxWindow));
    }
}
