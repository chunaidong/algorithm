package thread;

public class SafeObjectClass implements Runnable {

    private int count;

    public static void main(String[] args) {
        SafeObjectClass safeObjectClass = new SafeObjectClass();
        Thread t1 = new Thread(safeObjectClass);
        Thread t2 = new Thread(safeObjectClass);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()){
        }
        System.out.println(safeObjectClass.count);
    }
    @Override
    public void run() {
       //同步方法
        method();
        //同步代码块
       /* synchronized (this){
            for(int i = 0 ; i < 100000 ; i++){
                count ++;
            }
        }*/
    }

    /**
     * 同步方法
     */
    private synchronized void method(){
        for(int i = 0 ; i < 100000 ; i++){
            count ++;
        }
    }

}
