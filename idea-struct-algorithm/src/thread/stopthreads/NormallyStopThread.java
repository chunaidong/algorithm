package thread.stopthreads;

import java.util.concurrent.TimeUnit;

/**
 * 终止线程
 */
public class NormallyStopThread implements Runnable {

    private int num;

    private boolean cancel;

    @Override
    public void run() {
       /* while (num < Integer.MAX_VALUE / 2 || !Thread.currentThread().isInterrupted()){
            if(num % 10000 == 0){
                System.out.println("I am 10000 的 倍数 ：" + num);
            }
            num++;
        }*/
       while (!cancel){
           System.out.println(num);
           try {
               Thread.sleep(500);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
        System.out.println("ddddddddd");
    }

    public static void main(String[] args) throws InterruptedException {
        NormallyStopThread normallyStopThread = new NormallyStopThread();
        Thread thread = new Thread(normallyStopThread);
        thread.start();
        Thread.sleep(1000);
        normallyStopThread.num = 100;
        normallyStopThread.cancel = true;
        //thread.interrupt();
        Producer producer = new Producer();
        BB bb = new BB();
    }

    static class BB{

    }

}

class Producer {

}
