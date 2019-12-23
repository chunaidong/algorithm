package thread.createthreads;

public class RunableStyle implements Runnable {

    public static void main(String[] args) {
        Thread thread = new Thread(new RunableStyle());
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("this is implements runable to start create a thread");
    }
}
