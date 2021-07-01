package MultithreadHW;

public class ThreadHomework {
    public static void main(String[] args) throws InterruptedException {
        firstMethod();
        secondMethod();
    }

    public static void firstMethod() {
        int size = 10_000_000;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время выполнения одним потоком " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    public static void secondMethod() throws InterruptedException {
        int size = 10_000_000;
        final int HALF = size / 2;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        MyThread leftArray =  new MyThread(arr, 0, HALF);
        MyThread rightArray = new MyThread(arr, HALF, arr.length);
        // Создаем два массива для левой и правой части исходного
        // Копируем в них значения из большого массива
        Thread thread1 = new Thread(leftArray);
        Thread thread2 = new Thread(rightArray);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        // Запускает два потока и параллельно просчитываем каждый малый массив
        // ...
        // Склеиваем малые массивы обратно в один большой
        // ...
        System.out.println("Время выполнения задания 2 потоками"  + (leftArray.getOneThreadTime() + rightArray.getOneThreadTime()) + " ms.");
    }


}
