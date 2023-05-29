package bean;

/**
 * @ title: ListNode
 * @ author WangXin
 * @ date 2023/5/29 16:23
 */
public class ListNode {
    private int val;
    private ListNode next;

    public ListNode(int value, ListNode node) {
        val = value;
        next = node;
    }

    public void setVal(int value) {
        val = value;
    }
    public int getVal() {
        return val;
    }

    public void setNext(ListNode node) {
        next = node;
    }
    public ListNode getNext() {
        return next;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(val);
        ListNode l = next;
        while(l != null) {
            stringBuilder.append("->").append(l.val);
            l = l.next;
        }
        return stringBuilder.toString();
    }
}
