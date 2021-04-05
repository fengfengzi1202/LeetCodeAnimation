public class ReverseKGroupSolution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (null == head) {
            return null;
        }

        ListNode hummyNode = new ListNode(0);
        hummyNode.next = head;
        // 指向Kgroup start 前面的一个节点
        ListNode pre = hummyNode;
        // 指向kgourp end, 可以通过 end即是下一个group的开始
        ListNode end = hummyNode;

        while (end.next != null) {
            // 将end指向该第i组的末尾
            for (int i = 0; i < k; i++) {
                end = end.next;
            }
            // 如果不够到k的末尾，直接退出循环，结束
            if (end == null) {
                break;
            }

            // 开始构造需要反转的一组
            ListNode start = pre.next;
            // 下一个K组的head保留下来
            ListNode next = end.next;
            end.next = null;
            // 反转  反转后的结果接续到之前的链中
            pre.next = reverse(start);
            // 组织新的pre next供下次循环
            start.next = next;
            pre = start;
            end = pre;
        }

        return hummyNode.next;
    }

    public ListNode reverse(ListNode start) {
        // 反转需要两个变狼 一个是pre：保存反转后的指针  一个是curr:代表当前待反转的指针
        ListNode pre = null;
        ListNode curr = start;
        // 反转的过程  1 2 3 ---》 pre:2 - 1 curr:3  curr.next = pre;
        // 由于前面已将start组的末尾指针置为null， 所以以null作为判断依据
        while (curr != null) {
            // 需要一个next 指针来保存当前的下一个指针
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return pre;
    }
}
