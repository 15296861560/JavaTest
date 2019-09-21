package Solution;


import java.util.Stack;

/*题目描述
        定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。*/
public class Solution17 {
    Stack<Integer> stack=new Stack();
    public void push(int node) {
        stack.push(node);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return (int)stack.peek();
    }

    public int min() {
        Object[]array=stack.toArray();
        int min=(int)array[0];
        int tem=0;
        for (int i = 1; i <array.length ; i++) {
            tem=(int)array[i];
            if (tem<min)min=tem;
        }
        return min;

    }

    public static void main(String[] args) {
        Solution17 test=new Solution17();
        test.push(3);
        System.out.println(test.min());
        test.push(4);
        System.out.println(test.min());
        test.push(2);
        System.out.println(test.min());
        test.push(3);
        System.out.println(test.min());
        test.pop();
        System.out.println(test.min());
        test.pop();
        System.out.println(test.min());
        test.pop();
        System.out.println(test.min());
        test.push(0);
        System.out.println(test.min());
    }
}
