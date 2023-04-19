package stack;

public class MyArrayStack {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(4);
        arrayStack.push(3);
        arrayStack.push(6);
        arrayStack.push(9);
        arrayStack.push(1);

        arrayStack.stackList();
        System.out.println();
        int popValue = arrayStack.pop();
        System.out.println("弹出元素为：" + popValue);
        System.out.println();
        arrayStack.stackList();
    }
}


//表示一个栈
class ArrayStack{
    //栈的大小
    private int maxSize;
    //数组模拟栈
    private int stack[];
    //top表示栈顶，初始值为-1
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }
    //栈满
    public boolean isFull(){
        return top == maxSize -1;
    }
    //栈空
    public boolean isEmpty(){
        return top == -1;
    }
    //入栈
    public void push(int value){
        if(isFull()){
            System.out.println("栈满1");
            return;
        }
        top++;
        stack[top] = value;
    }
    //出栈
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空！");
        }
        int popValue = stack[top];
        top--;
        return  popValue;
    }
    //遍历栈
    public void stackList(){
        if (isEmpty()){
            System.out.println("栈空!");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println("栈中元素为：" + stack[i]);
        }
    }
}
