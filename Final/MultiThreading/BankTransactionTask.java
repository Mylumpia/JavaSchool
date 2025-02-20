package Final.MultiThreading;

public class BankTransactionTask implements Runnable{
    private BankAccount account;
    private double amount;
    private boolean idDeposit;

    public BankTransactionTask(BankAccount account, double amount, boolean idDeposit){
        this.account = account;
        this.amount = amount;
        this.idDeposit = idDeposit;
    }
    
    @Override
    public void run(){
        if (idDeposit){
            account.deposit(amount);
        }else {
            account.withdraw(amount);
        }
    }


}
