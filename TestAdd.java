import java.util.Scanner;

public class TestAdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Available rooms: ");
        displayRooms();

        int roomIndex = -1;
        double totalPrice = 0;
        boolean member = false;
        int allNights = 0;

        
        while(true){

            System.out.println("\n===Main Menu===");
            System.out.println("1- Book a Room");
            System.out.println("2- Cancel a Room");
            System.out.println("3- Payment");
            System.out.print("\nEnter your choice: ");
            int choice =  scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                
            
            while(true){
            System.out.print("\nEnter Room Number to book: ");
            String roomToBook =  scanner.nextLine();
            roomIndex = -1;
            for(int i = 0; i < HotelRoom.rooms.length; i++){
                if (HotelRoom.rooms[i].roomNumber.equals(roomToBook)){
                    roomIndex = i;
                    break;
                }
            }
            if (roomIndex == -1){
                System.out.println("Invalid room number. Please try again.");
                continue;
            }
            if (HotelRoom.rooms[roomIndex].isAvailable){
                break;
            }else{
                System.out.println("Sorry, Room" + roomToBook + " is not available. Please choose another room");
            }
        }
        System.out.println("\nEnter number of nights: ");
        int nights = scanner.nextInt();
        boolean isMember = false;
        while (true){
            System.out.println("Are you a member? (T/F): ");
            String memberInput =  scanner.next().toUpperCase();
            if(memberInput.equals("T")){
            isMember = true;
            break;
        }else if (memberInput.equals("F")){
            isMember = false;
            break;
        }else {
            System.out.println("Invalid input. Please enter either 'T' (for true) or 'F' (for False).");
        }
        }

        double price =  HotelRoom.rooms[roomIndex].calculatePrice(nights, isMember);
        System.out.println("Total Price for " + nights + " night(s): " + price);
        totalPrice += price;
        HotelRoom.rooms[roomIndex].bookRoom(roomIndex);
        System.out.println("\nUpdated Room Availability: ");
        displayRooms();
        System.out.println("\nTotal amount of all bookings: " + totalPrice);
     
        }else if (choice == 2){
        
         
            System.out.println("\nDisplaying Rooms: ");     
            displayRooms();

            System.out.print("\nEnter Room Number you want to cancel: ");
            String cancel =  scanner.nextLine();
            roomIndex = -1;
            for(int i = 0; i < HotelRoom.rooms.length; i++){
                if (HotelRoom.rooms[i].roomNumber.equals(cancel)){
                    roomIndex = i;
                    break;
                }
            }
            if (roomIndex == -1){
                System.out.println("Invalid room number. Please try again.");
                continue;
            }
            if (!HotelRoom.rooms[roomIndex].isAvailable){
                System.out.println("Canceling Room " + cancel);
                HotelRoom.rooms[roomIndex].isAvailable = true;
            }else{
                System.out.println("Sorry, Room" + cancel + " currently avaialable. Unable to cancel. Please choose another room");
            }

            /*double price =  HotelRoom.rooms[roomIndex].calculatePrice(nights, isMember);
            totalPrice -= price; */
            System.out.println("\nUpdated Room Availability: ");
            displayRooms();
            System.out.println("\nTotal amount of all bookings: " + totalPrice);
            

        }
        else if (choice == 3){
            if (totalPrice == 0){
                System.out.println("\nNothing to pay.");
                continue;
            }
            else{
            while (totalPrice != 0){
            System.out.print("\nEnter your payment: ");
            double pay = scanner.nextDouble();
            if (pay == totalPrice){
                pay-=totalPrice;
                System.out.println("\nPayment successful!");
                System.out.println("\nUpdated Room Availability:");
                HotelRoom.rooms[0].isAvailable = true;
                HotelRoom.rooms[1].isAvailable = true;
                HotelRoom.rooms[2].isAvailable = true;
                HotelRoom.rooms[3].isAvailable = true;
                HotelRoom.rooms[4].isAvailable = true;
                HotelRoom.rooms[5].isAvailable = true;

                displayRooms();
                break;
            }else{
                System.out.println("\nYou must pay exact amount.");
            }}}
            break;

        }else{
            System.out.println("Invalid Input!");
            continue;
        }

    }
    

    }

    private static void displayRooms(){
        for (int i = 0; i < HotelRoom.rooms.length; i++){
            if (HotelRoom.rooms[i].isAvailable){
                System.out.println(HotelRoom.rooms[i]);
            }else {
                System.out.println(HotelRoom.rooms[i] + " | Status: Not Available");
            }
        }
    }
}
