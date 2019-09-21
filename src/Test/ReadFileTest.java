package Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

public class ReadFileTest {
    public static void main(String[] args) {
        File file=new File("D:\\Temp\\a.txt");
        try {
            //第一种方法
            FileInputStream fileInputStream=new FileInputStream(file);
            //2.创建一个字节数组用来存放数据；
            byte[] buf = new byte[1024];
            //3.创建一个len用来记录读取的数据长度,并赋初值为0；
            int len = 0;
            //4.使用read()方法把数据读取到buf中去；
            while((len=fileInputStream.read(buf))>=0){
                //5.调用循环把buf的数据写到控制台；
                System.out.write(buf, 0, len);
                System.out.println(buf[2]);
            }
            fileInputStream.close();
            //第二种方法
            FileReader fileReader=new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String s = bufferedReader.readLine();
            while(s!=null)//如果当前行不为空
            {
                System.out.println(s);//打印当前行
                s= bufferedReader.readLine();//读取下一行
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
