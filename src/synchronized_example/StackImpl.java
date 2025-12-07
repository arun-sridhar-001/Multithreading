package synchronized_example;


public class StackImpl {

    private int[] array;
    private int top;
    private String lock;
    private String lock_2;

    public StackImpl(int capacity) {
        array = new int[capacity];
        top = -1;  // 0
        lock = "1234";
        lock_2 = "1111";

    }

    /**
     * We can use Synchronized key word too. Ex public synchronized boolean push(val){}
     * @param val
     * @return
     */
    public boolean push(int val) {
        if (isFull()) {
            return false;
        }

        synchronized (lock) {  // 1234
            ++top;

            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }

            array[top] = val;
            return true;
        }

    }

    /**
     * We can use Synchronized key word too. Ex public synchronized int pop(){}
     * @return
     */
    public int pop() {

        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        synchronized (lock) {  // 1111
            int op = array[top];
            array[top] = Integer.MIN_VALUE;
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
            top--;

            return op;
        }

    }

    public int peek() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }

        return array[top];
    }


    public boolean isEmpty() {  // -1
        return top < 0;
    }

    private boolean isFull() {
        return top >= array.length - 1;

    }


}
