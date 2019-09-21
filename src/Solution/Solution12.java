package Solution;

/*题目描述
        输入一个链表，反转链表后，输出新链表的表头。*/
public class Solution12 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode ReverseList(ListNode head) {
        if (head == null) return null;
        int l=0;
        ListNode reverseNode=new ListNode(head.val);
        ListNode listNode = head;
        while (listNode.next!=null){//获取链表长度
            listNode=listNode.next;
            l++;
        }
        l++;//加上头结点
        int[] val=new int[l];
        listNode=head;
        for (int i = 0; i <l ; i++) {//将链表值存入数组
            val[i]=listNode.val;
            listNode=listNode.next;
        }
        listNode=reverseNode;
        listNode.val=val[l-1];
        for (int i = l-1; i >0 ; i--) {//将值反转的存入新链表
            listNode.next=new ListNode(val[i-1]);
            listNode=listNode.next;

        }
        return reverseNode;

    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode tem = listNode;
        for (int i = 2; i < 10; i++) {
            tem.next = new ListNode(i);
            tem = tem.next;
        }
        tem = ReverseList(listNode);
        while (tem.next!=null){
            System.out.println(tem.val);
            tem=tem.next;
        }
        System.out.println(tem.val);
    }
}
