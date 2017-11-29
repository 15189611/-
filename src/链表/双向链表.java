package 链表;

/**
 * Created by 666 on 2017/11/12.
 */
public class 双向链表 {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add("3");
        doubleLinkedList.add("5");
        doubleLinkedList.add("7");
        doubleLinkedList.add("8");
        doubleLinkedList.add("39");
        doubleLinkedList.add("34");
        doubleLinkedList.remove(2);
        for (int i = 0; i < doubleLinkedList.size; i++) {
            System.out.print("元素==" + doubleLinkedList.get(i));
        }
    }

    public static class DoubleLinkedList {
        private Node first;
        private Node last;
        private int size;

        class Node {
            private Node next; //下节点
            private Node prev; //前节点
            private Object object;

            public Node(Node prev, Node next, Object object) {
                this.next = next;
                this.prev = prev;
                this.object = object;
            }

        }

        //默认添加到尾部
        public void add(Object object) {
            Node l = last;
            Node node = new Node(l, null, object); //来的新元素
            if (l == null) {
                first = node;
            } else {
                l.next = node;
            }

            last = node;
            size++;
        }

        //根据下标找这
        public Object get(int index) {
            return getNode(index).object;
        }

        //删除元素

        public void remove(int index) {
            if (!isElementIndex(index)) {  //检查数组越界
                throw new IndexOutOfBoundsException();
            }

            Node node = getNode(index);

            unLinked(node);
        }

        private void unLinked(Node node) {

            Node next = node.next;
            Node pre = node.prev;

            //第一个元素
            if (pre == null) {
                first = next;
            } else {
                pre.next = next;
                node.prev = null;
            }
            //最后一个元素
            if (next == null) {
                last = pre;
            } else {
                next.prev = pre;
                node.next = null;
            }
            size--;
        }

        /**
         * 根据下标找到node
         */
        private Node getNode(int index) {
            if (!isElementIndex(index)) {  //检查数组越界
                throw new IndexOutOfBoundsException();
            }
            //分半查找
            if (index < (size >> 1)) {  // 如果是大小的一半之前,正序查找,否则倒序查找,提高效率
                Node f = first;
                for (int i = 0; i < index; i++) {
                    f = f.next;
                }
                return f;
            } else {  //从最后 往前面找 前节点
                Node l = last;
                for (int i = size - 1; i > index; i--) {
                    l = l.prev;
                }
                return l;
            }
        }

        /**
         * 检查数组越界
         */
        private boolean isElementIndex(int index) {
            return index >= 0 && index < size;
        }

        public int size() {
            return size;
        }
    }

}
