package org.java.datastructure.stack;

/**
 * 利用栈结构设计计算器
 */
public class ExpressionStack {


    /**
     * 中序表达式计算
     * 例如：3+2*5-4/2=11
     * @Param expression 待计算的表达式
     * @return
     */
    public int Calculate(String expression){
        //声量两个栈，栈1存放数据，栈2存放运算符
        //1·遍历表达式expression,遇到数字则放进栈1，如果遇到运算符号：
        //1·1 如果栈2为空，则直接入栈
        //1·2 如果栈2不为空，则：当该运算符优先级<=栈2的运算符优先级时，取出栈2的运算符号，和栈1的栈顶元素和次栈顶元素，计算后将结果入栈1，至遍历结束
        ArrayStack numberStack = new ArrayStack(100);
        ArrayStack operatorStack= new ArrayStack(50);

        char[] expressionChar = expression.toCharArray();
        for (int i=0;i<expressionChar.length;i++){
            char c = expressionChar[i];
            if(Character.isDigit(c)){
                //数字
                numberStack.push(String.valueOf(c));
            }else {
                //运算符
                if(operatorStack.isEmpty()){
                    //operatorStack 为空
                    operatorStack.push(String.valueOf(c));
                }else {

                }

            }
        }

    }


}
