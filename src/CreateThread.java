public class CreateThread extends Thread
{
    // Override the run method in Runnable.
    public void run()
    {
        System.out.println("New thread running ");
    }
    public static void main(String[] args)
    {
        System.out.println("Main thread running");

// Create an object of MyThread class.
        CreateThread th = new CreateThread();

// Create an object of Thread class and pass the object reference variable th.
        Thread t = new Thread(th);

// Now run thread on the object. For this, call start() method using reference variable t.
        t.start(); // This thread will execute statements inside run() method of MyThread object.
    }
}
