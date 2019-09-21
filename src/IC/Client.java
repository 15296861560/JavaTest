package IC;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            //连接到本机，端口号5500
            Socket s=new Socket("localhost",5500);
            //将数据输入流连接到socket上
            DataInputStream dis=new DataInputStream(s.getInputStream());
            //将数据输出流连接到socket上
            DataOutputStream dos=new DataOutputStream(s.getOutputStream());
            System.out.println("输入待求平方值，输入bye结束");
            String outStr,inStr;
            boolean notEnd=true;
            BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
            //反复读用户的数据并计算
            while (notEnd){
                outStr=buf.readLine();
                dos.writeUTF(outStr);
                dos.flush();
                inStr=dis.readUTF();
                if(!inStr.equals("bye"))
                    System.out.println("返回结果："+inStr);
                else
                    notEnd=false;
            }
            dis.close();
            dos.close();
            s.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
