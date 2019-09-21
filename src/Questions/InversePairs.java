package Questions;

/*数组中的逆序对
        在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,
        求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
        输入描述
        题目保证输入的数组中没有的相同的数字

        数据范围：

        对于%50的数据,size<=10^4

        对于%75的数据,size<=10^5

        对于%100的数据,size<=2*10^5

        示例1
        输入
        1,2,3,4,5,6,7,0
        输出
        7*/
public class InversePairs {
    public static int InversePairs(int [] array) {
        int[] flag=array;
        int num=0;
        for (int i = 1; i <array.length ; i++) {
            for (int j = 0; j <i ; j++) {
                if(array[j]>array[i])num++;
            }
        }
        return num%1000000007;

    }

    public static void main(String[] args) {
        int[] test={1,2,3,4,5,6,7,0};
        System.out.println(InversePairs(test));
    }
}
