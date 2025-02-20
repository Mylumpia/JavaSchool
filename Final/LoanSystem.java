package Final;

class LoanTransaction extends Thread {
    private String customerName;
    private double loanAmount;

    public LoanTransaction(String customerName, double loanAmount){
        this.customerName = customerName;
        this.loanAmount = loanAmount;
    }

    public void run(){
        try{
            System.out.println("Processing loan for: " + customerName + " with amount:: $" + loanAmount);
            Thread.sleep(2000);
            System.out.println("Loan approved for: " + customerName + " with amount: $" + loanAmount);
        }catch (InterruptedException e){
            System.out.println("Transaction interrupted for " + customerName);

        }
    }


    
}


public class LoanSystem {
    public static void main(String[] args) {
        LoanTransaction transaction1 = new LoanTransaction("Rouel", 5000);
        LoanTransaction transaction2 = new LoanTransaction("Goldie", 10000);
        LoanTransaction transaction3 = new LoanTransaction("Neo", 15000);

        transaction1.start();
        transaction2.start();
        transaction3.start();
    }


    

}
