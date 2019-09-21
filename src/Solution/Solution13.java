package Solution;

/*题目描述
        输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。*/
public class Solution13 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode Merge(ListNode list1,ListNode list2) {
        ListNode listNode=null;
        ListNode mergeNode=null;
        if (list1==null&&list2==null)return null;
        if (list2==null||list1.val<list2.val){
            listNode=new ListNode(list1.val);
            list1=list1.next;
        }else {
            listNode=new ListNode(list2.val);
            list2=list2.next;
        }
        mergeNode=listNode;
        while (list1!=null||list2!=null){
            //出现空指针情况
            if (list1==null){
                listNode.next=new ListNode(list2.val);
                list2=list2.next;
                listNode=listNode.next;
            }
            else if (list2==null){
                listNode.next=new ListNode(list1.val);
                list1=list1.next;
                listNode=listNode.next;
            }
            //没有空指针情况
            else if (list1.val<list2.val){
                listNode.next=new ListNode(list1.val);
                list1=list1.next;
                listNode=listNode.next;
            }else {
                listNode.next=new ListNode(list2.val);
                list2=list2.next;
                listNode=listNode.next;
            }
        }

        return mergeNode;

    }
    public static void main(String[] args) {
        ListNode tem = null;
        ListNode tem1 = new ListNode(1);
        ListNode tem2 = new ListNode(1);
        tem=tem1;
        for (int i = 2; i < 10; i++) {
            tem1.next = new ListNode(i);
            tem1 = tem1.next;
        }
        tem1=tem;
        tem=tem2;
        for (int i = 2; i < 20; i=i+2) {
            tem2.next = new ListNode(i);
            tem2 = tem2.next;
        }
        tem2=tem;
        tem=Merge(tem1,tem2);
        while (tem.next!=null){
            System.out.println(tem.val);
            tem=tem.next;
        }
        System.out.println(tem.val);
    }
}
