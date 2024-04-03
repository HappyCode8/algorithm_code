
#9. 分隔链表
725. Split Linked List in Parts(Medium)

Leetcode (opens new window)/ 力扣(opens new window)

Input:
root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
Explanation:
The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
题目描述：把链表分隔成 k 部分，每部分的长度都应该尽可能相同，排在前面的长度应该大于等于后面的。

public ListNode[] splitListToParts(ListNode root, int k) {
int N = 0;
ListNode cur = root;
while (cur != null) {
N++;
cur = cur.next;
}
int mod = N % k;
int size = N / k;
ListNode[] ret = new ListNode[k];
cur = root;
for (int i = 0; cur != null && i < k; i++) {
ret[i] = cur;
int curSize = size + (mod-- > 0 ? 1 : 0);
for (int j = 0; j < curSize - 1; j++) {
cur = cur.next;
}
ListNode next = cur.next;
cur.next = null;
cur = next;
}
return ret;
}
#10. 链表元素按奇偶聚集
328. Odd Even Linked List (Medium)

Leetcode (opens new window)/ 力扣(opens new window)

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.
public ListNode oddEvenList(ListNode head) {
if (head == null) {
return head;
}
ListNode odd = head, even = head.next, evenHead = even;
while (even != null && even.next != null) {
odd.next = odd.next.next;
odd = odd.next;
even.next = even.next.next;
even = even.next;
}
odd.next = evenHead;
return head;
}
粤ICP备19071404号