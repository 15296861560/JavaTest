package Solution;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/*题目描述
        从上往下打印出二叉树的每个节点，同层节点从左至右打印。*/
public class Solution19 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList arrayList=new ArrayList();
        LinkedList linkedList=new LinkedList();//新建一个队列
        if (root==null)return arrayList;
        linkedList.add(root);//将根节点加入队列中
        while (!linkedList.isEmpty()){//当队列不为空时
            TreeNode treeNode=(TreeNode)linkedList.poll();//出队
            arrayList.add(treeNode.val);//记录值
            if (treeNode.left!=null){//左节点不为空时左节点入队
                linkedList.add(treeNode.left);
            }
            if (treeNode.right!=null){//右节点不为空时右节点入队
                linkedList.add(treeNode.right);
            }
        }
        return arrayList;


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

    public static void main(String[] args) {
        int[] pre={10,6,14,4,8,12,16};
        int[] in={4,6,8,10,12,14,16};

        TreeNode treeNode=reConstructBinaryTree(pre,in);
        System.out.println(PrintFromTopToBottom(treeNode));

    }
}
