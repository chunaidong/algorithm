package thread.objectthreadmethods;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SleepInterrupted implements Runnable{

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SleepInterrupted());
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }

    @Override
    public void run() {
        for (int i = 0 ; i < 10 ; i++){
            System.out.println(new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("hhhhhhhhhhhhhhhhhhhhhh");
                e.printStackTrace();
            }
        }
    }
}
