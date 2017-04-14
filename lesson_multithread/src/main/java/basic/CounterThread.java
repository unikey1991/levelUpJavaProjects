package basic;

/**
 * Created by java on 14.04.2017.
 */
public class CounterThread extends Thread {

    private int initialValue;
    private int step;
    private int maxValue;

    public CounterThread(int initialValue, int step, int maxValue) {
        this.initialValue = initialValue;
        this.step = step;
        this.maxValue = maxValue;
    }

    @Override
    public void run() {
        for (int i = initialValue; i < maxValue; i+=step) {
            System.out.println(Thread.currentThread().getName() +
                    " " + i );
        }
    }
}
