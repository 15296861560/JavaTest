package Solution;

/*题目描述
        输入一个链表，输出该链表中倒数第k个结点。*/
public class Solution11 {
    public  static  class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode FindKthToTail(ListNode head,int k) {
        if (head==null)return null;
        int l=1;
        ListNode listNode=head;//新建一个临时的ListNode指向head
        while (listNode.next!=null){//获取链表长度
            listNode=listNode.next;
            l++;
        }
        int j=l-k;//倒数第k个数是正数的第j个数的next
        if (j<0)return null;
        listNode=head;//重新指向head
        while ((j--)>0)listNode=listNode.next;
        return listNode;
    }

    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
        ListNode tem=listNode;
        for (int i = 2; i <10 ; i++) {
            tem.next=new ListNode(i);
            tem=tem.next;
        }
//        while (listNode.next!=null){
//            System.out.println(listNode.val);
//            listNode=listNode.next;
//        }
//        System.out.println(listNode.val);
        tem=FindKthToTail(listNode,10);
        System.out.println(tem.val);

    }
}
