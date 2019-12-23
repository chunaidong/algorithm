package thread.createthreads;

public class ThreadStyle extends Thread {

    public static void main(String[] args) {
        ThreadStyle threadStyle = new ThreadStyle();
        threadStyle.start();
    }

    @Override
    public void run() {
        System.out.println("this is extends Thread to start create a thread");
    }
}
