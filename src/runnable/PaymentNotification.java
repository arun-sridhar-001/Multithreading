package runnable;

import java.util.List;

public class PaymentNotification implements Runnable {

    private String user;

    public PaymentNotification(String user) {
        this.user = user;
    }


    @Override
    public void run() {
        System.out.println("Sending...");
        try{
            Thread.sleep(3000);
            System.out.println("Payment Completed for ---> "+ user);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {

        Thread paymentNotificationThread = new Thread(new PaymentNotification("Arun"));  // target
        Thread paymentNotificationThread_2 = new Thread(new PaymentNotification("Vinoth"));


        // using Lambda
       Thread deepakthread = new Thread(() -> {
            System.out.println("Sending...");
            try{
                Thread.sleep(3000);
                System.out.println("Payment Completed for ---> "+ "Deepak");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        paymentNotificationThread.start();
        paymentNotificationThread_2.start();
        deepakthread.start();

    }


}
