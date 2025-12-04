public class NotificationSender extends Thread {

    private String message;

    public NotificationSender(String message) {
        this.message = message;
    }

    public NotificationSender(int num) {
        System.out.println(num);
    }


    @Override
    public void run() {
        System.out.println("Sending Message");
        try {
            Thread.sleep(5000);
            if("Email".equals(message)) {
                throw new InterruptedException("Message send failed");
            }
            System.out.println(message);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


    // Single Main Thread
    public static void main(String[] args) {
        Thread paymentNotificationThread = new NotificationSender("Payment Completed");  // User Thread

        Thread orderNotificationThread = new NotificationSender("Order Shipped");   // User Thread

        Thread EmailNotificationThread = new NotificationSender("Email");   // User Thread
        Thread vendorNotificationThread = new NotificationSender("Vendor");   // User Thread


        paymentNotificationThread.start();  // Runnable  ->>JVM ->> Running
        orderNotificationThread.start();
        EmailNotificationThread.start();
        vendorNotificationThread.start();

        Dummy dum = new Dummy(10);

        System.out.println("main Thread Still running");

    }
}
