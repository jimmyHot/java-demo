package org.java.datastructure.stack;

/**
 * 利用栈结构设计计算器
 */
public class ExpressionStack {


    /**
     * 中序表达式计算
     * 例如：1+2*3-4+8/2=7
     *
     * @return
     * @Param expression 待计算的表达式
     */
    public int Calculate(String expression) {
        //声量两个栈，栈1存放数据，栈2存放运算符
        //1·遍历表达式expression,遇到数字则放进栈1，如果遇到运算符号：
        //1·1 如果栈2为空，则直接入栈
        //1·2 如果栈2不为空，则：当该运算符优先级<=栈2的运算符优先级时，取出栈2的运算符号，和栈1的栈顶元素和次栈顶元素，计算后将结果入栈1，至遍历结束
        ArrayStack numberStack = new ArrayStack(100);
        ArrayStack operatorStack = new ArrayStack(50);

        char[] expressionChar = expression.toCharArray();
        for (char c : expressionChar) {
            if (Character.isDigit(c)) {
                //数字
                numberStack.push(String.valueOf(c));
            } else {
                //运算符
                if (operatorStack.isEmpty()) {
                    //operatorStack 为空
                    operatorStack.push(String.valueOf(c));
                } else {
                    String peek = operatorStack.peek();
                    if (getPriority(c) <= getPriority(peek.toCharArray()[0])) {
                        //该运算符优先级<=栈2的运算符优先级,取出栈2的运算符号，和栈1的栈顶元素和次栈顶元素，计算后将结果入栈1
                        String operator = operatorStack.pop();
                        String num1 = numberStack.pop();
                        String num2 = numberStack.pop();
                        int result = count(Integer.valueOf(num1), Integer.valueOf(num2), operator);
                        numberStack.push(String.valueOf(result));
                        operatorStack.push(String.valueOf(c));
                    } else {
                        //直接入栈
                        operatorStack.push(String.valueOf(c));
                    }
                }
            }
        }
        //遍历完，栈1和栈2依次取出计算即可
        while (!operatorStack.isEmpty()){
            String operator = operatorStack.pop();
            String num1 = numberStack.pop();
            String num2 = numberStack.pop();
            int result = count(Integer.valueOf(num1), Integer.valueOf(num2), operator);
            numberStack.push(String.valueOf(result));
        }
        String result = numberStack.pop();
        return Integer.parseInt(result);
    }

    private int count(Integer num1, Integer num2, String operator) {
        char c = operator.charAt(0);
        switch (c) {
            case '+':
                return num1 + num2;
            case '-':
                return num2 - num1;
            case '*':
                return num1 * num2;
            case '/':
                return num2 / num1;
            default:
                throw new RuntimeException("不识别该运算法~");
        }
    }

    /***
     * 获取运算符的优先级
     * @param operator
     * @return
     */
    public int getPriority(char operator) {

        if (operator == '-' || operator == '+') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        } else {
            throw new RuntimeException("运算符不存在");
        }
    }

}
