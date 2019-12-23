package thread.objectthreadmethods;

public class 交替奇偶数 {

    public static void main(String[] args) throws InterruptedException {
        Print print = new Print();
        new Thread(print,"偶数").start();
        Thread.sleep(500);
        new Thread(print, "奇数").start();
    }


}

class Print implements Runnable{

    private int count = 0;

    static final Object lock = new Object();

    @Override
    public void run() {
        while (count <= 100){
            synchronized (lock){
                System.out.println(Thread.currentThread().getName()+" : " +count++);
                lock.notify();
                try {
                    if(count <= 100)
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
