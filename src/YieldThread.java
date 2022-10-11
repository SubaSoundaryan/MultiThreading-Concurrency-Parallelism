public class YieldThread implements Runnable
{

//    Yield() method in Java | When a currently executing thread goes
//    to the runnable state from running state, this process is called yield in Java.
//
//    When running state receives higher priority
//    thread than the thread that is currently running,
//    thread scheduler sends the currently running thread back to the runnable state
//    and selects another thread of equal or higher priority to start its execution.
    public void run()
    {
        System.out.println(Thread.currentThread());
        Thread.yield(); // Calling yield() method on current thread to move back into the runnable state from running state.

        System.out.println(Thread.currentThread());
    }
    public static void main(String[] args)
    {
        YieldThread yieldThread1 = new YieldThread();
        Thread t1 = new Thread(yieldThread1, "First Child Thread");

        YieldThread yieldThread2 = new YieldThread();
        Thread t2 = new Thread(yieldThread2, "Second Child Thread");
        t2.setPriority(10);

        t1.start();
        System.out.println("before second thread start");
        t2.start();
    }
}
