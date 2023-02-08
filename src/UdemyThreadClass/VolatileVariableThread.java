package UdemyThreadClass;

import java.util.concurrent.TimeUnit;

/*
Using volatile is yet another way (like synchronized, atomic wrapper) of making class thread-safe.
 Thread-safe means that a method or class instance can be used by multiple threads at the same time
 without any problem. Consider the below example.

Ex:
class SharedObj
{
    // Changes made to sharedVar in one thread
    // may not immediately reflect in other thread
    static int sharedVar = 6;
}

Suppose that two threads are working on SharedObj.
If two threads run on different processors each thread may have its own local copy of sharedVariable.
If one thread modifies its value the change might not reflect in the original one in the main memory instantly.
This depends on the write policy of cache. Now the other thread is not aware of the modified value which
leads to data inconsistency.*/
public class VolatileVariableThread {
    private static volatile boolean stop;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            int i = 0;
            public void run() {
                while(!stop) { System.out.println("In while ..." + i);
                i++;
                }
            }
        }).start();

        TimeUnit.SECONDS.sleep(1);
        stop = true;
    }
}

