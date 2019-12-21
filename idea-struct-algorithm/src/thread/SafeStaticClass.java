package thread;

public class SafeStaticClass implements Runnable {

    private int count;

    public static void main(String[] args) {
        SafeStaticClass safeStaticClass = new SafeStaticClass();
        Thread t1 = new Thread(safeStaticClass);
        Thread t2 = new Thread(safeStaticClass);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()){

        }
        System.out.println(safeStaticClass.count);
    }

    @Override
    public void run() {
       // method();
        synchronized (SafeObjectClass.class){
            for(int i = 0 ; i< 100000 ; i ++){
                count++;
            }
        }
    }

    /**
     * 类方法锁
     */
    public static synchronized void method(){
        System.out.println("当前线程："+Thread.currentThread().getName()+" 进入");
        //TODO 做一些业务操作
        System.out.println("当前线程："+Thread.currentThread().getName()+" 结束");
    }

}
