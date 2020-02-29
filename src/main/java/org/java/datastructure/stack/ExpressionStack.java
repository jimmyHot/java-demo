package org.java.datastructure.stack;


import java.util.ArrayList;
import java.util.Collections;

/**
 * 利用栈结构设计计算器
 */
public class ExpressionStack {


    /**
     * 中序表达式计算
     * 例如：1+2*3-4+8/2=7
     * <p>
     * 声量两个栈，栈1存放数据，栈2存放运算符
     * 1·遍历表达式expression,遇到数字则放进栈1，如果遇到运算符号：
     * 1·1 如果栈2为空，则直接入栈
     * 1·2 如果栈2不为空，则：当该运算符优先级<=栈2的运算符优先级时，取出栈2的运算符号，和栈1的栈顶元素和次栈顶元素，计算后将结果入栈1，至遍历结束
     * 1·3 遍历完，栈1和栈2依次取出计算即可
     *
     * @return
     * @Param expression 待计算的表达式
     */
    public int Calculate(String expression) {
        ArrayStack numberStack = new ArrayStack(100);
        ArrayStack operatorStack = new ArrayStack(50);

        char[] expressionChar = expression.toCharArray();
        boolean isNumber = false;//定义一个标识符：标识遍历时的前一个字符是否为数字，如果为数字，则从栈中pop出，拼接后后push栈中。
        for (char c : expressionChar) {
            if (Character.isDigit(c)) {
                //数字
                handleNum(isNumber, numberStack, c);
                isNumber = true;
            } else {
                //运算符
                handleOperator(numberStack, operatorStack, c);
                isNumber = false;
            }
        }
        //遍历完，栈1和栈2依次取出计算即可
        while (!operatorStack.isEmpty()) {
            int result = countForStack(operatorStack, numberStack);
            numberStack.push(String.valueOf(result));
        }
        return Integer.parseInt(numberStack.pop());
    }


    /**
     * 计算后缀表达式
     * 例如：1+（3+4）*2-4——》1 3 4 + 2 * + 4 -
     * 逻辑
     * 1·定义栈 tempStack:遍历表达式，如果是数字，直接入栈，如果是运算符，则从栈中pop出栈顶，次栈顶元素，参与运算后的结果在push到栈tempStack，遍历结束，栈tempStack的最后元素即计算结果
     *
     * @param expression
     * @return
     */
    public int CalculatePostfixExpression(String expression) {
        String[] split = expression.split(" ");
        ArrayStack tempStack = new ArrayStack(100);
        for (String cul : split) {
            if (isNumber(cul)) {
                //是数字
                tempStack.push(cul);
            } else {
                //是运算符
                String num1 = tempStack.pop();
                String num2 = tempStack.pop();
                int result = count(Integer.valueOf(num1), Integer.valueOf(num2), cul);
                tempStack.push(String.valueOf(result));
            }
        }
        return Integer.parseInt(tempStack.pop());
    }

    /**
     * 将中序表达式转换为后序表达式
     * 例如：1+（3+4）*2-4——》1 3 4 + 2 * + 4 -
     * 思路：
     * 1·定义两个栈，栈1operatorStack存储运算符;栈2tempStack存储中间变量值
     * 从左向后扫描表达式，如果是操作数，则push到tempStack,如果是运算符，则：
     * 如果operatorStack为空，或者栈顶为“（” ，或者该运算符的优先级>栈顶运算符优先级，则直接入栈
     * 否则该运算符的优先级<=栈顶运算符优先级时，pop出栈顶运算符，push到tempStack中
     * 如果该运算符是“）”，则从operatorStack中pop出运算符，push到tempStack中，直到遇到“（”为止，双括号废弃
     *
     * @param expression
     * @return
     */
    public String formatMidToPostFixExpression(String expression) {
        if (expression.isEmpty()) {
            throw new RuntimeException("参数有误");
        }
        ArrayStack operatorStack = new ArrayStack(100);
        ArrayStack tempStack = new ArrayStack(100);
        char[] chars = expression.toCharArray();
        boolean isNumber = false;//定义一个标识符：标识遍历时的前一个字符是否为数字，如果为数字，则从tempStack栈中pop出，拼接后后push栈中。
        //遍历表达式，按照思路依次放进栈中
        for (char per : chars) {
            if (Character.isDigit(per)) { //是操作数
                handleNumForFormatExpression(tempStack, isNumber, per);
                isNumber = true;
            } else { //是运算符
                handleOperatorForFormatExpression(per, operatorStack, tempStack);
                isNumber = false;
            }
        }
        //将operatorStack依次pop，并push到tempStack
        while (!operatorStack.isEmpty()) {
            tempStack.push(operatorStack.pop());
        }
        //tempStack中的内容的逆序即为后缀表达式
        ArrayList<String> postFixArray = new ArrayList<>();
        while (!tempStack.isEmpty()) {
            postFixArray.add(tempStack.pop());
        }
        Collections.reverse(postFixArray);
        return String.join(" ", postFixArray);
    }

    private void handleNumForFormatExpression(ArrayStack tempStack, boolean isNumber, char per) {
        if (isNumber) {
            tempStack.push(tempStack.pop().concat(String.valueOf(per)));
        } else {
            tempStack.push(String.valueOf(per));
        }
    }

    private void handleOperatorForFormatExpression(char per, ArrayStack operatorStack, ArrayStack tempStack) {
        if (per == ')') {//运算符是右括号
            String pop = operatorStack.pop();
            while (!pop.equals("(")) {
                tempStack.push(pop);
                pop = operatorStack.pop();
            }
        } else {
            if (!operatorStack.isEmpty()
                    && !operatorStack.peek().equals("(")
                    && getPriority(per) <= getPriority(operatorStack.peek().charAt(0))) {
                String pop = operatorStack.pop();
                while (getPriority(per) <= getPriority(pop.charAt(0))) {
                    tempStack.push(pop);
                    if (operatorStack.isEmpty()) {
                        break;
                    }
                    pop = operatorStack.pop();
                }
            }
            operatorStack.push(String.valueOf(per));
        }
    }


    private boolean isNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private int countForStack(ArrayStack operatorStack, ArrayStack numberStack) {
        String operator = operatorStack.pop();
        String num1 = numberStack.pop();
        String num2 = numberStack.pop();
        return count(Integer.valueOf(num1), Integer.valueOf(num2), operator);
    }

    private void handleNum(boolean isNumber, ArrayStack numberStack, char c) {
        if (isNumber) {
            String pop = numberStack.pop();
            numberStack.push(pop.concat(String.valueOf(c)));
        } else {
            numberStack.push(String.valueOf(c));
        }
    }

    private void handleOperator(ArrayStack numberStack, ArrayStack operatorStack, char c) {
        if (operatorStack.isEmpty()) {
            //operatorStack 为空
            operatorStack.push(String.valueOf(c));
        } else {
            String peek = operatorStack.peek();
            if (getPriority(c) <= getPriority(peek.toCharArray()[0])) {
                //该运算符优先级<=栈2的运算符优先级,取出栈2的运算符号，和栈1的栈顶元素和次栈顶元素，计算后将结果入栈1
                int result = countForStack(operatorStack, numberStack);
                numberStack.push(String.valueOf(result));
                operatorStack.push(String.valueOf(c));
            } else {
                //直接入栈
                operatorStack.push(String.valueOf(c));
            }
        }
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
                throw new RuntimeException("不识别该运算符~");
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
        } else if (operator == '(' || operator == ')') {
            return 10;
        } else {
            throw new RuntimeException("运算符不存在");
        }
    }

}
