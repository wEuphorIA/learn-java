/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/3 下午8:20 */
//单向链表
public class SinglyLinkedList { //整体
    private Node head =  null; //头指针
    //节点
    private static class Node{
        int data;   //数据
        Node next;  //指针

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    public void addFirst(int value){
        //1.链表为空的情况
        //head = new Node(value,null);
        //2.链表不为空的情况
        head = new Node(value,head);
    }
    public void loop(){

    }
}
