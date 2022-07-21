package dict;

/**
 * @Author: YuanChangShuai
 * @Date: 2022/3/11 14:28
 * @Description:
 **/
public class Dict<K, V> {

    private static final int DEFAULT_SIZE = 8;

    static class TableNode<K, V> {
        K key;
        V val;
        TableNode<K, V> next;
    }

    private final TableNode<K, V>[][] ts;
    private final int[] tableSize;
    private final int[] tableUsed;
    /**
     * 1->正常可以使用
     * -1->正在扩容
     */
    private volatile int status;

    public Dict() {
        ts = new TableNode[][]{new TableNode[DEFAULT_SIZE], null};
        tableSize = new int[]{DEFAULT_SIZE, DEFAULT_SIZE};
        tableUsed = new int[]{0, 0};
        status = 1;
    }

    public void put(K key, V val) {
        if (status == 1) {
            putToIndex(key, val, 0);
        } else if (status < 0) {
            putToIndex(key, val, 1);
        }
        checkStatus();
        enlarge();
    }

    private void putToIndex(K key, V val, int tableIndex) {
        TableNode<K, V>[] t = ts[tableIndex];
        int index = index(key, tableIndex);
        TableNode<K, V> node = t[index];
        while (node != null) {
            if (node.key.equals(key)) {
                node.val = val;
                break;
            }
            node = node.next;
        }
        if (node == null) {
            TableNode<K, V> temp = new TableNode<>();
            temp.key = key;
            temp.val = val;
            temp.next = t[index];
            t[index] = temp;
            tableUsed[tableIndex]++;
        }
    }

    private int index(K key, int tableIndex) {
        int hashCode = key.hashCode();
        return (hashCode >> 16) ^ hashCode & tableSize[tableIndex] - 1;
    }

    private void checkStatus() {
        if (status == 0) {
            if (tableUsed[0] / tableSize[0] >= 1) {
                status = -1;
            }
        }
    }

    private void enlarge() {
        if (status == -1) {
            if (ts[1] == null) {
                //开始转移
                int newSize = tableSize[0] << 1;
                ts[1] = new TableNode[newSize];
                tableSize[1] = newSize;
                tableUsed[1] = 0;
            }
            int used = tableUsed[0];
            findNeedTransfer(Math.max(used & 8,1));
            if (tableUsed[0] == 0) {
                //转移结束
                ts[0] = ts[1];
                status = 1;
                ts[1] = null;
                tableSize[0] = tableSize[1];
                tableUsed[0] = tableUsed[1];
            }
        }
    }

    private void findNeedTransfer(int transferSize) {
        for (TableNode<K, V> nodeTemp : ts[0]) {
            if (nodeTemp != null) {

            }
        }
    }

}
