package Solution;

import java.util.Stack;

/*题目描述
        用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。*/
public class Solution2 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);

    }

    public int pop() {
        int x=0,index=0;
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        x=stack2.pop();
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return x;
    }

}
