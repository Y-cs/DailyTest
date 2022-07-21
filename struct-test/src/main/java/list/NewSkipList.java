package list;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: YuanChangShuai
 * @Date: 2022/3/11 11:30
 * @Description:
 **/
public class NewSkipList<K, V> {

    private final static int MAX_LEVEL = 64;
    private SkipListNode<K, V> head;
    private int size = 0;
    private int level = 0;

    public NewSkipList() {
        head = new SkipListNode<>();
        head.nextNodes = new ArrayList<>(MAX_LEVEL);
    }

    public void add() {
//        head.
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    static class SkipListNode<K, V> {
        K key;
        V value;
        List<SkipListNode<K, V>> nextNodes;
        SkipListNode<K, V> prevNode;
    }


}
