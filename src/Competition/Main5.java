package Competition;


import java.util.Scanner;

/*        题目描述
        若一个数（首位不为零）从左向右读与从右向左读都一样，我们就将其称之为回文数。

        例如：给定一个10进制数56，将56加56（即把56从右向左读），得到121是一个回文数。
        又如：对于10进制数87：
        STEP1：87+78  = 165                  STEP2：165+561 = 726

        STEP3：726+627 = 1353                STEP4：1353+3531 = 4884

        在这里的一步是指进行了一次N进制的加法，上例最少用了4步得到回文数4884。

        写一个程序，给定一个N（2<=N<=10，N=16）进制数M，求最少经过几步可以得到回文数。
        如果在30步以内（包含30步）不可能得到回文数，则输出“Impossible！”
输入描述:
两行，分别是N，M。
输出描述:
STEP=ans(ans表示答案)*/
public class Main5 {
    public static void main(String[] args) {
        int n;
        String m;
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.next();
        int[]v=new int[20];//v是字符串转换为整数 下标小的放低位 下标大的放高位
        int[]vr=new int[20];
        int len=m.length();
        for(int i=len-1,j=0;i>=0;i--,j++)
        {
            if(m.charAt(i)>='A')
                v[j]=m.charAt(i)-'A'+10;           //处理十六进制

            else
                v[j]=m.charAt(i)-'0';
        }

        //逆序放入vr
        for(int i=0;i<len;i++)
        {
            vr[i]=v[len-i-1];
        }

        //相加
        for(int i=1;i<=30;i++)
        {
            int jinwei=0;
            for(int j=0;j<len;j++)
            {
                v[j]+=vr[j]+jinwei;
                jinwei=v[j]/n;         //进位等于加起来除以进制
                v[j]%=n;               //如果大于等于进制那么就会改变
            }
            if(jinwei>0)
            {
                v[len++]=jinwei;         //如果最后有进位产生 那么就进一位
            }

            //判断是否是回文
            int s=0,e=len-1;
            while(s<=e)
            {
                if(v[s]!=v[e])
                    break;

                s++;e--;
            }

            if(s>e)
            {
                System.out.println("STEP="+i);
                return ;
            }

            else
            {
                //逆序放入vr
                for(int j=0;j<len;j++)
                {
                    vr[j]=v[len-j-1];
                }
            }
        }

        System.out.println("Impossible!");



    }
}
