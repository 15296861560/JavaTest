package Solution;


import java.util.Arrays;

/*题目描述
        输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
        假设输入的数组的任意两个数字都互不相同。*/
public class Solution20 {
    public static boolean VerifySquenceOfBST(int [] sequence) {
        int length=sequence.length;
        if (length==0)return false;
        if (length<3)return true;
        int root=sequence[length-1];//根值
        int i = 0;
        for (; i <length-1 ; i++) {
            if (sequence[i]>root)break;//此时sequence[i-1]为下root的左节点
        }
        int[] left= Arrays.copyOf(sequence,i);//左子树
        int[] right= Arrays.copyOfRange(sequence,i,length-1);//右子树
        for (int j = 0; j <left.length ; j++) {//如果左子树中有大于根的返回false
            if (left[j]>root)return false;
        }
        for (int j = 0; j <right.length ; j++) {//如果右子树中有小于根的返回false
            if (right[j]<root)return false;
        }
        if (left.length==0)return VerifySquenceOfBST(right);//如果左子树没有孩子了就只看右子树
        if (right.length==0)return VerifySquenceOfBST(left);//如果右子树没有孩子了就只看左子树
        return VerifySquenceOfBST(left)&&VerifySquenceOfBST(right);


    }

    public static void main(String[] args) {
        int[] test={1,2,3,4,5};
        System.out.println(VerifySquenceOfBST(test));
    }
}
