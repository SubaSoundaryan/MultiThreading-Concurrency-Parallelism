package UdemyThreadClass;

public class RaceConditionDemo {

    public static void main(String[] args) {
        BankAccount task = new BankAccount();
        task.setBalance(100);

        Thread john = new Thread(task);
        Thread anita = new Thread(task);
        john.setName("John");
        anita.setName("Anita");
        john.start();
        anita.start();

        System.out.println("Ended");
    }
}

class BankAccount implements Runnable {
    private int balance;
    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void run() {
        makeWithdrawal(75);
        if (balance < 0) {
            System.out.println("Money overdrawn!!!");
        }
    }

    //without synchronized key, method will be called multiple times at the same time
    synchronized private void makeWithdrawal(int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " is about to withdraw ... current balance is " + balance );
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " has withdrawn " + amount + " bucks");
        } else {
            System.out.println("Sorry, not enough balance for " + Thread.currentThread().getName());
        }

        System.out.println("Balance is " + balance );
    }


}