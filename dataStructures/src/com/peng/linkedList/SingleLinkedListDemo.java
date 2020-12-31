package com.peng.linkedList;

/**
 * @Author sp
 * @Description
 * @create 2020-12-11 15:56
 * @Modified By:
 */
public class SingleLinkedListDemo {

  public static void main(String[] args) {
    Node node1 = new Node(1, "宋江", "及时雨");
    Node node2 = new Node(2, "卢俊义", "玉麒麟");

    SingleLinkedList singleLinkedList = new SingleLinkedList();
    singleLinkedList.add(node1);
    singleLinkedList.add(node2);
    singleLinkedList.list();
  }

}

//定义SingleLinkedList
class SingleLinkedList {

  public Node getHead() {
    return head;
  }

  //初始化一个头节点，头节点不要动
  private Node head = new Node(0, "", "");

  //添加节点到单向链表
  public void add(Node node) {
    //头节点不动，建立一个辅助节点
    Node temp = head;
    //遍历链表，找到最后
    while (true) {
      //找到链表的最后
      if (temp.next == null) {
        break;
      }
      //如果不是最后 ,后移，直到找到
      temp = temp.next;
    }
    //当退出while循环时，temp就指向了链表的最后
    temp.next = node;
  }

  public void addByNo(Node node) {
    Node temp = head;
    boolean flag = false;//标识添加的编号是否存在，存在则插入不了
    while (true) {
      if (temp.next == null) {
        break;
      }
      if (temp.next.no > node.no) {
        break;
      } else if (temp.next.no == node.no) {
        flag = true;
        break;
      }
      temp = temp.next;
    }
    //判断flag的值
    if (flag) {
      System.out.printf("准备插入的节点的编号%d 已经存在，不能加入\n");
    } else {
      //插入到链表中
      node.next = temp.next;
      temp.next = node;
    }
  }
  //删除节点
  //找到待删除节点的前一个节点
  public void del(int no){
    Node temp = head;
    boolean flag = false;//标志是否找到该删除节点
    while (true){
      if (temp.next == null){
        break;
      }if (temp.next.no == no){
        //找到待删除节点的前一个节点
        flag = true;
        break;
      }temp = temp.next;

    }
    if (flag){//找到
      temp.next = temp.next.next;
    }else {
      System.out.printf("删除的节点%d不存在",no);
    }
  }


  //修改节点信息，根据no号修改，即no编号不能改
  public void update(Node newNode){
    //判断链表为空
    if (head.next == null){
      System.out.println("链表为空~");
      return;
    }

    //找到需要修改的节点，根据no号
    //定义一个辅助变量
    Node temp = head.next;
    boolean flag = false;//表示是否找到该节点

    while (true){
      if (temp == null){
        break;
      }
      if (temp.no == newNode.no){
        flag = true;
        break;
      }
      temp = temp.next;
    }
    //根据flag判断是否找到要修改的节点
    if (flag){
      temp.name = newNode.name;
      temp.nickName = newNode.nickName;
    }else {
      System.out.printf("没有找到编号为%d 的节点，不能修改\n",newNode.no);
    }
  }
  //显示链表【遍历】法
  public void list() {
    //判断链表是否为空
    if (head.next == null) {
      System.out.println("链表为空");
      return;
    }
    Node temp = head.next;
    while (true) {
      //判断是否到最后
      if (temp == null) {
        break;
      }
      System.out.println(temp);
      temp = temp.next;
    }
  }
  //将单链表反转
  public static void reversetList(Node head){
    //如果当前链表为空，或者只有一个节点，无需反转，直接返回
    if (head.next==null||head.next.next==null){
      return;
    }
    //定义一个辅助的指针(变量)，帮助我们遍历原来的链表
    Node cur = head.next;
    Node next = null;//指向当前节点下一个节点
    Node reverseHeaad = new Node(0,"","");
    //遍历原来的链表，
    //每遍历一个节点，就将其取出，并放在新的链表reverseHead的最前端
    while (cur!=null){
      next = cur.next;//先暂时保存当前节点的下一个节点，因为后面使用
      cur.next = reverseHeaad.next;//将上次反转节点的临近节点位置给当前节点下一个位置，因为反转节点的下一个节点是最新遍历的节点，要把原先第一个节点的位置给当前节点的next
      reverseHeaad.next = cur;//将cur连接到反转节点的下一个位置
      cur = next;//让cur后移
    }//将head.next 指向reverseHead.next,实现单链表的反转
    head.next = reverseHeaad.next;
  }
  //查找单练表中的倒数的第k个节点
  public static Node findLastIndexNode(Node head,int index){
    if (head.next == null){
      return null;
    }
    int size = getLength(head);
    if (index<=0||index>size){
      return null;
    }
    Node currentNode = head;
    for (int i = 0; i <size - index ; i++) {
      currentNode = currentNode.next;
    }
    return currentNode;
  }
  //获取单链表的节点的个数(不包括头节点)
  public static int getLength(Node head){
    if (head.next ==null){
      return 0;
    }
    int length = 0;
    Node currentNode = head.next;
    while (currentNode!=null){
      length++;
      currentNode = currentNode.next;
    }
    return length;
  }
}


//定义一个Node，每个Node对象就是一个节点
class Node {

  public int no;
  public String name;
  public String nickName;
  public Node next;//指向下一个节点

  //构造器
  public Node(int no, String name, String nickName) {
    this.no = no;
    this.name = name;
    this.nickName = nickName;
  }

  @Override
  public String toString() {
    return "Node{" +
        "no=" + no +
        ", name='" + name + '\'' +
        ", nickName='" + nickName + '\'' +
        '}';
  }
}
