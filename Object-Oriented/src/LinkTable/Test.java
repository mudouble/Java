package LinkTable;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        MyLinkList<String>  linkList = new MyLinkList<>();
        MyLinkList.Node<String> head = linkList.add();
        linkList.forEach(head);
        MyLinkList.Node<String> head1 = linkList.reverse(head, 2,4);
        linkList.forEach(head1);
    }
}
