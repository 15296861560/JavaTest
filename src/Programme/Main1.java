package Programme;
import java.util.Scanner;
public class Main1{


    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int length=0;
        length=sc.nextInt();
        int[] array=new int[length];
        int result=array[0],tem1=0;
        for(int i=0;i<length;i++){
            array[i]=sc.nextInt();
            tem1=tem1+array[i];//更新临时结果
            if(array[i]>0){//如果array[j]是正数
                if(tem1>result){//如果临时变量1大于结果
                    result=tem1;//更新结果
                }else if(tem1<0){//否则,如果之前的和小于0，则将临时变量的值设为array[j]
                    tem1=array[i];
                }
            }
        }
        System.out.println(result);
    }
}