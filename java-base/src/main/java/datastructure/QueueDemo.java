package datastructure;

/**
 * @Author weimenghua
 * @Date 2022-04-23 9:34
 * @Description 队列：队列与栈一样，也是一种线性表，不同的是，队列可以在一端添加元素，在另一端取出元素，也就是：先进先出。从一端放入元素的操作称为入队，取出元素为出队。
 */
public class QueueDemo {
    public static void main(String[] args) {
        QueueDemo queue = new QueueDemo(5);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        queue.poll();
        queue.offer(6);
        queue.showQueue();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
    }

    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public QueueDemo() {
    }

    public QueueDemo(int maxSize) {
        this.maxSize = maxSize + 1;
        this.arr = new int[maxSize + 1];
        this.front = 0;
        this.rear = 0;
    }

    private boolean isFull() {
        if ((rear + 1) % maxSize == front) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isEmpty() {
        if (this.rear == this.front) {
            return true;
        } else {
            return false;
        }
    }

    private void offer(int data) {
        if (!isFull()) {
            arr[rear] = data;
            rear = (rear + 1) % maxSize;
        } else {
            System.out.println("队列已满");
        }
    }

    private int poll() {
        if (!isEmpty()) {
            int value = arr[front];
            front = (front + 1) % maxSize;
            return value;
        } else {
            throw new RuntimeException("队列为空");
        }
    }

    private void showQueue() {
        int size = size();
        for (int i = front; i < front + size; i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    private int size() {
        return (rear + maxSize - front) % maxSize;
    }

}
