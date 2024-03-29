package Solution;

/*题目描述
        一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
        */
public class Solution5 {
    public static int JumpFloor(int target) {
        if (target==1)return 1;
        else if (target==2)return 2;
        else return (JumpFloor(target-2)+JumpFloor(target-1));

    }


    public static void main(String[] args) {
        int test=10;
        while (test-->0) {
            System.out.println(JumpFloor(test));
        }
    }
}
