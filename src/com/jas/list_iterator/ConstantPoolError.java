package com.jas.list_iterator;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/7.
 */
public class ConstantPoolError {
    public static void main(String[] args) {
        List<String> list = new LinkedList<String>();
        int i = 0;
        while (true){
            list.add(String.valueOf(i++).intern());
        }
    }
}
