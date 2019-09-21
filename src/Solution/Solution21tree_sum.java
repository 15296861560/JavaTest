package Solution;


import java.util.ArrayList;
import java.util.Stack;

/*题目描述
        输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
        路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
        (注意: 在返回值的list中，数组长度大的数组靠前)*/
public class Solution21tree_sum {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {//深度优先搜索
        ArrayList arrayList=new ArrayList();
        int sum=0;
        Stack stack=new Stack();
        stack.push(root);
        while (!stack.isEmpty()){
        }
        return arrayList;


    }
}
