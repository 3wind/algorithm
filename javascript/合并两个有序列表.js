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

/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
function ListNode(val) {
    this.val = val;
    this.next = null;
}
const listNode1 = new ListNode(1)
listNode1.next = new ListNode(7)


const listNode2 = new ListNode(2)
listNode2.next = new ListNode(4)
listNode2.next.next = new ListNode(6)

function mergeTwoLists(l1, l2) {
    if(l1 === null) {
        return l2;
    }
    if(l2 === null) {
        return l1
    }
    if(l1.val < l2.val) {
        l1.next = mergeTwoLists(l1.next, l2)
        return l1
    } else {
        l2.next = mergeTwoLists(l1, l2.next)
        return l2
    }
}
// //
function mergeTwoLists2(l1, l2) {
    if(l1 === null) {
        return l2;
    }
    if(l2 === null) {
        return l1;
    }
    const preHead = new ListNode(-1);
    let prev = preHead;
    while (l1 != null && l2 != null) {
        if(l1.val <=l2.val) {
            prev.next = l1
            l1 = l1.next
        } else {
            prev.next = l2
            l2 = l2.next
        }
        prev = prev.next
    }
    prev.next = l1 === null ? l2 : l1;
    return preHead.next
}

function listNodeToString(l) {
    if(l == null) {
        return "";
    }
    let s = l.val;
    let currentL = l.next
    while (currentL.next != null) {
        s = s + '->' + currentL.val
        currentL = currentL.next
    }
    s = s + '->' + currentL.val
    return s;
}

console.log(listNodeToString(listNode1))
console.log(listNodeToString(listNode2))
console.log(listNodeToString(mergeTwoLists(listNode1, listNode2)))
// console.log(listNodeToString(mergeTwoLists2(listNode1, listNode2)))
console.log(listNodeToString(listNode1))
console.log(listNodeToString(listNode2))
