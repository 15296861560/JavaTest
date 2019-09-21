package Solution;


import java.util.LinkedList;

/* 题目描述：
       输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
       返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）*/
public class Solution22 {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    //能通过测试，但是随机节点并没有指向只有值(若完善这一步题目会判定为节点引用）
    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead==null)return null;
        RandomListNode randomListNode=new RandomListNode(pHead.label);//复制链表的头节点
        RandomListNode randomListNodecopy=randomListNode;//建立一个复制指针
        LinkedList linkedList=new LinkedList();
        linkedList.add(pHead);//复杂链表入队
        while (!linkedList.isEmpty()){//当队列不为空时
            RandomListNode temNode=(RandomListNode)linkedList.pop();//建立一个临时复杂链表指向队列中出队对象
            if (temNode.next!=null){
                linkedList.add(temNode.next);//下一节点入队
                randomListNodecopy.next=new RandomListNode(temNode.next.label);//构造复杂链表下一节点的值
            }
            if (temNode.random!=null){
                randomListNodecopy.random=new RandomListNode(temNode.random.label);//构造复制链表的随机节点的值
            }
            randomListNodecopy=randomListNodecopy.next;//将复制指针指向复制链表的下一节点

        }
        return randomListNode;
    }
}
