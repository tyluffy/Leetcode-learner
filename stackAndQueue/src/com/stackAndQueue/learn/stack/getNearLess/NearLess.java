package com.stackAndQueue.learn.stack.getNearLess;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NearLess {

    public static int[][] getNearLess(int[] arr) {
        int[][] res = new int[arr.length][2];
        Stack<List<Integer>> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
                List<Integer> popIs = stack.pop();
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() -1);

                for (Integer popI : popIs) {
                    res[popI][0] = leftLessIndex;
                    res[popI][1] = i;
                }

            }
            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(arr[i]);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                stack.push(list);
            }
        }

        while (!stack.isEmpty()) {
            List<Integer> pop = stack.pop();
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() -1);
            for (Integer popI : pop) {
                res[popI][0] = leftLessIndex;
                res[popI][1] = -1;
            }
        }

        return res;
    }

}
