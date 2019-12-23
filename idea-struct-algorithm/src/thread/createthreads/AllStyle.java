package thread.createthreads;

public class AllStyle extends Thread {

    public AllStyle(Runnable runnable) {
        super(runnable);
    }

    @Override
    public void run() {
        System.out.println("I am from Override");
    }

    public static void main(String[] args) {
        AllStyle allStyle = new AllStyle(()->{
            System.out.println("I am from runnable");
        });
        allStyle.start();
    }

}
