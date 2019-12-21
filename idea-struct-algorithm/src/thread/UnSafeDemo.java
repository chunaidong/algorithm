package thread;

/**
 * 非线程安全的demo
 */
public class UnSafeDemo implements Runnable{

    private int count;

    public static void main(String[] args) {
        UnSafeDemo instance = new UnSafeDemo();
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()){
        }
        System.out.println(instance.count);
    }


    @Override
    public void run() {
        for(int i = 0; i < 100000; i++){
            count++;
        }
    }
}
