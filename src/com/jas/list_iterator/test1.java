package com.jas.list_iterator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/11/1.
 */
public class test1 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        map.put("d",4);
        Set<String> strings = map.keySet();
        for(String key : strings){
            Integer integer = map.get(key);
            System.out.print(integer);
        }
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for(Map.Entry<String, Integer> entry : entries){
            System.out.println(entry.getKey()+"----"+entry.getValue());
        }
        System.out.println("aab");
        System.out.println("bbb");
    }
}
