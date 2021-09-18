package list;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/7/28 16:28
 * @Description:
 **/
public class Test {

    public static void main(String[] args) {
//        textLinkedList();
        SkipLinkedList skipLinkedList = new SkipLinkedList();
//        Random random = new Random();
//        for (int i = 0; i < 100; i++) {
//            skipLinkedList.add(random.nextInt(1000));
//        }
        skipLinkedList.add(1);
        skipLinkedList.add(2);
        skipLinkedList.add(3);
        System.out.println(skipLinkedList);
        skipLinkedList.erase(1);
        System.out.println("-----");
        System.out.println(skipLinkedList);
        System.out.println("-----");
        System.out.println(skipLinkedList.search(1));
        System.out.println("-----");
        skipLinkedList.erase(3);
        System.out.println(skipLinkedList);
    }


    private static void textLinkedList() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1,2);
        System.out.println(myLinkedList.get(1));
        myLinkedList.deleteAtIndex(1);
        System.out.println(myLinkedList.get(1));
    }

}
