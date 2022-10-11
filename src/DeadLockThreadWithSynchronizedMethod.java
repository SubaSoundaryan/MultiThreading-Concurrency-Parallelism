public class DeadLockThreadWithSynchronizedMethod
{
    void display1(DeadLockThreadWithSynchronizedMethod obj2)
    {
        System.out.println("Thread1 waiting for thread2 to release lock");
        synchronized(obj2) {
            System.out.println("Deadlock occurred");
        }
    }
    void display2(DeadLockThreadWithSynchronizedMethod obj1)
    {
        System.out.println("Thread2 waiting for thread1 to release lock");
        synchronized(obj1){
            System.out.println("Deadlock occurred");
        }
    }
}
class Thread1 extends Thread
{
    DeadLockThreadWithSynchronizedMethod obj1, obj2;
    Thread1(DeadLockThreadWithSynchronizedMethod obj1, DeadLockThreadWithSynchronizedMethod obj2)
    {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }
    public void run()
    {
        synchronized(obj1){
            try {
                Thread.sleep(1000);
            }
            catch(InterruptedException ie) {
                System.out.println(ie);
            }
            obj2.display2(obj2);
        }
    }
}
class Thread2 extends Thread
{
    DeadLockThreadWithSynchronizedMethod obj1, obj2;
    Thread2(DeadLockThreadWithSynchronizedMethod obj1, DeadLockThreadWithSynchronizedMethod obj2)
    {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }
    public void run()
    {
        synchronized(obj2){
            try {
                Thread.sleep(1000);
            }
            catch(InterruptedException ie) {
                System.out.println(ie);
            }
            obj1.display1(obj1);
        }
    }
}
class Deadlock {
    public static void main(String[] args)
    {
        DeadLockThreadWithSynchronizedMethod obj1 = new DeadLockThreadWithSynchronizedMethod();
        DeadLockThreadWithSynchronizedMethod obj2 = new DeadLockThreadWithSynchronizedMethod();

        Thread1 t1 = new Thread1(obj1, obj2);
        Thread2 t2 = new Thread2(obj1, obj2);
        t1.start();
        t2.start();
    }
}