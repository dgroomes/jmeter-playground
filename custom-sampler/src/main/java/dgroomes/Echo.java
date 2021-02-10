package dgroomes;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * Echo a message.
 * <p>
 * This is a toy class. It is used as the object-under-test in a JMeter load test.
 */
public class Echo {

    public static final long SLEEP_MILLIS = Duration.of(1, ChronoUnit.SECONDS).toMillis();

    public void slowEcho(String msg) throws InterruptedException {
        Thread.sleep(SLEEP_MILLIS);
        System.out.printf("...%s!\n", msg);
    }
}
