package hash;

import java.util.TreeMap;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/12/10 13:51
 * @Description:
 **/
public class HashRing {

    class Node{

    }

    public void test1(){
        TreeMap<Integer, Node> treeMap = new TreeMap<>();
        treeMap.put(12,new Node());
        treeMap.put(1243,new Node());
        treeMap.put(15,new Node());
        treeMap.put(124,new Node());
        treeMap.put(1112,new Node());
//        treeMap.tailMap()
        System.out.println(treeMap.keySet());
    }


}
