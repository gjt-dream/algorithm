package stack;


import java.util.Stack;

public class Calculator {

    //返回运算符的优先级，数字越大，优先级越高
    public int priority(int oper){
        if (oper == '*' || oper == '/'){
            return 1;
        }else if (oper == '+' || oper == '-'){
            return 0;
        }else {
            return -1;
        }
    }
    //判断是不是一个运算符
    public boolean isOper(char val){
        return  val == '+' || val == '-' || val == '*' || val == '/';
    }
    //计算方法
    public int cal(int num1,int num2,int oper){
        int res = 0;
        switch (oper){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

    /**
     * 计算器
     * @param calculator
     * @param expression 需要计算的表达式
     */
    public static void result(Calculator calculator,String expression){
        //存放数字
        Stack<Integer> numStack = new Stack<Integer>();
        //存放符号
        Stack<Integer> operStack = new Stack<Integer>();
        //定义需要的相关变量
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";
        //循环扫描expression的每一个字符
        while (true){
            //取出每个字母
            ch = expression.substring(index,index+1).charAt(0);
            //判断是否是符号
            if (calculator.isOper(ch)){
                //判断栈是否为空
                if (!operStack.empty()){
                    //判断符号的优先级
                    if (calculator.priority(ch) <= calculator.priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = calculator.cal(num1,num2,oper);
                        //把结果入数栈
                        numStack.push(res);
                        //然后将符号入栈
                        operStack.push((int) ch);
                    }else {
                        //直接入符号栈
                        operStack.push((int) ch);
                    }
                }else {
                    //直接入栈
                    operStack.push((int) ch);
                }
            }else {//如果是数入数栈
                //numStack.push(ch -48);不能直接入栈
                keepNum = keepNum + ch;
                if (index == expression.length() - 1){
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                    if (calculator.isOper(expression.substring(index + 1,index + 2).charAt(0))){
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            //继续往下扫描
            index++;
            if (index >= expression.length()){
                break;
            }
        }
//        System.out.println(numStack);
//        System.out.println(numStack.pop());
//        System.out.println(numStack.pop());
//        System.out.println(numStack.pop());
//        System.out.println(numStack.pop());
        while (true){
            if (operStack.empty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = calculator.cal(num1,num2,oper);
            numStack.push(res);
        }
        System.out.printf("表达式%s=%d",expression,numStack.pop());

    }
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String expression = "23+2*6-2";
        result(calculator,expression);

    }
}
