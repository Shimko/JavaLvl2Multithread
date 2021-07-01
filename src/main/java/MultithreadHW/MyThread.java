package MultithreadHW;

public class MyThread extends Thread {
    private float[] a;
    private int start;
    private int end;
    long startTime = System.currentTimeMillis();
    long oneThreadTime;


    public MyThread(float[] a, int start, int end) {
        this.a = a;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            a[i] = (float) (a[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        oneThreadTime = System.currentTimeMillis() - startTime;
    }

    public long getOneThreadTime() {
        return oneThreadTime;
    }
}
