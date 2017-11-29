package 链表;

/**
 * Created by 666 on 2017/11/12.
 */
public class 单向链表 {
    public static void main(String[] args){
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add("3");
        myLinkedList.add("7");
        myLinkedList.add("34");
        myLinkedList.add("23");
        myLinkedList.add("39");
        myLinkedList.add("9");
        myLinkedList.add("10");
        myLinkedList.add(1,"12");

        myLinkedList.remove(2);
        for (int i = 0; i < myLinkedList.getSize(); i++){
            System.out.println(myLinkedList.getObject(i));
        }


    }

    public static class MyLinkedList{
        private int size ;
        private Node head = new Node();
        class Node{
            private Node next;
            private Object object;

            public Node(Object object) {
                this.object = object;
            }

            public Node() {
            }
        }

        private void add(Object obj){
            Node node = new Node(obj);
            Node lastNode = getLastNode();
            lastNode.next = node;
            size ++;
        }

        private void add(int index ,Object obj){
            Node node = new Node(obj);
            Node last = head;
            for (int i = 0 ; i < index; i++){
                last = last.next;
            }
            node.next = last.next;    //找到要插入的位置，然后放入进去
            last.next = node;
            size ++;
        }

        private Node getLastNode() {
            Node last = head;
            while (last.next != null){
                last = last.next;
            }
            return last;
        }

        private void remove(int index){
            Node last = head;
            for (int i = 0; i < index ;i++){
                last = last.next;  //从下标0 开始遍历，找到要删元素的 上一个元素
            }
            last.next = last.next.next;
            size --;
        }

        private Object getObject(int index){ //根据下标找元素
            if(index > size){
                throw new IndexOutOfBoundsException("索引越界");
            }

            Node last = head;
            for (int i = 0; i <= index;i++){
                last = last.next;
            }
            return last.object;
        }

        private int getSize(){
            return size;
        }

    }

}
