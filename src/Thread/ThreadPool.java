package Thread;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool implements Runnable{
    private String targetName;
    Random r=new Random();
    public ThreadPool(String targetName){
        this.targetName=targetName;
    }

    @Override
    public void run() {
        int sum=0;
        for (int i=0;i<100;i++){
            sum+=r.nextInt(100);
        }
        System.out.println(Thread.currentThread().getName()+"执行:"+this.targetName+"结果:"+sum);
    }

    public static void main(String[] args) {
        ExecutorService pool= Executors.newFixedThreadPool(2);//创建包含了2个线程的线程池
        for (int i = 0; i <=10 ; i++) {
            ThreadPool t=new ThreadPool("Target"+i);//创建线程任务
            pool.execute(t);//把任务提交到线程池
        }
    }
}
