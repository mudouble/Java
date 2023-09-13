package LinkTable;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyLinkList<E> {
    private int size;
    public static class Node<E>{
        E data;
        Node<E> next;


        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;

        }
    }

    public Node<E> add(){
        Node<E> head=null;
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("请输入当前节点的数据值，退出输入exit");
            String  data = sc.next();
            if (data.equals("exit")){
                break;
            }
            if (head==null){
                head = new Node(data, null);  //这里不用加上<>，这是因为定义了泛型
                size++;
            }else{
                //往后插入节点
                Node<E> temp = head;
                //让temp走到尾部节点，这样才可以在尾部加上新的节点
                while (temp.next!=null){
                    temp = temp.next;
                }
                temp.next = new Node(data, null);
                size++;
            }

        }
        return head;
    }

    public Node<E> reverse(Node<E> head,int left, int right){
        if (head == null || left<1 || right<1 || left>size || right>size || left>=right){
            return head;
        }

        //找到左节点，遍历左节点到右节点，将数据存入集合
        Node<E> first = head;
        Node<E> mark = null;
        int index = 0;
        List<E> data = new ArrayList<>();
        while(head!=null){
            index++;
            if (index==left){
                mark = head;
            }
            //保存相应的值，然后进行修改
            if (index>=left && index<=right){
                data.add(head.data);
            }
            if (index==right)break;
            head = head.next;
        }
        for (int i = data.size()-1; i >=0; i--) {
            E e = data.get(i);
            mark.data = e;
            mark = mark.next;
        }
        return first;

    }

    public void forEach(Node<E> head){
        if (head==null){
            System.out.println(head);
            return;
        }
        Node<E> node = head;  //函数可以不用保存
        while(node!=null){
            System.out.print(node.data+" ");
//            System.out.println(node.data);
            node = node.next;
        }
        System.out.println();
    }

}
