package Competition;

import java.util.*;


/*        题目描述
        农夫约翰的N头奶牛（方便编号为1..N）正在形成一条线。这条线从没有奶牛开始然后，随着时间的推移，
        奶牛一个接一个地连接在左侧或右侧的线。每隔一段时间，线路左侧或右侧的一些母牛都会离开这条线，
        在他们最喜欢的牧场放牧。FJ难以跟踪生产线上的所有奶牛。请帮帮他。
        奶牛以数字顺序1..N进入线，一旦母牛离开线，她就不再重新进入。您的程序将获得S（1 <= S <= 100,000）输入规范;
        每个出现在一行上，并且是两种类型之一：
        *一头母牛进入该行（一个参数指示是左侧还是右侧）。
        * K奶牛离开左侧或右侧的线（提供的参数定义了奶牛的数量和哪一侧）。
        输入行从不请求无法执行的操作。
        处理完所有输入行后，程序应按从左到右的顺序打印行中的奶牛。在输入规范的末尾，最后一行保证不为空。
        输入描述：
        *第1行：单个整数：S
        *行2..S + 1：行i + 1包含以下四种格式之一的规格i：
        * AL  - 奶牛到达行的左侧
        * AR  - 奶牛到达线路右侧
        * DLK  -  K奶牛离开线路的左侧
        * DRK  -  K奶牛离开线路的右侧
        输出描述：
        *第1行...... ??：从左到右依次打印行中的奶牛数量，每行一个数字。*/
public class Main6 {

    static int n;
    static int x;
    static int curr=0;
    static Deque dq=new LinkedList();
    static String str;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        for(int i=1;i<=n;++i){
            str=sc.next();
            if(str.charAt(0)=='A'){
                str=sc.next();
                if(str.charAt(0)=='L') dq.addFirst(++curr);
                else dq.addLast(++curr);
            }
            else{
                str=sc.next();
                x=sc.nextInt();
                if(str.charAt(0)=='L') for(int j=1;j<=x;++j) dq.pollFirst();
                else for(int j=1;j<=x;++j) dq.pollLast();
            }
        }
        while(!dq.isEmpty()){
            x=(int)dq.getFirst();
            System.out.println(x);
            dq.pop();
        }

    }

}
