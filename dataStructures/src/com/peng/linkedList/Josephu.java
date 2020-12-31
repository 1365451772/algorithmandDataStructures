package com.peng.linkedList;

/**
 * @Author sp
 * @Description
 * @create 2020-12-17 11:02
 * @Modified By:
 */
public class Josephu {

  public static void main(String[] args) {
    // 测试一把看看构建环形链表，和遍历是否ok
    CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
//    circleSingleLinkedList.addBoy(5);// 加入5个节点
//    circleSingleLinkedList.showBoy();

    //测试一把节点出圈是否正确
    circleSingleLinkedList.countBoy(10, 20, 125); // 2->4->1->5->3

  }

}


//创建一个环形的单向链表
class CircleSingleLinkedList {

  //创建一个first节点
  private Boy first = null;

  //添加Boy节点，构建成一个环形的链表
  public void addBoy(int nums) {
    //nums 做一个数据校验
    if (nums < 2) {
      System.out.println("nums的值不正确");
      return;
    }
    Boy curBoy = null;//辅助指针，帮助构建环形列表
    //使用for循环来创建我们的环形列表
    for (int i = 1; i <= nums; i++) {
      //根据编号，创建节点
      Boy boy = new Boy(i);
      //如果是第一个节点
      if (i == 1) {
        first = boy;
        first.setNext(first);
        curBoy = first;
      } else {
        boy.setNext(first);
        curBoy.setNext(boy);
        curBoy = boy;
      }

    }
  }

  //遍历循环单链表
  public void showBoy() {
    //判断链表是否为空
    if (first == null) {
      System.out.println("链表为空");
      return;
    }
    //first不动，创建辅助指针遍历
    Boy curBoy = first;
    while (true) {
      System.out.printf("节点的编号%d\n", curBoy.getNo());
      if (curBoy.getNext() == first) {//遍历完毕
        break;
      }
      curBoy = curBoy.getNext();//指针后移
    }
  }

  // 根据用户的输入，计算出节点出圈的顺序

  /**
   * @param startNo 表示从第几个节点开始数数
   * @param countNum 表示数几下
   * @param nums 表示最初有多少节点在圈中
   */
  public void countBoy(int startNo, int countNum, int nums) {
    this.addBoy(nums);
    // 先对数据进行校验
    if (first == null || startNo < 1 || startNo > nums) {
      System.out.println("参数输入有误， 请重新输入");
      return;
    }

    // 创建要给辅助指针,帮助完成节点出圈
    Boy helper = first;
    // 需求创建一个辅助指针(变量) helper , 事先应该指向环形链表的最后这个节点
    while (true) {
      if (helper.getNext() == first) { // 说明helper指向最后节点
        break;
      }
      helper = helper.getNext();
    }
    //节点报数前，先让 first 和  helper 移动 k - 1次
    for (int j = 0; j < startNo - 1; j++) {
      first = first.getNext();
      helper = helper.getNext();
    }
    //当节点报数时，让first 和 helper 指针同时 的移动  m  - 1 次, 然后出圈
    //这里是一个循环操作，知道圈中只有一个节点
    while (true) {
      if (helper == first) { //说明圈中只有一个节点
        break;
      }
      //让 first 和 helper 指针同时 的移动 countNum - 1
      for (int j = 0; j < countNum - 1; j++) {
        first = first.getNext();
        helper = helper.getNext();
      }
      //这时first指向的节点，就是要出圈的节点
      System.out.printf("节点%d出圈\n", first.getNo());
      //这时将first指节点出圈
      first = first.getNext();
      helper.setNext(first); //

    }
    System.out.printf("最后留在圈中的节点编号%d \n", first.getNo());

  }

}


//创建一个Boy类，表示一个节点
class Boy {

  private int no;//编号
  private Boy next;//指向下一个节点，默认为空

  public Boy(int no) {
    this.no = no;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public Boy getNext() {
    return next;
  }

  public void setNext(Boy next) {
    this.next = next;
  }
}