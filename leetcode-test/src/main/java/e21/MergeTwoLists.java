package e21;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/6 10:22
 * @Description:
 **/
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            doMerge2(l1, l2);
            return l1;
        } else {
            doMerge2(l2, l1);
            return l2;
        }
    }


    public ListNode doMerge(ListNode l1, ListNode l2) {
        if (l2 == null) {
            return l1;
        }
        if (l1.next == null || l2.val < l1.next.val) {
            ListNode next = l1.next;
            l1.next = l2;
            return doMerge(l1.next, next);
        } else {
            return doMerge(l1.next, l2);
        }
    }

    public void doMerge2(ListNode l1, ListNode l2) {
        while (true) {
            if (l2 == null) {
                return;
            }
            if (l1.next == null || l2.val < l1.next.val) {
                ListNode next = l1.next;
                l1.next = l2;
                l1 = l1.next;
                l2 = next;
            } else {
                l1 = l1.next;
            }
        }
    }

}
