package utils;

import java.util.concurrent.TimeUnit;


/**
 * A Timer instance count the nano seconds that passed between its creation and the stop method call.
 * you can call the stop method on multiple occasions, but each call override the last time registered.
 */
public class Timer {

    private long start;
    private long stop;

    public static Timer start() {
        Timer instance = new Timer();
        instance.start = System.nanoTime();
        return instance;
    }

    public void stop() {
        this.stop = System.nanoTime();
    }

    public long getElapsedTimeInMillisec() {
        return TimeUnit.NANOSECONDS.toMillis(this.stop - this.start);
    }

}
