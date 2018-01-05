package com.jas.list_iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by Administrator on 2017/9/20.
 */
public class TestListIterator {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(3);
        list.add(5);
        list.add(1);
        list.add(2);
        new ArrayList<Integer>().add(10);
        ListIterator<Integer> it = list.listIterator();
        while (it.hasNext()){
            Integer next = it.next();
            System.out.print(next);
        }
        System.out.println();
        while (it.hasPrevious()){
            Integer next = it.previous();
            System.out.print(next);
        }
    }
}
