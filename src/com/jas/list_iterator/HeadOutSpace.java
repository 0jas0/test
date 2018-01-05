package com.jas.list_iterator;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/7.
 */
public class HeadOutSpace {
    private static final ThreadLocal<List<Object>> local = new ThreadLocal<>();
    public static void outHeadSpace(){
        List<Object> lists = local.get();
        if(lists==null){
            lists = new LinkedList<>();
            local.set(lists);
        }
        while(true){
            lists.add(new Object());
        }
    }

    public static void main(String[] args) {
        outHeadSpace();
    }
}
