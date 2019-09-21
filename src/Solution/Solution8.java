package Solution;

/*题目描述
        输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。*/
public class Solution8 {
    public static void main(String[] args) {
        int i=(int)Math.pow(2,31);
        System.out.println(i+":"+NumberOf1(i));
    }
    public static int NumberOf1(int n) {
        int num=0;
        if (n>=0) {
            for (int i = 0; n != 0; i++) {
                if ((n % 2) != 0) num++;
                n = n / 2;
            }
        }else {//负数求补码
            for (int i = 0; i < 32; i++)
            {
                // 0x80000000 是一个首位为1，其余位数为0的整数
                int t = (n & 0x80000000 >>> i) >>> (31 - i);
                if (t==1)num++;
            }
        }
        return num;
    }
}
