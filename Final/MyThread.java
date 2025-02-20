package Final;

public class MyThread extends Thread{
    public void run(){
        for (int i = 1; i <= 5; i++){
            System.out.println(Thread.currentThread().getId() + " Value: " + i );
            try{
                Thread.sleep(500);
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }
    
}
