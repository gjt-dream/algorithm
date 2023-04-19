package queue;

public class CirculationQueue {
    private int array[];
    //队头
    private int front;
    //队尾
    private int rear;

    public CirculationQueue(int capacity) {
        this.array = new int[capacity];
    }

    /**
     * 入队
     * @param element 入队元素
     */
    public void enQueue(int element) throws Exception {
        if((rear + 1) % array.length == front){
            throw new Exception("队列已满！");
        }
        array[rear] = element;
        rear = (rear + 1) % array.length;
    }

    /**
     * 出队
     * @return
     * @throws Exception
     */
    public int deQueue() throws Exception {
        if(rear == front){
            throw new Exception("队列为空！");
        }
       int deQueueElement =  array[front];
        front = (front + 1) % array.length;
        return deQueueElement;
    }

    public void outQueue(){
        for (int i = front;i != rear;i = (i + 1) % array.length){
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        CirculationQueue circulationQueue = new CirculationQueue(6);

        circulationQueue.enQueue(5);
        circulationQueue.enQueue(2);
        circulationQueue.enQueue(6);
        circulationQueue.enQueue(9);
        circulationQueue.enQueue(4);
        circulationQueue.deQueue();
        circulationQueue.deQueue();
        circulationQueue.deQueue();
        circulationQueue.deQueue();
        circulationQueue.enQueue(0);
        circulationQueue.enQueue(1);
        circulationQueue.outQueue();
        System.out.println(circulationQueue.array.length);
    }
}
