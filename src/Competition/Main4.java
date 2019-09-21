package Competition;


import java.util.Arrays;
import java.util.Scanner;

/*        题目描述
        一个旅行家想驾驶汽车以最少的费用从一个城市到另一个城市（假设出发时油箱是空的）。给定两个城市之间的距离D1、
        汽车油箱的容量C（以升为单位）、每升汽油能行驶的距离D2、出发点每升汽油价格P和沿途油站数N（N可以为零），
        油站i离出发点的距离Di、每升汽油价格Pi（i=1，2，…，N）。
        计算结果四舍五入至小数点后两位。如果无法到达目的地，则输出“No Solution”。
        输入描述:
        第一行：D1，C，D2，P，N。

        接下来有N行。

        第i+1行，两个数字，油站i离出发点的距离Di和每升汽油价格Pi。

        输出描述:
        所需最小费用，计算结果四舍五入至小数点后两位。如果无法到达目的地，则输出“No Solution”。*/
public class Main4 {
    public static void main(String[] args) {
        double d1,c,d2,p;//总距离d1，油箱容量c，每升汽油能行驶的距离d2,发点每升汽油价格p
        int n;//油站数
        Scanner sc = new Scanner(System.in);
        d1=sc.nextDouble();
        c=sc.nextDouble();
        d2=sc.nextDouble();
        p=sc.nextDouble();
        n=sc.nextInt();
        double[]di=new double[n+1];//油站离出发点的距离
        double[]pi=new double[n+1];//油站每升汽油价格
        for (int i = 1; i <=n ; i++) {
            di[i]=sc.nextDouble();
            pi[i]=sc.nextDouble();
        }
        double maxDistance=c*d2;//每次汽车能行驶的最大距离
        for (int i = 1; i <=n ; i++) {//检测能否到达每一站
            if ((di[i]-di[i-1])>maxDistance){
                System.out.println("No Solution");
                return;
            }
        }
        double Move=0;
        double sum=0;
        double minp=p;
        double distance;
        int pass=0;
        di[0]=0;
        pi[0]=p;
        double rest=0;
        while (pass<=n) {
            int i=pass;
            int j=0;
            distance=d1-di[pass];
            boolean flag=true;//用于检测后面是否有油价比当前站点低的站点
            for (i = pass; i <= n; i++) {
                Move =di[i]-di[pass];//行驶距离
                if (Move >maxDistance) break;//当行驶距离大于最大行驶距离时记录可抵达站点为i-1
            }
            for (j=pass+1; j<i; j++) {//可抵达站点和当前站点之间
                if (pi[j] <= minp ){//获取可抵达站点中油价最低的那个站点
                    minp=pi[j];
                    flag=false;//表示后面有油价比当前站点低的站点
                    break;
                }
            }
            if (flag){//后面没有油价比当前站点低时有两种情况，一是可直接抵达终点，二是不可直接抵达终点
                distance=d1-di[pass];//离终点距离
                if (distance>maxDistance){//不可直接抵达终点
                    sum=sum+pi[pass]*(c-rest);//总价格加上当前站点油价乘以装满油箱所需油量
                    rest=c-(di[i-1]-di[pass])/d2 ;//剩余油量
                    pass=i-1;


                }else {//可直接抵达终点
                    sum=sum+pi[pass]*(distance/d2-rest);//总价格加上当前站点油价乘以抵达终点所需油量
                    pass=i;
                }

            }else {

                distance=di[j]-di[pass];//计算当前站点到下一个油价最低的站点的距离
                sum=sum+(distance-rest)/d2*pi[pass];//计算总价格
                pass=j;//将位置移动到价格最低的那个站点
                rest=0;
            }
        }
        //保留两位小数
        System.out.printf("%,.2f",sum);
    }
}
