package IC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

public class URLReader {
    public static void main(String[] args) {
        try {
            //通过URL类建立远程连接，并获取连接内容
            URL url=new URL("http://www.cqu.edu.cn/");
            //一些获取URL属性的方法
            System.out.println(
            "协议="+url.getProtocol()+"\n"+//协议
                     "主机名="+url.getHost()+"\n"+//主机名
                    "文件名="+url.getFile()+"\n"+//文件名
                    "端口="+url.getPort()+"\n"+//端口
                    "文件内部的一个引用="+url.getRef()+"\n"//文件内部的一个引用
            );
            //建立输入流
            BufferedReader in=new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine;
            //获取输入信息
            while ((inputLine=in.readLine())!=null)
                System.out.println(inputLine);
            in.close();
            //通过URLConnection获取响应Header信息
            URLConnection conn=url.openConnection();
            conn.connect();
            System.out.println(
            "获取到的响应长度"+conn.getContentLength()+"\n"+//获取到的响应长度
                    "获取到的响应类型"+conn.getContentType()//获取到的响应类型
            );
            //定义bufferedReader输入流来读取URL的响应
            in=new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            String ressult=null;
            while ((line=in.readLine())!=null)
                ressult+=line;
            System.out.println(ressult);
            in.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
