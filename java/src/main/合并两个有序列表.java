import bean.ListNode;

/**
 * @ title: 合并两个有序列表
 * @ author WangXin
 * @ date 2023/5/29 16:09
 * @ description:
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class 合并两个有序列表 {
    public static void main( String[] args ) {
        ListNode l1 = new ListNode(1,null);
        l1.setNext(new ListNode(5,null));
        ListNode l2 = new ListNode(4,null);
        l2.setNext(new ListNode(7,null));
        ListNode l3 = mergeTwoLists(l1, l2);

//        System.out.println(l3.toString());
        System.out.println(listNodeToString(l3));
    }

    static String listNodeToString(ListNode l) {
        if(l == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(l.getVal());
        ListNode currentL = l.getNext();
        while (currentL.getNext() != null) {
            stringBuilder.append("->").append(currentL.getVal());
            currentL = currentL.getNext();
        }
        stringBuilder.append("->").append(currentL.getVal());
        return stringBuilder.toString();
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        } else if(l2 == null) {
            return l1;
        } else if(l1.getVal() < l2.getVal()) {
            l1.setNext(mergeTwoLists(l1.getNext(), l2));
            return l1;
        } else {
            l2.setNext(mergeTwoLists(l1, l2.getNext()));
            return l2;
        }

    }

}
