package Competition;

import java.util.Scanner;

/* 题目描述
    Bessie正在和Farmer John打一场比赛，她希望你能帮助她取得胜利。
    游戏i以整数Ni（1 <= Ni <= 1,000,000）开始。Bessie先跑，然后两名球员轮流转。在每个回合中，
    玩家可以从当前数字中减去最大数字或最小非零数字以获得新数字。例如，从3014我们可以减去1或4以分别获得3013或3010。
    游戏一直持续到数字变为0，此时最后一个转弯的玩家是胜利者。
    Bessie和FJ玩G（1 <= G <= 100）游戏。对于每场比赛，确定Bessie或FJ是否会胜利，
    假设两者都完美地发挥（即，在每个回合中，如果当前玩家有一个移动将保证他或她的胜利，他或她将接受它）。
    考虑一个样本游戏，其中Ni = 13.Bessie首先获得3，离开10.FJ被迫取1，离开9.Bessie夺取剩余部分并赢得比赛。
    输入描述：
            *第1行：单个整数：G
            *第2..G + 1行：第i + 1行包含单个整数：Ni
    输出描述：
            *第1..G行：如果贝西可以赢得比赛，则第i行包含'是'，否则为'否'。*/
public class Main7 {


    public static void main(String[] args) {
        int maxi,mini,len;
        int[]sg=new int[1000010];
        int[]num=new int[10];
        sg[0]=0;
        int i,t,n;
        len=0;
        Scanner sc = new Scanner(System.in);
        for(i=1;i<=1000000;i++)
        {
            t=i;
            maxi=0;
            mini=10;
            while(t!=0)
            {
                if(t%10>maxi)
                    maxi=t%10;
                if(t%10>0&&t%10<mini)
                    mini=t%10;
                t/=10;
            }
            sg[i]=(sg[i-maxi]&sg[i-mini])^1;
        }
        n=sc.nextInt();
        for(i=1;i<=n;i++)
        {
            t=sc.nextInt();
            if(sg[t]!=0)
            System.out.println("YES");
            else
            System.out.println("NO");
        }


    }
}
