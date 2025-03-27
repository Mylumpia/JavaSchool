package Midterm.Inheritance.AccountsReceivable;
import java.util.Scanner;


public class AccountsReceivableMultiplePayment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Invoice Number: ");
        String invoiceNumber = scanner.nextLine();

        System.out.println("Enter Purchase Date (YYYY-MM-DD): ");
        String purchaseDate = scanner.nextLine();

        System.out.println("Enter Customer Name ");
        String customerName = scanner.nextLine();

        System.out.println("Enter Invoice Amount: ");
        double amount = scanner.nextDouble();

        Invoice invoice = new Invoice(invoiceNumber, purchaseDate, customerName, amount);
        System.out.println("\nInvoice Created Successfully!\n");
        invoice.displayInvoiceDetails();
    
        System.out.println("\n--------------------------------");

        double remainingBalance = amount;
        boolean isFullyPaid = false;
        while (!isFullyPaid) {
            double amountPaid;
            while (true){
                System.out.println("\nEnter Amount Paid: ");
                amountPaid= scanner.nextDouble();

                if (amountPaid <= 0){
                    System.out.println("Error: Payment amount must be greater than zero!");
                }else if (amountPaid > remainingBalance){
                    System.out.printf("Error: Payment amount exceeds remaining balance(%.2f)!\n",remainingBalance);
                    continue;
                }
                break;
            }
            
            scanner.nextLine();

            System.out.println("Enter Payment Date(YYYY-MM-DD): ");
            String paymentDate = scanner.nextLine();

            int paymentChoice;
            String paymentMethod = "";
            while(true){
                System.out.println("Enter Payment Method (1 for Cash, 2 for Check): ");
                paymentChoice = scanner.nextInt();

                if(paymentChoice == 1){
                    paymentMethod = "Cash";
                    break;
                }else if(paymentChoice == 2){
                    paymentMethod = "Check";
                    break;
                }else {
                    System.out.println("Error: Invalid choice! Please enter 1 for Cash or 2 for Check.");
                }
            }
            scanner.nextLine();

            Payment payment;
            if(paymentMethod.equalsIgnoreCase("Check")){
                String checkType = "";
                while(true){
                    System.out.println("Is the Check on-date or post-dated? (O for On-date, P for Post-dated): ");
                    String checkChoice = scanner.nextLine().toUpperCase();

                    if (checkChoice.equals("O")){
                        checkType = "On-date";
                        break;
                    }else if(checkChoice.equals("P")){
                        checkType = "Post-dated";
                        break;
                    }else{
                        System.out.println("Error: Invalid choice! Enter O for On-date or P for Post-dated.");
                    }
                }

                System.out.println("Enter Check Number: ");
                String checkNumber = scanner.nextLine();

                payment = new Payment(invoiceNumber, purchaseDate, customerName, amount, amountPaid, paymentDate, paymentMethod, checkNumber, checkType);

            }else{
                payment = new Payment(invoiceNumber, purchaseDate, customerName, amount, amountPaid, paymentDate, paymentMethod);
            }

            remainingBalance -= amountPaid;
            System.out.println("\nPayment Recorded SuccessFully!\n");
            payment.displayPaymentDetails();

            if(remainingBalance == 0){
                System.out.println("Invoice fully paid. No remaining balance.");
                isFullyPaid = true;
            }else{
                System.out.printf("Remaining Balance: %2f\n", remainingBalance);
                System.out.println("Do you want to apply another payment to this invoice? (Y/N): ");
                String continuePayment = scanner.nextLine().toUpperCase();

                if(!continuePayment.equals("Y")){
                    System.out.printf("Payment proccess ended. Remaining balance: %2f\n", remainingBalance);
                    break;
                }
            }
        }
        scanner.close();
    }   
}
