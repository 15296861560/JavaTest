package Competition;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*题目描述
    Bessie正在玩捉迷藏（一个游戏中，一些玩家隐藏，一个玩家（寻求者）试图找到它们，
    之后评估各种惩罚和奖励;通常会发生很多乐趣）。
    她试图弄清楚哪个N（2 <= N <= 20,000）的谷仓方便地编号为1 ...... N她应该隐藏。她知道FJ（寻找者）从谷仓1开始。
    所有的谷仓都通过M（1 <= M <= 50,000）双向路径连接，端点为Ai和Bi（1 <= Ai <= N; 1 <= Bi <= N;一个我≠B i）;
     可以通过路径到达任何其他谷仓。
    Bessie决定隐藏在与谷仓1距离最远的谷仓中是最安全的（两个谷仓之间的距离是一个必须经过的路径从一个到另一个的最小路径）。
    帮Bessie弄清楚要隐藏的最好的谷仓。
    输入描述：
            *第1行：两个以空格分隔的整数：N和M
            *第2..M + 1行：第i + 1行包含路径i的端点：Ai和Bi
    输出描述：
            *第1行：在一行上，打印三个以空格分隔的整数：距离谷仓1最远的谷仓索引（如果有多个这样的谷仓，
            * 打印最小的这样的索引），到达此谷仓所需的最小路径数来自谷仓1，以及具有此路径数的谷仓数量。*/
public class Main8 {
    static int tot=0;
    static int to[],net[],cap[],from[];
    static int vis[],num[],dis[];
    static Queue que=new LinkedList();


    public static void main(String[] args) {
        int n,m,t=0,ans=0,maxn=-1;
        vis= new int[50002];
        num= new int[50002];
        dis= new int[50002];
        from= new int[50002];
        to= new int[100004];
        net= new int[100004];
        cap= new int[100004];
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        for(int i=1; i<=m; i++)//构造地图
        {
            int u,v;
            u=sc.nextInt();
            v=sc.nextInt();
            add(u,v);
            add(v,u);
        }
        spfa(1,n);//寻找最短路
        for(int i=2; i<=n; ++i)
        {
            if(dis[i]>maxn)
            {
                maxn=dis[i];
                t=i;
                ans=1;
            }
            else if(dis[i]==maxn) ans++;
        }
        System.out.println(t+" "+dis[t]+" "+ans);
    }
    static void add(int u,int v)
    {
        int w=1;
        to[++tot]=v;
        net[tot]=from[u];
        cap[tot]=w;
        from[u]=tot;
    }
    static boolean spfa(int s,int n)
    {
        Arrays.fill(dis,n);
        que.add(s);
        dis[s]=0;
        vis[s]=1;
        num[s]++;
        while(!que.isEmpty())
        {
            int now=(int)que.poll();
            vis[now]=0;
            for(int i=from[now]; i!=0; i=net[i])
                if(dis[to[i]]>dis[now]+cap[i])
                {
                    dis[to[i]]=dis[now]+cap[i];
                    if(vis[to[i]]==0)
                    {
                        vis[to[i]]=1;
                        que.add(to[i]);
                        if(++num[to[i]]>n)   return false;
                    }
                }
        }
        return true;
    }
}
