package stack;

import java.util.Stack;

public class MinStack {
    Stack<Integer> mainStack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    /**
     * 入栈
     * @param data 入栈元素
     */
    public void push(int data){
        mainStack.push(data);
        //如果辅助栈为空，或者元素小于或等于主栈元素，则将元素压入辅助栈
        if (minStack.empty() || data <= minStack.peek()){
            minStack.push(data);
        }
    }

    /**
     * 出栈
     * @return
     */
    public int pop(){
        //如果出栈元素与辅助栈元素相同，辅助栈出栈
        if (mainStack.peek() == minStack.peek()){
            minStack.pop();
        }
        return mainStack.pop();
    }

    public int getMin() throws Exception {
        if(minStack.empty()){
            throw new Exception("栈为空1");
        }
        return minStack.peek();
    }

    //遍历栈
    public void stackList(){
        if (minStack.empty()){
            System.out.println("栈空!");
            return;
        }
        for (int i = mainStack.size() -1; i >= 0; i--) {
            System.out.println("栈中元素为：" + mainStack.get(i));
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(4);
        minStack.push(3);
        minStack.push(11);
        minStack.push(9);
        minStack.push(1);
        int min = 0;
        try {
            min = minStack.getMin();
        } catch (Exception e) {
            e.printStackTrace();
        }

        minStack.stackList();
        //System.out.println(minStack.mainStack.size());
        System.out.println(min);
    }
}
