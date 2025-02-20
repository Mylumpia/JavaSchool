package Final;

public class BankAccount {
    private String accountHolder;
    private String accountNumber;
    private double balance;

    public BankAccount(String accountHolder){
        this.accountHolder = accountHolder;
        this.accountNumber = generateAccountNumber();
        this.balance = 0.0;
    }

    public BankAccount(String accountHolder, double initialBalance){
        this.accountHolder = accountHolder;
        this.accountNumber = generateAccountNumber();
        this.balance = initialBalance;
    }

    public BankAccount(String accountHolder, String accountNumber, double balance){
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount){
        if (amount > 0){
            balance += amount;
            System.out.printf("Deposited %.2f.New Balance:%2f%n", amount, balance);
        }else{
            System.err.println("Invalid Deposit amount!");
        }
    }

    public void withdraw(double amount){
        if (amount > 0 && amount <= balance){
            balance -= amount;
            System.out.printf("Withdrew %.2f.New balance:%.2f%n", amount , balance);
        }else{
            System.out.println("Invalid withdraw amount or insufficient funds!");
        }
    }

    public void displayAccountInfo(){
        System.out.printf("Account Holder:%s%nAccount Number:%s%nBalance:%.2f%n", accountHolder,accountNumber,balance);
    }

    private String generateAccountNumber(){
        return "ACC" + (int)(Math.random() * 100000);
    }

}
