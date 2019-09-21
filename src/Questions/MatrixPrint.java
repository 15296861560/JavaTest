package Questions;

import java.util.ArrayList;

public class MatrixPrint {
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList arr=new ArrayList();
        int a=matrix.length-1,aa=0;
        int b=matrix[0].length-1,bb=0;
        boolean flag_a=true;
        boolean flag_b=true;
        boolean flag=true;
        int i = 0,j=0;
        while (flag){
            arr.add(matrix[j][i]);
            //指针移动
            if(flag_a){
                if (flag_b){
                    i++;
                    if (i==a){//判断是否“撞墙”,若撞墙则改变行为
                        flag_a=false;
                        bb+=1;
                    }
                }
                else {
                    i--;
                    if (i==aa){//判断是否“撞墙”,若撞墙则改变行为
                        flag_a=false;
                        b-=1;
                    }
                }
            }
            else {
                if (flag_b){
                    j++;
                    if (j==b){//判断是否“撞墙”,若撞墙则改变行为
                        flag_b=false;
                        flag_a=true;
                        a-=1;
                    }
                }
                else {
                    j--;
                    if (j==bb){//判断是否“撞墙”,若撞墙则改变行为
                        flag_a=true;
                        flag_b=true;
                        aa+=1;
                    }
                }
                if(aa>a||bb>b){//到达终点
                    flag=false;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
//        int[][]test=new int[5][5];
//        int x=1;
//        for (int i = 0; i <test.length ; i++) {
//            for (int j = 0; j <test[0].length ; j++) {
//                test[i][j]=x;
//                x++;
//            }
//        }
        int[][] test={{1},{2},{3},{4},{5}};
        System.out.println(printMatrix(test));

    }
}
