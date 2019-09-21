package Programme;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String condition=sc.next();
        condition=condition.replace("\\*","*");
//        String[] ss=condition.split("\\*");
        String test1=sc.next();
        char[] test2=test1.toCharArray();
        int length=test1.length();
        int l=length;
        boolean flag=true;
        Pattern p=null;
        Matcher m=null;
        p=Pattern.compile(condition);
        for (int i = 0; i <length ; i++,l--) {
            for (int j = 1; j <=l; j++) {
                test1=new String(test2,i,j);
                m=p.matcher(test1);
                if (m.matches()){
//                if (ss.length==2) {
//                    if (test1.startsWith(ss[0]) && test1.endsWith(ss[1])) {
                        System.out.println(i + " " + test1.length());
                        flag = false;
                    }


            }

        }
//        if (flag) System.out.println(-1+" "+0);
        if (flag) System.out.println(condition);
    }
}
