package Solution;

import java.util.Arrays;

/*题目描述
        输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
        例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。*/
public class Solution1 {
    public static void main(String[] args) {
        int[] pre={1,2,4,7,3,5,6,8};
        int[] in={4,7,2,1,5,3,8,6};

        TreeNode treeNode=reConstructBinaryTree(pre,in);
        DLR(treeNode);
    }
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length==0||in.length==0)return null;
        TreeNode treeNode=new TreeNode(pre[0]);
        int index=0;
        for (int i = 0; i <in.length ; i++) {
            if (pre[0]==in[i])index=i;
        }
        int[] left= Arrays.copyOfRange(pre,1,index+1);
        int[] inleft=Arrays.copyOfRange(in,0,index);
//        int[] inleft=Arrays.copyOf(in,index);
        int[] right= Arrays.copyOfRange(pre,index+1,pre.length);
        int[] inright=Arrays.copyOfRange(in,index+1,in.length);
        treeNode.left=reConstructBinaryTree(left,inleft);
        treeNode.right=reConstructBinaryTree(right,inright);


        return treeNode;
    }
    public static void DLR(TreeNode treeNode){

        if (treeNode!=null) {
            System.out.println(treeNode.val);
            DLR(treeNode.left);
            DLR(treeNode.right);
        }
    }
    // Definition for binary tree
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
