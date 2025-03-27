package Midterm.Inheritance.AccountsReceivable;

public class Payment extends Invoice{
    private double amountPaid;
    private String paymentDate;
    private String paymentMethod;
    private String checkNumber;
    private String checkType;

    public Payment(String invoiceNumber, String purchaseDate, String customerName, double amount, double amountPaid ,String paymentDate, String paymentMethod){
        super(invoiceNumber, purchaseDate, customerName, amountPaid);
        this.amountPaid = amountPaid;
        this.paymentDate = paymentDate; 
        this.paymentMethod = paymentMethod;
        this.checkNumber = "";
        this.checkType = "";
    }    

    public Payment(String invoiceNumber, String purchaseDate, String customerName, double amount, double amountPaid ,String paymentDate, String paymentMethod, String checkNumber, String checkType){
        super(invoiceNumber, purchaseDate, customerName, amountPaid);
        this.amountPaid = amountPaid;
        this.paymentDate = paymentDate; 
        this.paymentMethod = paymentMethod;
        this.checkNumber = checkNumber;
        this.checkType = checkType;
    }

    public void displayPaymentDetails(){
        displayInvoiceDetails();
        System.out.println("Amount Paid: " + amountPaid);
        System.out.println("Payment Date: " + paymentDate);
        System.out.println("Payment Method: " + paymentMethod);

        if(paymentMethod.equalsIgnoreCase("Check")){
            System.out.println("Check Type: " + checkType);
            System.out.println("Check Number: " + checkNumber);
        }

    }



}
