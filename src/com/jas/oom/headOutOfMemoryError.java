package com.jas.oom;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2018/2/25.
 */
public class headOutOfMemoryError {
    static class OOMObject{}
    public static void main(String[] args) {
        List<OOMObject> list = new LinkedList<>();
        while (true){
            OOMObject obj = new OOMObject();
            list.add(obj);
        }
    }
}
