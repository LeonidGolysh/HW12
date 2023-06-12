package timeInfo;

import java.time.Duration;
import java.time.Instant;

public class TimeInfo {
    public static void main(String[] args) {
        Thread timeThread = new Thread(() -> {
            Instant startTime = Instant.now();

            while(true) {
                Instant currentTime = Instant.now();
                Duration elapsedTime = Duration.between(startTime, currentTime);

                System.out.println("Пройшло: " + elapsedTime.getSeconds() + " секунд");

                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread messageThread = new Thread(() -> {
            while(true) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Минуло 5 секунд");
            }
        });

        timeThread.start();
        messageThread.start();
    }
}