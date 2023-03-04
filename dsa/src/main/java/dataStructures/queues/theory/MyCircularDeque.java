package dataStructures.queues.theory;

public class MyCircularDeque {
    int[] arr;
    int front;
    int rear;

    public MyCircularDeque(int k) {
        arr = new int[k];
        front = -1;
        rear = -1;
    }

    private boolean baseConditionsInsert(int value){
        if (isEmpty()) {
            front = 0;
            rear = front;
            arr[front] = value;
            return true;
        }
        return !isFull();
    }

    public boolean insertFront(int value) {
        if(isEmpty() || isFull())
            return baseConditionsInsert(value);
        front = (front - 1 + arr.length) % arr.length;
        arr[front] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if(isEmpty() || isFull())
            return baseConditionsInsert(value);
        rear = (rear + 1) % arr.length;
        arr[rear] = value;
        return true;
    }

    private boolean baseConditionsDelete() {
        if (front == -1) {
            return false;
        }
        front = -1;
        rear = -1;
        return true;
    }

    public boolean deleteFront() {
        if(front == -1 || front == rear)
            return baseConditionsDelete();
        front = (front + 1) % arr.length;
        return true;
    }

    public boolean deleteLast() {
        if(front == -1 || front == rear)
            return baseConditionsDelete();
        rear = (rear - 1 + arr.length) % arr.length;
        return true;
    }

    public int getFront() {
        return front != -1 ? arr[front] : front;
    }

    public int getRear() {
        return rear != -1 ? arr[rear] : rear;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return ((rear + 1) % arr.length) == front;
    }
}
