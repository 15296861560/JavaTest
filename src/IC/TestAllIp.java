package IC;

import java.net.InetAddress;

public class TestAllIp {
    public static void main(String[] args) {
        String ip="192.168.203.";
        for (int i = 0; i <255 ; i++) {//循环构建待测试的IP地址
            String host=ip+i;
            new ThreadIP(host).start();
        }
    }
    static class ThreadIP extends Thread{
        String ip=null;
        public ThreadIP(String ip){
            super();
            this.ip=ip;
        }
        public void run(){
            super.run();
            try {
                InetAddress ia=InetAddress.getByName(ip);
                boolean bool=ia.isReachable(1500);//判断IP是否正在被使用
                if(bool){
                    System.out.println("主机："+ip+"可用");
                }else {
                    System.out.println("主机："+ip+"不可用");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
