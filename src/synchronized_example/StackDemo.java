package synchronized_example;

public class StackDemo {

    public static void main(String[] args) {

        StackImpl ticket = new StackImpl(10);

        new Thread(() -> {
            int i = 0;
            while (++i < 9) {
                System.out.println(ticket.push(i) + " ");
            }
        }, "pusher thread").start();

        new Thread(() -> {
            int j = 0;
            while (++j < 10) {
                System.out.println(ticket.pop() + " ");

            }

        }, "pop Thread").start();

    }

}
