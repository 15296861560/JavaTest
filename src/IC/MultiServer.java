package IC;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {
    public static void main(String[] args) {
        try{
            System.out.println("等待连接");
            ServerSocket serverSocket=new ServerSocket(5500);
            Socket s=null;
            while (true){
                //等待客户端的请求
                s=serverSocket.accept();
                //每次请求都启动一个线程来处理
                new ServerThread(s);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    static  class ServerThread extends Thread{
        private Socket s;
        private DataInputStream dis;
        private DataOutputStream dos;
        //在构造方法中为每个套接字连接输入流和输出流
        public ServerThread(Socket socket)throws IOException{
            super();
            s=socket;
            dis=new DataInputStream(s.getInputStream());
            dos=new DataOutputStream(s.getOutputStream());
            start();//直接在构造函数里启动线程
        }
        //与客户端通信
        public void run(){
            try{
                String str;
                double result,value;
                boolean notEnd=true;
                while (notEnd){
                    str=dis.readUTF();
                    if(!str.equals("bye")){
                        value=Double.parseDouble(str);
                        System.out.println("接收到的值为："+value);
                        result=value*value;
                        str=Double.toString(result);
                        dos.writeUTF(str);
                        dos.flush();
                        System.out.println("平方值"+str+"已经发送");
                    }else {
                        notEnd=false;
                        dos.writeUTF("bye");
                        dos.flush();
                    }
                }
                dis.close();
                dos.close();
                s.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
