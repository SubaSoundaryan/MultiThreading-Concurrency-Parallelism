public class DaemonThread implements Runnable
{
    /*Daemon thread in Java is a service thread that provides some services to other threads or objects.

    It executes continuously without any interruption to provide services to one or more user threads.*/

    public void run()
    {
// Checking whether a thread is Daemon or not
        if(Thread.currentThread().isDaemon()) {
            System.out.println(Thread.currentThread() + " is a daemon thread");
        }
        else {
            System.out.println(Thread.currentThread() + " is a user (normal) thread");
        }
    }
    public static void main(String[] args)
    {
        DaemonThread daemonThread = new DaemonThread();
        Thread t1 = new Thread(daemonThread, "Thread 1");
        t1.setDaemon(true); // Set to daemon.

        Thread t2 = new Thread(daemonThread, "Thread 2");
        t1.start(); // Execution starts.
        t2.start();

        System.out.println("Main thread ending");
    }
}