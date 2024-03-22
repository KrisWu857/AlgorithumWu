package com.class14;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ConvertQueueAndStack {
    // 测试链接 : https://leetcode.cn/problems/implement-queue-using-stacks/
    // 用栈实现队列   时间复杂度0(1)
        class  MyQueue {

        public Stack<Integer> in;

        public Stack<Integer> out;

    	public MyQueue() {
            in = new Stack<Integer>();
            out = new Stack<Integer>();
        }

        // 倒数据 (从 in栈 把数据倒入 out栈 )
        // 1) out空了,才能倒
        // 2) 如果要倒的话, in必须清空
        private void inToOut() {
            if (out.empty()) {
                while (!in.empty()) {
                    out.push(in.pop());
                }
            }
        }


        public void push ( int x){
            in.push(x);
            inToOut();
        }

        public int pop () {
            inToOut();
            return out.pop();
        }

        public int peek () {
            inToOut();
            return out.peek();
        }

        public boolean empty () {
            return in.isEmpty() && out.isEmpty();
        }
    }

    // 测试链接 : https://leetcode.cn/problems/implement-stack-using-queues/
    // 用队列实现栈   时间复杂度O(n)
    class MyStack {

        Queue<Integer> queue;

        public MyStack(){
            queue = new LinkedList<>();
        }

        public void push(int x) {
            int n = queue.size();
            queue.offer(x);
            for (int i = 0; i < n; i++) {
                queue.offer(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
