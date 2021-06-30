package MultithreadHW;

public class MyRunnuableTask implements Runnable {


    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread out: " + i);
        }
    }

}