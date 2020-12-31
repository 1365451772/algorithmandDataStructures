package com.peng.queue;

import java.util.Scanner;

/**
 * @Author sp
 * @Description
 * @create 2020-12-11 10:48
 * @Modified By:
 */
public class ArrayQueueDemo {

  public static void main(String[] args) {
    //测试
    //初始化一个队列
    ArrayQueue arrayQueue = new ArrayQueue(3);
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

//使用数组模拟队列-编写一个ArrayQueue类
class ArrayQueue {

  private int maxSize;//表示数组的最大容量
  private int front;//队列头
  private int rear;//队列尾
  private int[] data;
  //创建队列构造器

  public ArrayQueue(int maxSize) {
    this.maxSize = maxSize;
    data = new int[maxSize];
    front = -1;//指向队列头部位置前一个位置【不包含队列头数据】
    rear = -1;//指向队列尾部位置【包含队尾的数据】
  }

  //判断队列是否满
  public boolean isFull() {
    return rear == maxSize - 1;
  }

  //判断队列是空
  public boolean isEmpty() {
    return rear == front;
  }

  //添加数据到队列
  public void addQueue(int n) {
    //判断队列是否满
    if (isFull()) {
      System.out.println("队列满，不能加入");
      return;
    }
    rear++;
    data[rear] = n;
  }

  //获取队列的数据，出队列
  public int getQueue() {
    //判断队列是否为空
    if (isEmpty()) {
      //通过抛出异常处理
      throw new RuntimeException("队列为空，无法得到数据");
    }
    front++;
    return data[front];
  }

  //显示队列的所有数据
  public void show() {
    //遍历
    if (isEmpty()) {
      System.out.println("队列空，无法取值");
      return;
    }
    for (int i = front; i < rear; i++) {
      System.out.println(data[i]);
    }
  }

  //显示队列的头数据，注意不是取出数据
  public int headQueue() {
    if (isEmpty()) {
      System.out.println("队列空，没有数据~~");
      throw new RuntimeException("队列空，没有数据~~");
    }
    return data[++front];
  }
}
