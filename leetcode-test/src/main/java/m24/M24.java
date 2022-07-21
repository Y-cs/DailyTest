package m24;

import e21.ListNode;

/**
 * @Author: YuanChangShuai
 * @Date: 2022/3/9 10:31
 * @Description:
 **/
public class M24 {

    public ListNode swapPairs(ListNode head) {
        ListNode list=new ListNode(0,head);
        ListNode temp=list;
        ListNode[] windows=new ListNode[3];
        windows[0]=list;
        while (true){
            windows[1]=list=list.next;
            if (list==null){
                break;
            }
            windows[2]=list=list.next;
            if (list==null){
                break;
            }
            windows[0].next=windows[2];
            windows[1].next=windows[2].next;
            windows[2].next=windows[1];
            windows[0]=list=windows[1];
        }
        return temp.next;
    }


}
