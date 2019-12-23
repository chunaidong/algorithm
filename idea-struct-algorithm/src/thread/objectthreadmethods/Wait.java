package thread.objectthreadmethods;

public class Wait {

    static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(()->{
            System.out.println("Thread 1 tries to get lock");
            synchronized (lock){
                try {
                    Thread.sleep(1000);
                    System.out.println("Thread 1 get the lock");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1 be notified");
            }
        });
        Thread thread2 = new Thread(() ->{
            System.out.println("Thread 2 tries to get lock");
            synchronized (lock){
                lock.notifyAll();
//                lock.notify();
                System.out.println("Thread 2   notify Thread 1");
            }
        });
        Thread thread3 = new Thread(()->{
            System.out.println("Thread 3 tries to get lock");
            synchronized (lock){
                try {
                    Thread.sleep(1000);
                    System.out.println("Thread 3 get the lock");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 3 be notified");
            }
        });
        thread1.start();
        Thread.sleep(500);
        thread3.start();
        Thread.sleep(500);
        thread2.start();
    }

}
