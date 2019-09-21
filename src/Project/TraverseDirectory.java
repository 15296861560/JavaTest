package Project;

import java.util.Scanner;
import java.io.File;

public class TraverseDirectory {
    public static void main(String[] args) {
        System.out.println("请输入您需要查看的目录");
        Scanner sc = new Scanner(System.in);
        while (true){
            String s = sc.nextLine();
            if(check(s)){
                Search(s);
                break;
            }
        }
    }
    //检查输入的路径是不是合法的
    public static boolean check(String s){
        File file = new File(s);
        if(file.isFile()){
            System.out.println("您输入的是一个文件，不是一个目录");
        }else if(file.isDirectory()){
            return true;
        }else {
            System.out.println("您输入的路径有误请重新输入");
        }
        return false;
    }
    //遍历目录
    public static void Search(String s ){
        File file = new File(s);
        File[] arr = file.listFiles();
        System.out.println("当前路径下包含的文件有：");
        for(File a:arr){
            if (a.isFile()){//发现文件
                System.out.println(a.getName());
            }
        }
        System.out.println("当前路径下包含的文件夹：");
        for (File a : arr) {
            if (a.isDirectory()) {//发现目录
                System.out.println(a.getName());
            }
        }
    }
}
