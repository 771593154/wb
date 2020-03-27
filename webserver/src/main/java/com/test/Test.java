package com.test;

import com.HttpClient.HttpclientUtil;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
//        Map<String ,String> array=new HashMap<String, String>();
//        String info=HttpclientUtil.getPostDateByUrl("https://www.baidu.com/",array);
//        array.put("name","po");
        String info=HttpclientUtil.getGetDateByUrl("https://www.baidu.com");
        System.out.println(info);
    }
}
