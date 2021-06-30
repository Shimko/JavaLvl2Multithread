package MultithreadHW;

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnuableTask());
        Thread thread2 = new Thread(new MyRunnuableTask());
        thread1.start();
        thread2.start();
    }

}
