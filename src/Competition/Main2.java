package Competition;


import java.util.Scanner;

/*        题目描述
        今年是国际数学联盟确定的“2000——世界数学年”，又恰逢我国著名数学家华罗庚先生诞辰90周年。
        在华罗庚先生的家乡江苏金坛，组织了一场别开生面的数学智力竞赛的活动，你的一个好朋友XZ也有幸得以参加。
        活动中，主持人给所有参加活动的选手出了这样一道题目：
        设有一个长度为N的数字串，要求选手使用K个乘号将它分成K+1个部分，找出一种分法，使得这K+1个部分的乘积能够为最大。
        同时，为了帮助选手能够正确理解题意，主持人还举了如下的一个例子：
        有一个数字串：312， 当N=3，K=1时会有以下两种分法：
        1) 3*12=36
        2) 31*2=62
        这时，符合题目要求的结果是：31*2=62
        现在，请你帮助你的好朋友XZ设计一个程序，求得正确的答案。
输入描述:
第一行共有2个自然数N，K（6 ≤ N ≤ 40，1 ≤ K ≤ 6）
第二行是一个长度为N的数字串。
输出描述:
输出所求得的最大乘积（一个自然数）。*/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,k;
        n=sc.nextInt();
        k=sc.nextInt();
        String number;
        number=sc.next();
        char[] num=number.toCharArray();
        int[][] dp=new int[n+1][k+1];
        int[][] data=new int[n+1][n+1];
        for (int i = 0; i <n ; i++) {
            int tem=0;
            for (int j = i; j <n ; j++) {
                tem=tem*10+num[j]-'0';
                data[i][j]=tem;
            }
        }
        for (int i = 0; i <n ; i++) {
            dp[i][0]=data[0][i];
        }
        for (int i = 0; i <n ; i++) {
            for (int j = 1; j <=k ; j++) {
                for (int l = 0; l <i ; l++) {
                    dp[i][j]=max(dp[l][j-1]*data[l+1][i],dp[i][j]);
                }
            }
        }
        System.out.println(dp[n-1][k]);
    }
    static int  max(int a,int b){
       return a>b?a:b;
    }
}
