package Competition;


import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;

/*        题目描述
        单词接龙是一个与我们经常玩的成语接龙相类似的游戏，现在我们已知一组单词，且给定一个开头的字母，
        要求出以这个字母开头的最长的“龙”（每个单词都最多在“龙”中出现两次），在两个单词相连时，
        其重合部分合为一部分，例如beast和astonish，如果接成一条龙则变为beastonish，
        另外相邻的两部分不能存在包含关系，例如at和atide间不能相连。

        输入描述:
        输入的第一行为一个单独的整数n(n ≤ 20)表示单词数，以下n行每行有一个单词，输入的最后一行为一个单个字符，表示“龙”开头的字母。你可以假定以此字母开头的“龙”一定存在.
        输出描述:
        只需输出以此字母开头的最长的“龙”的长度*/
public class Main3 {
    static int ans=0;     //ans是最大长度
    static int[][] len=new int[20][20];
    static int[] used=new int[20];     //保存单词的使用次数，同时也做占位标志
    static int[] wordslen=new int[20];     //单词长度

    static int calc(String a,String b) {
        int lena=a.length(),lenb=b.length();
        int len=min(lena,lenb);
        for(int l=1;l<=len-1;l++) { //len-1不能包含 ,且重叠部分尽量小 从小到大枚举
            String tem1=a.substring(lena-l,lena);
            String tem2=b.substring(0,l);
            if(a.substring(lena-l,lena).equals(b.substring(0,l)))
                return l;
            }
        return 0;
        }

    static void dfs(int u,int l,int n) {
        ans=max(ans,l);
        for(int v=0;v<n;v++) {
            if (used[v] < 2 && len[u][v] != 0) {
                used[v]++;
                dfs(v, l + wordslen[v] - len[u][v], n);
                used[v]--;
            }
        }
        }
    public static void main(String[] args) {
        String[] s=new String[20];//保存读入的单词
        int n;
        int i;
        String ch;//开头字母
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();//输入单词数
        for (i = 0; i <n ; i++) {//输入单词
            s[i]=sc.next();
            wordslen[i]=s[i].length();
        }
        ch=sc.next();//开头
        char c=ch.charAt(0);
        for(i=0;i<n;i++)
            for(int j=0;j<n;j++) //自己可能与自己重叠
            len[i][j]=calc(s[i],s[j]);
        for(i=0;i<n;i++) if(s[i].charAt(0)==c) {
            used[i]++; dfs(i,wordslen[i],n); used[i]--;
            }
        System.out.println(ans);


    }
}
