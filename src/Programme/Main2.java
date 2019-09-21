package Programme;

import java.util.Scanner;
public class Main2{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int side=sc.nextInt();
        int[][] matrix=new int [side][side];
        //预存输入的方阵
        for(int i=0;i<side;i++){
            for(int j=0;j<side;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        int distance=0;
        int mindistance=side*side;
        boolean flag=false;
        //计算每个空地到房子的距离之和
        for(int i=0;i<side;i++){
            for(int j=0;j<side;j++){
                if(matrix[i][j]==0){//空地
                    for(int x=0;x<side;x++){
                        for(int y=0;y<side;y++){
                            if (matrix[x][y]==1) {//房子
                                distance = distance + Math.abs(x - i) + Math.abs(y - j);//求该位置的最小距离
                                flag=true;
                            }
                        }
                    }
                    if(distance<mindistance)//如果该位置的最小距离小于总的最小距离则更新总的最小距离
                        mindistance=distance;
                    distance=0;
                }
            }

        }
        if (flag)
        System.out.println(mindistance);
        else
            System.out.println(-1);
    }

}
