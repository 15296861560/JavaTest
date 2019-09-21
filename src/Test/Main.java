package Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main{


    public static void main(String[] args){
        LinkedList linkedList=new LinkedList();
        linkedList.add("aaa");
        linkedList.add("bbb");
        linkedList.add("ccc");
        System.out.println(linkedList);
        linkedList.poll();
        linkedList.poll();
        linkedList.poll();
        System.out.println(linkedList.isEmpty());
    }

}
