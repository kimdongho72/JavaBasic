package hw250521.challenge;

import java.util.*;

public class Challenge3 {
    public static void main(String[] args) {
     
        Map<String, String> dic = new HashMap<>();
        dic.put("head", "대가빠리");
        dic.put("teacher", "쌤");
        dic.put("cat", "꼬네이");
        dic.put("aunt", "아지매");
        dic.put("noodle", "국시");
        dic.put("child", "얼라");

        
        dic.forEach((key, value) -> System.out.print(key + "=" + value + " "));
        System.out.println();

      
        Collection<String> collection1 = dic.values();

       
        List<String> list = new ArrayList<>(collection1);

       
        Collections.shuffle(list);

       
        list.forEach(x -> System.out.print(x + " "));
    }
}