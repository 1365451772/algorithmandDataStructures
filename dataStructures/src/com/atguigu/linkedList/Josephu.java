package com.atguigu.linkedList;

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
    circleSingleLinkedList.addBoy(125);// 加入5个小孩节点
    circleSingleLinkedList.showBoy();

    //测试一把小孩出圈是否正确
//    circleSingleLinkedList.countBoy(10, 20, 125); // 2->4->1->5->3
//    //String str = "7*2*2le-5+1-5+3-3";
  }

}



//创建一个环形的单向链表
class CircleSingleLinkedList {
  //创建一个first节点
  private Boy first = null;
  //添加Boy节点，构建成一个环形的链表
  public void addBoy(int nums){
    //nums 做一个数据校验
    if (nums < 2 ){
      System.out.println("nums的值不正确");
      return;
    }
    Boy curBoy = null;//辅助指针，帮助构建环形列表
    //使用for循环来创建我们的环形列表
    for (int i = 1;i<=nums;i++){
        //根据编号，创建节点
      Boy boy = new Boy(i);
      //如果是第一个节点
      if (i == 1){
        first = boy;
        first.setNext(first);
        curBoy = first;
      }else {
        boy.setNext(first);
        curBoy.setNext(boy);
        curBoy = boy;
      }

    }
  }

  //遍历循环单链表
  public void showBoy(){
    //判断链表是否为空
    if (first == null){
      System.out.println("链表为空");
      return;
    }
    //first不动，创建辅助指针遍历
    Boy curBoy = first;
    while (true){
      System.out.printf("节点的编号%d\n",curBoy.getNo());
      if (curBoy.getNext() == first){//遍历完毕
        break;
      }
      curBoy = curBoy.getNext();//指针后移
    }
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