package algorithm;

import java.util.Stack;

public class StackQueue {
    Stack<Integer> stackA = new Stack<Integer>();
    Stack<Integer> stackB = new Stack<Integer>();

    /**
     * 入队
     * @param element
     */
    public void enQueue(int element){
        stackA.push(element);
    }

    /**
     * 出队
     * @return
     * @throws Exception
     */
    public int deQueue() throws Exception {
        if (stackB.empty()){
            if (stackA.empty()){
                throw new Exception("队列为空！");
            }
            transfer();
        }
        return stackB.pop();
    }

    /**
     * 将A栈元素转换到B栈中
     */
    public void transfer(){
        while (!stackA.empty()){
            stackB.push(stackA.pop());
        }
    }

    public static void main(String[] args) throws Exception {
        StackQueue stackQueue = new StackQueue();
        stackQueue.enQueue(5);
        stackQueue.enQueue(8);
        stackQueue.enQueue(3);
        stackQueue.enQueue(10);

        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.stackA);
        System.out.println(stackQueue.stackB);
    }
}
