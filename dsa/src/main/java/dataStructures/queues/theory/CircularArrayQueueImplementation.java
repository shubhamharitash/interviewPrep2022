package dataStructures.queues.theory;

public class CircularArrayQueueImplementation {
    private int[] arr;
    private int front;
    private int rear;

    public CircularArrayQueueImplementation(int k) {
        arr = new int[k];
        front = -1;
        rear = -1;
    }

    public boolean enQueue(int value) {
        if(rear == -1){
            front = 0;
            arr[front] = value;
            rear = front;
            return true;
        }
        if(((rear + 1) % arr.length) == front){
            return false;
        }
        rear = (rear + 1) % arr.length;
        arr[rear] = value;
        return true;
    }

    public boolean deQueue() {
        if(front == -1)
            return false;
        if(front == rear){
            front = -1;
            rear = -1;
            return true;
        }
        front = (front + 1) % arr.length;
        return true;
    }

    public int Front() {
        return front != -1 ? arr[front] : front;
    }

    public int Rear() {
        return rear != -1 ? arr[rear] : rear;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return ((rear + 1) % arr.length) == front;
    }
}
