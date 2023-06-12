package fizzBuzz;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FizzBuzz {
    private int n;
    public BlockingQueue<String> queue;
    private volatile int currentNumber;

    public FizzBuzz(int n) {
        this.n = n;
        this.queue = new LinkedBlockingQueue<>();
        this.currentNumber = 1;
    }

    public void fizz() throws InterruptedException {
        while (true) {
            int number = currentNumber;
            if(number > n) break;

            if(number % 3 == 0 && number % 5 != 0) {
                queue.put("fizz");
                currentNumber++;
            }
        }
    }

    public void buzz() throws InterruptedException {
        while (true) {
            int number = currentNumber;
            if(number > n) break;

            if(number % 3 != 0 && number % 5 == 0) {
                queue.put("buzz");
                currentNumber++;
            }
        }
    }

    public void fizzbuzz() throws InterruptedException {
        while (true) {
            int number = currentNumber;
            if(number > n) break;

            if(number % 3 == 0 && number % 5 == 0) {
                queue.put("fizzbuzz");
                currentNumber++;
            }
        }
    }

    public void number() throws InterruptedException {
        while (true) {
            int number = currentNumber;
            if(number > n) break;

            if(number % 3 != 0 && number % 5 != 0) {
                queue.put(String.valueOf(number));
                currentNumber++;
            }
        }
    }
}
