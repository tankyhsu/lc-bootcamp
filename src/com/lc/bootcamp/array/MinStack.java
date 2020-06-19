package com.lc.bootcamp.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * <p>
 * 示例:
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * <p>
 * 提示：
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 * <p>
 * Related Topics 栈 设计
 *
 * @author tianqi.xu
 * 2020/6/19
 */
public class MinStack {
    // 栈顶
    int top;
    // 栈
    List<Integer> stack;
    // 辅助栈
    List<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new ArrayList<>();
        top = 0;
        minStack = new ArrayList<>();
        minStack.add(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.add(x);
        minStack.add(Math.min(minStack.get(top), x));
        top = stack.size();
    }

    public void pop() {
        stack.remove(top - 1);
        minStack.remove(top);
        top = stack.size();
    }

    public int top() {
        return stack.get(top - 1);
    }

    public int getMin() {
        return minStack.get(top);
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }
}
