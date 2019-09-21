package Solution;


import java.util.Stack;

/*题目描述
        输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
        假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
        但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）*/
public class Solution18 {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length==0) return false;
        Stack<Integer> stack=new Stack<Integer>();
        for(int i = 0,j = 0 ;i < pushA.length;){//把pushA压入栈
            stack.push(pushA[i++]);
            while(j < popA.length && stack.lastElement()== popA[j]){//当popA的第一个元素等于栈的最后一个元素时
                stack.pop();//出栈
                j++;//屏蔽popA中已测试过的元素
            }
        }
        return stack.empty();//栈空则真否则为假
    }

    public static void main(String[] args) {
        int[] push={1,2,3,4,5};
        int[] pop1={4,5,3,2,1};
        int[] pop2={4,3,5,1,2};
        System.out.println(IsPopOrder(push,pop2));
    }
}
