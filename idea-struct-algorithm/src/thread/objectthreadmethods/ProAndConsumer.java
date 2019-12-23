package thread.objectthreadmethods;

public class ProAndConsumer {
}


class Goods{
    private static final int MAX_SIZE = 10;
    private int count = 0;

    /**
     * 生产
     */
    public synchronized void make() throws InterruptedException {
        if(count < MAX_SIZE){
            count++;
            notifyAll();
        }else{
            wait();
        }
    }

    public synchronized void take() throws InterruptedException {
        if(count <= 0){
            wait();
        }else{
            count--;
            notifyAll();
        }

    }

}

