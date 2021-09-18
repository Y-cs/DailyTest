package list;

import java.util.Random;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/7/28 11:36
 * @Description:
 **/
public class SkipLinkedList {

    static class Node {
        Node prev;
        Node next;
        Node down;
        int val;
    }

    static class LinkedList {
        Node head;
        Node feet;

        public LinkedList() {
            head = new Node();
            feet = new Node();
            head.next = feet;
            feet.prev = head;
        }

        public Node add(int val, Node down) {
            Node node = head.next;
            while (node != feet && node.val < val) {
                node = node.next;
            }
            Node newNode = new Node();
            newNode.prev = node.prev;
            newNode.next = node;
            newNode.val = val;
            newNode.down = down;
            node.prev.next = newNode;
            node.prev = newNode;
            return newNode;
        }

        public Node search(Node node, int val) {
            if (node == null) {
                node = head.next;
            }
            while (node != feet && node.val <= val) {
                node = node.next;
            }
            return node.prev == head ? null : node.prev;
        }

        public boolean isEmpty() {
            return head.next == feet;
        }

        public void erase(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node next = head.next;
            while (next != feet) {
                sb.append(next.val).append("\t");
                next = next.next;
            }
            return sb.toString();
        }
    }

    int capacity = 64;
    LinkedList[] skipList = new LinkedList[capacity];
    int maxLevel = capacity;

    public void add(int val) {
        int level = skipList.length;
        Node node = doAdd(--level, val, null);
        Random random = new Random();
        while (random.nextInt(10) > 2 && level > 0) {
            node = doAdd(--level, val, node);
        }
        maxLevel = Math.min(maxLevel, level);
    }

    private Node doAdd(int level, int val, Node down) {
        if (skipList[level] == null) {
            skipList[level] = new LinkedList();
        }
        return skipList[level].add(val, down);
    }

    public boolean search(int val) {
        Node node = null;
        for (int i = maxLevel; i < capacity; i++) {
            node = skipList[i].search(node, val);
            if (node != null) {
                if (node.val == val) {
                    return true;
                }
                if (node.down == null) {
                    break;
                }
                node = node.down;
            }
        }
        return false;
    }

    public boolean erase(int val) {
        Node node = null;
        for (int i = maxLevel; i < capacity; i++) {
            node = skipList[i].search(node, val);
            if (node != null) {
                if (node.val == val) {
                    while (node != null) {
                        skipList[i].erase(node);
                        if (skipList[i].isEmpty()) {
                            maxLevel++;
                        }
                        i++;
                        node = node.down;
                    }
                    return true;
                }
                if (node.down == null) {
                    break;
                }
                node = node.down;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LinkedList linkedList : skipList) {
            if (linkedList != null) {
                Node next = linkedList.head.next;
                while (next != linkedList.feet) {
                    sb.append(next.val).append("\t");
                    next = next.next;
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
