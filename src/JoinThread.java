/*Java Thread Join | The join() method in Java is used when a thread needs to wait for another
thread to finish its execution.

In other words, this method is used to wait the current thread until the thread that has
called the join() method completes its execution.

The join() method is an instance method and it is always called by an object of Thread class.
The general syntax to call join() method in java program is as follows:

ThreadName.join(); // ThreadName is reference variable of Thread class.*/
public class JoinThread implements Runnable
{
    public void run()
    {
        System.out.println("Child thread is running");
        for(int i = 1; i <= 4; i++)
        {
            System.out.println("I: " +i);
        }
        System.out.println("Child thread is ending");
    }
    public static void main(String[] args)
    {
        JoinThread joinThread = new JoinThread();
        Thread t = new Thread(joinThread);
        t.start(); // thread t is ready to run.

// join() method is called inside the main thread (current thread) through Thread t.
        try
        {
            t.join(); // Wait for thread t to end.
        }
        catch(InterruptedException ie)
        {
            ie.printStackTrace();
        }
        System.out.println("Main Thread is ending");
    }
}

