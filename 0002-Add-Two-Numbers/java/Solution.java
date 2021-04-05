public class Solution {


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 计算两个链表中的第一个
        ListNode result = new ListNode(l1.value + l2.value);
        l1 = l1.next;
        l2 = l2.next;
        ListNode temp = result;
        int flag = 0;
        while (l1 != null || l2 != null) {
            int a = 0;
            int b = 0;

            if (l1 != null) {
                a = l1.value;
                l1 = l1.next;
            }

            if (l2 != null) {
                b = l2.value;
                l2 = l2.next;
            }

            int t = a + b;
            boolean flag2 = false;
            if (t >= 10) {
                t = t - 10;
                flag2 = true;
            }
            temp.next = new ListNode(t + flag);
            flag = flag2 ? 1 : 0;
            temp = temp.next;
        }

        return result;
    }

    public static void main(String[] args) {
        // 构造数据
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);

        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;

        listNode4.next = listNode5;
        listNode5.next = listNode6;

        //
        ListNode listNode = Solution.addTwoNumbers(listNode1, listNode4);
        listNode.printListNode();

    }
    private static class ListNode {
        private int value;
        private ListNode next;

        public ListNode(int value) {
            this.value = value;
        }

        public void printListNode() {
          ListNode temp = this;
          while (temp != null) {
              System.out.println(temp.value + "-->");
              temp = temp.next;
          }
        }
        // setter
        // getter
    }
}
