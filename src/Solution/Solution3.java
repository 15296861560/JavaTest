package Solution;

import java.util.Arrays;
/*题目描述
        把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，
        输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
        NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。*/
public class Solution3 {
    public static void main(String[] args) {
        int[] test={19,19,19,19,19,19,19,19,19,19,19,19,19,7,7};
        System.out.println(minNumberInRotateArray(test));
    }
    public static int minNumberInRotateArray(int [] array) {
        int length=array.length;
        int mid=length/2;
        if (length==0)return 0;
        int first=array[0];
        if (first<array[array.length-1])return first;
        int min=array[0];
        if (array[mid]>=first){
            int[] array2= Arrays.copyOfRange(array,mid+1,length);
            min=minNumberInRotateArray(array2);
        }else {
            while (array[mid]>=array[mid-1])mid--;
            return array[mid];
        }

//        for (int i = 1; i <array.length ; i++) {
//            if (array[i]<min)min=array[i];
//        }
        return min;
    }
}
