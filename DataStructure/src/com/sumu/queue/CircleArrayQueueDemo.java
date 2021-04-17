package com.sumu.queue;

import java.util.Scanner;

/**
 * 数组模拟环形队列
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        System.out.println("=====数组模拟环形队列=====");
        // 创建一个环形队列
        CircleArrayQueue circleArrayQueue  = new CircleArrayQueue(4); // MaxSize为4，有效数据就为3，MaxSize-1的位置留空
        char key = ' '; // 接受用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show)：显示队列中的所有数据");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("o(out)：使数据退出队列");
            System.out.println("h(head)：查看队列头数据");
            System.out.println("e(exit)：退出程序");
            System.out.println("请输入功能字母编号：");
            key = scanner.next().charAt(0); // 接收一个字符
            switch (key) {
                case 's':
                    circleArrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数:");
                    int value = scanner.nextInt();
                    circleArrayQueue.addDataToQueue(value);
                    break;
                case 'o':
                    try {
                        int res = circleArrayQueue.outDataFromQueue();
                        System.out.printf("出队的数据是：%d\n",res);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = circleArrayQueue.headQueue();
                        System.out.printf("队列头的数据是：%d\n",res);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序已退出！");
    }
}

class CircleArrayQueue {
    private int maxSize; // 表示数组的最大容量
    // front指向队列的第一个元素，arr[front]就是队列的第一个元素，front的初始值为0;
    private int front;
    // rear指向队列的最后一个元素(MaxSize - 2)的后一个位置(MaxSize - 1)，MaxSize - 1这个位置留空作为约定，不用于存储数据，rear的初始值为0;
    private int rear;
    private int[] arr; // 该数组用于存放数据，模拟队列

    public CircleArrayQueue(Integer arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    // 判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front; // rear == maxSize-1时队列为满
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return front == rear; // front == rear时队列为空
    }

    // 添加数据到队列
    public void addDataToQueue(int n) {
        // 判断队列是否为满
        if (isFull()) {
            System.out.println("队列已满，不能加入数据！");
            return;
        }
        // 直接将数据加入
        arr[rear] = n;
        // 将rear后移，此处必须考虑取模
        rear = (rear + 1) % maxSize;
    }

    // 从队列中获取数据（出队列）
    public int outDataFromQueue() {
        // 判断队列是否为空
        if (isEmpty()) {
            // 通过抛出异常处理
            throw new RuntimeException("队列为空，不能获取数据！");
        }
        /**
         * 此处需要分析出front是指向队列的第一个元素
         * 1、先将front对应的数据存储到一个临时的变量中
         * 2、将front后移，考虑取模
         * 3、将第一步的存储临时变量返回
         */
        int temp = arr[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    // 显示队列中的所有数据
    public void showQueue() {
        // 判断队列是否为空
        if (isEmpty()) {
            System.out.println("队列为空，没有数据！");
            return;
        }
        /**
         * 思路：
         * 1、从front开始遍历
         * 2、遍历数据个数为队列中的有效数据个数
         */
        for (int i = front; i < front + getValidNum(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    // 求队列中有效数据个数
    public int getValidNum() {
        /**
         * 例如：rear = 1，front = 0，maxSize=3
         * (1 + 3 - 0) % 3 = 1
         */
        return (rear + maxSize - front) % maxSize;
    }

    // 显示队列的头数据，而不是取数据
    public int headQueue() {
        // 判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据！");
        }
        return arr[front];
    }
}
