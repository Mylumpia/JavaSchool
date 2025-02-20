package Final.MultiThreading;

public class BankTransactionSimulation {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0);

        Thread t1 = new Thread(new BankTransactionTask(account, 500.0, true), "Customer 1");
        Thread t2 = new Thread(new BankTransactionTask(account, 200.0, false), "Customer 2");
        Thread t3 = new Thread(new BankTransactionTask(account, 300.0, true), "Customer 3");
        Thread t4 = new Thread(new BankTransactionTask(account, 800.0, false), "Customer 4");
        Thread t5 = new Thread(new BankTransactionTask(account, 100.0, true), "Customer 5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        try{
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Final balance: " + account.getBalance());

    }
    
}
