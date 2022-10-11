public class SynchronizedMethod {
        synchronized void printSynchronizedMethod(int n) // Here, method is synchronized.
        {
            for(int i = 1; i <= 5; i++)
            {
                System.out.println(n * i);
                try
                {
                    Thread.sleep(400);
                }
                catch(InterruptedException ie)
                {
                    System.out.println(ie);
                }
            }}
    }
    class ThreadOne extends Thread
    {
        SynchronizedMethod t; // Declaration of variable t of class type SynchronizedMethod.

        // Declare one parameterized constructor and pass variable t as a parameter.
        ThreadOne(SynchronizedMethod t)
        {
            this.t = t;
        }
        public void run()
        {
            t.printSynchronizedMethod(2);
        }
    }
     class ThreadTwo extends Thread
    {
        SynchronizedMethod t;
        ThreadTwo(SynchronizedMethod t)
        {
            this.t = t;
        }
        public void run()
        {
            t.printSynchronizedMethod(10);
        }
    }
     class SynchronizedMethodMainClass {
        public static void main(String[] args) {
// Create an object of class SynchronizedMethod.
            SynchronizedMethod obj = new SynchronizedMethod();
            ThreadOne t1 = new ThreadOne(obj);
            ThreadTwo t2 = new ThreadTwo(obj);
            t1.start();
            t2.start();
        }
    }
