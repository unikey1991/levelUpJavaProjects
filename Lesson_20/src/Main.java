import ua.dp.levelup.list.doubleLinkedList.DoubleLinkedList;
import ua.dp.levelup.list.doubleLinkedList.NodeD;
import ua.dp.levelup.list.singleLinkedList.Node;
import ua.dp.levelup.list.singleLinkedList.SingleLinkedList;

public class Main {

    public static void main(String[] args) {
	// write our code here


        /*SingleLinkedList list = new SingleLinkedList();
        list.addLast(new Node(0));
        list.addLast(new Node(1));
        list.addLast(new Node(2));
        list.addLast(new Node(3));
        list.addLast(new Node(4));
        list.addLast(new Node(5));
        list.addNode(new Node(2.1),5);

        list.swap(1,4);

        list.get(4);*/

        DoubleLinkedList list = new DoubleLinkedList();
        list.addLast(new NodeD(0));
        list.addLast(new NodeD(1));
        list.addLast(new NodeD(2));
        list.addLast(new NodeD(3));
        list.addLast(new NodeD(4));
        list.addLast(new NodeD(5));
        list.addNode(new NodeD(2.1),5);

        list.swap(1,4);

        list.get(4);
    }
}
