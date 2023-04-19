package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {

    /**
     * 将传入逆波兰表达式的字符串放入数组
     * @param suffixExpression 传入逆波兰表达式的字符串
     * @return
     */
    public List<String> getListString(String suffixExpression){
        //分割suffixExpression
        String[] split = suffixExpression.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String data:split) {
            list.add(data);
        }
        return list;
    }

    public int calculator(List<String > ls){
        Stack<String> stack = new Stack<>();
        for (String item:ls) {
            if (item.matches("\\d+")){
                stack.push(item);
            }else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                switch (item) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num2 - num1;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num2 / num1;
                        break;
                    default:
                        throw new RuntimeException("输入有误！");
                }
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }

    /**
     * 转换成一个数组 [23, +, (, 3, *, 6, ), -, 9]
     * @param s 要转换的字符串
     * @return
     */
    public List<String> toInfixExpressionList(String s){
        ArrayList<String> strings = new ArrayList<>();
        int i = 0;
        String str;
        char c = ' ';
        do{
            if((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57){
                strings.add(c + "");
                i++;
            }else {
                str = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57){
                    str += c;
                    i++;
                }
                strings.add(str);
            }
        }while (i < s.length());
        return strings;
    }

    /**\
     * 转换成逆波兰表达式对应的list
     * @param ls
     * @return
     */
    public List<String> parseSuffixExpression(List<String> ls){
        Stack<String> stringStack = new Stack<>();
        ArrayList<String> stringArrayList = new ArrayList<>();
        for (String item:ls) {
            if (item.matches("\\d+")){
                stringArrayList.add(item);
            }else if (item.equals("(")){
                stringStack.push(item);
            }else if ((")").equals(item)){
                while (!stringStack.peek().equals("(")){
                    stringArrayList.add(stringStack.pop());
                }
                stringStack.pop();
            }else {
                while (stringStack.size() != 0 && Operation.getValue(stringStack.peek()) >= Operation.getValue(item)){
                    stringArrayList.add(stringStack.pop());
                }
                stringStack.push(item);
            }
        }
        while (!stringStack.empty()){
            stringArrayList.add(stringStack.pop());
        }
        return stringArrayList;
    }

    public static void main(String[] args) {
        String suffixExpression = "3 4 + 5 * 6 -";

        PolandNotation polandNotation = new PolandNotation();
        List<String> listString = polandNotation.getListString(suffixExpression);
        int calculator = polandNotation.calculator(listString);
        System.out.println(calculator);


        String suffixExpression2 = "23+(3*6)-9";
        List<String> stringList = polandNotation.toInfixExpressionList(suffixExpression2);
        List<String> parseSuffixExpression = polandNotation.parseSuffixExpression(stringList);
        int calculator1 = polandNotation.calculator(parseSuffixExpression);
        System.out.println(calculator1);
    }
}

class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;
    public static int getValue(String operation){
        int res = 0;
        switch (operation){
            case "+":
                res = ADD;
                break;
            case "-":
                res = SUB;
                break;
            case "*":
                res = MUL;
                break;
            case "/":
                res = DIV;
                break;
            default:
                break;
        }
        return res;
    }
}
