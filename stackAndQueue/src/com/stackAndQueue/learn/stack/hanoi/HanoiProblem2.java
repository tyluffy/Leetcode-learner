package com.stackAndQueue.learn.stack.hanoi;

import java.util.Stack;

public class HanoiProblem2 {

    public int hanoiProblem2(int num, String left, String mid, String right) {
        Stack<Integer> lS = new Stack<>();
        Stack<Integer> mS = new Stack<>();
        Stack<Integer> rS = new Stack<>();

        lS.push(Integer.MAX_VALUE);
        mS.push(Integer.MAX_VALUE);
        rS.push(Integer.MAX_VALUE);

        for (int i = num; i > 0; i--) {
            lS.push(i);
        }

        int step = 0;
        Action[] preNoAct = {Action.No};
        while (rS.size() != num + 1) {
            step += fStackTotStack(preNoAct, Action.MToL, Action.LToM, lS, mS, left, mid);
            step += fStackTotStack(preNoAct, Action.LToM, Action.MToL, mS, lS, mid, left);
            step += fStackTotStack(preNoAct, Action.RToM, Action.MToR, mS, rS, mid, right);
            step += fStackTotStack(preNoAct, Action.MToR, Action.RToM, rS, mS, right, mid);
        }
        return step;
    }

    public int fStackTotStack(Action[] action, Action preNoAct, Action nowAct, Stack<Integer> fStack, Stack<Integer> tStack, String from, String to) {
        if (action[0] != preNoAct && fStack.peek() < tStack.peek()) {
            tStack.push(fStack.pop());
            System.out.println("Move " + tStack.peek() + " from " + from + " to " + to);
            action[0] = nowAct;
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        HanoiProblem2 hanoiProblem2 = new HanoiProblem2();
        hanoiProblem2.hanoiProblem2(2, "left", "mid", "right");
    }
}

enum Action {
    No, LToM, MToL, RToM, MToR
}