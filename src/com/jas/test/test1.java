package com.jas.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class test1 {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0,j=0;i<pushA.length;i++){
            stack.push(pushA[i]);
            while((j<popA.length) && (stack.peek()== popA[j])){
                stack.pop();

                j++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,5,3,2,1};
        boolean bool =  IsPopOrder(pushA,popA);
        System.out.println(bool);
    }
}
