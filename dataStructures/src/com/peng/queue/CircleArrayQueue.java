package com.peng.queue;

import java.util.Scanner;

/**
 * @Author sp
 * @Description
 * @create 2020-12-11 13:54
 * @Modified By:
 */
public class CircleArrayQueue {

  public static void main(String[] args) {
    //测试
    //初始化一个队列
    CircleArry arrayQueue = new CircleArry(4);
    char key = ' ';//接受用户输入
    Scanner scanner = new Scanner(System.in);
    boolean loop = true;
    //输出
    while (loop) {
      System.out.println("s(show): 显示队列");
      System.out.println("e(exit): 退出程序");
      System.out.println("a(add): 添加数据到队列");
      System.out.println("g(get): 从队列取数据");
      System.out.println("h(head): 显示队列头数据");
      System.out.println("i(size): 显示队列有效数据个数");
      if (scanner.hasNext()) {
        key = scanner.next().charAt(0);
        switch (key) {
          case 's':
            arrayQueue.show();
            break;
          case 'a':
            System.out.println("输出一个数");
            int value = scanner.nextInt();
            arrayQueue.addQueue(value);
            break;
          case 'g':
            try {
              int result = arrayQueue.getQueue();
              System.out.printf("取出的数据是%d\n", result);
            } catch (Exception exception) {
              System.out.println(exception.getMessage());
            }
            break;
          case 'h':
            try {
              int result = arrayQueue.headQueue();
              System.out.printf("取出的头数据是%d\n", result);
            } catch (Exception e) {
              System.out.println(e.getMessage());
            }
            break;
          case 'i':
            try {
              int result = arrayQueue.size();
              System.out.printf("有效数据个数%d\n", result);
            } catch (Exception exception) {
              System.out.println(exception.getMessage());
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
    }
    System.out.println("程序退出~~~");
  }
}


class CircleArry {

  private int maxSize;//表示数组的最大容量
  private int front;//队列头
  private int rear;//队列尾位置的下一个空间预留位置
  //front = 0;rear=0
  private int[] data;

  public CircleArry(int maxSize) {
    this.maxSize = maxSize;
    data = new int[maxSize];
  }

  public boolean isFull() {
    return (rear + 1) % maxSize == front;
  }

  public boolean isEmpty() {
    return rear == front;
  }

  public void addQueue(int n) {
    //判断队列是否满
    if (isFull()) {
      System.out.println("队列满，不能加入");
      return;
    }
    data[rear] = n;
    rear = (rear + 1) % maxSize;
  }

  public int getQueue() {
    if (isEmpty()) {
      throw new RuntimeException("队列空，不能取数据");
    }
    int varible = front;
    front = (front + 1) % maxSize;
    return data[varible];

  }

  public void show() {
    //遍历
    if (isEmpty()) {
      System.out.println("队列空，无法取值");
      return;
    }
    for (int i = front; i < front + size(); i++) {
      System.out.printf("arr[%d]=%d\n", i % maxSize, data[i % maxSize]);
    }
  }

  //求出当前队列有效数据的个数
  public int size() {

    return (rear + maxSize - front) % maxSize;
  }

  //显示头元素
  public int headQueue() {
    if (isEmpty()) {
      System.out.println("队列空，没有数据~~");
      throw new RuntimeException("队列空，没有数据~~");
    }

    return data[front];
  }

}