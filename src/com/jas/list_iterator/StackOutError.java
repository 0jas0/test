package com.jas.list_iterator;

/**
 * Created by Administrator on 2017/11/7.
 */
public class StackOutError {
    private int depth;
    public void test(){
        depth++;
        test();
    }

    public static void main(String[] args) {
        StackOutError stackOutError = new StackOutError();
        try {
            stackOutError.test();
        }catch (Exception e){
            System.out.print(stackOutError.depth);
            throw e;
        }
    }
}
