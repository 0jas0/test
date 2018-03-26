package com.jas.oom;

/**
 * Created by Administrator on 2018/2/25.
 */
public class stackOutOfMemoryError {
    private int deep = 0;
    public void stackLeak(){
        deep++;
        stackLeak();
    }

    public int getDeep() {
        return deep;
    }

    public void setDeep(int deep) {
        this.deep = deep;
    }

    public static void main(String[] args) {
        stackOutOfMemoryError stackOverflowError = new stackOutOfMemoryError();
        try {
            stackOverflowError.stackLeak();
        }catch (Exception e){
            System.out.println("栈的最大深度为："+stackOverflowError.getDeep());
        }
    }
}
