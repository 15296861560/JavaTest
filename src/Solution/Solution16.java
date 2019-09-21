package Solution;


import java.util.ArrayList;

/*题目描述
        输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，
        如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
        则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.*/
public class Solution16 {
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList arr=new ArrayList();
        if (matrix.length==1&&matrix[0].length==1){
            arr.add(matrix[0][0]);
            return arr;
        }
        int a=matrix[0].length-1,aa=0,i=0;//排
        int b=matrix.length-1,bb=0,j=0;//列
        boolean flag_a=true;
        boolean flag_b=true;
        if (a==0)flag_a=false;//只有1列的时候
        boolean flag=true;
        arr.add(matrix[j][i]);
        while (flag){
            //指针移动
            if(flag_a){
                if (flag_b){//右
                    i++;
                    if (i==a){//判断是否“撞墙”,若撞墙则改变行为
                        flag_a=false;
                        bb+=1;
                    }
                }
                else {//上
                    j--;
                    if (j==bb){//判断是否“撞墙”,若撞墙则改变行为
                        flag_b=true;
                        aa+=1;
                    }
                }
            }
            else {
                if (flag_b){//下
                    j++;
                    if (j==b){//判断是否“撞墙”,若撞墙则改变行为
                        flag_b=false;
                        flag_a=false;
                        a-=1;
                    }
                }
                else {//左
                    i--;
                    if (i==aa){//判断是否“撞墙”,若撞墙则改变行为
                        flag_a=true;
                        flag_b=false;
                        b-=1;
                    }
                }
            }
            arr.add(matrix[j][i]);
            if(aa>a||bb>b){//到达终点
                flag=false;
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
        int[][] test={{1,2,3,4,5}};
        System.out.println(printMatrix(test));

    }
}
