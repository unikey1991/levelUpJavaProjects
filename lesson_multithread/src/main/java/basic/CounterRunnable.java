package basic;

/**
 * Created by java on 14.04.2017.
 */
public class CounterRunnable implements Runnable {

    private int initialValue;
    private int step;
    private int maxValue;

    @Override
    public void run() {
        for (int i = initialValue; i < maxValue; i += step) {
            Main.print(Thread.currentThread().getName() + " " + i);

        }
    }

    public CounterRunnable(int initialValue, int step, int maxValue) {
        this.initialValue = initialValue;
        this.step = step;
        this.maxValue = maxValue;
    }
}
