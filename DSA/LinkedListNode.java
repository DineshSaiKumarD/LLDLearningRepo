public class LinkedListNode {
     int data;
     LinkedListNode next;
}

class LinkedListExample {
    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode();
        head.data = 10;
        LinkedListNode second = new LinkedListNode();
        second.data = 20;
        head.next = second;
        LinkedListNode third = new LinkedListNode();
        third.data = 30;
        second.next = third;
//traverse the linked list
        LinkedListNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}


/*Definition of singly linked list: */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
        val = 0;
        next = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
    }

    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}


class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {

        if(head == null ){
            return null;
        }
        if(head.next == null){
            return head;
        }

        ListNode current =  head;
        ListNode prevNode = null;



        while(current != null){
            ListNode nextNode = current.next;
            current.next = prevNode;
            prevNode = current;
            current = nextNode;
        }

        return prevNode;

    }

    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);
        ListNode listNode = reverseLinkedList.reverseList(head);
        System.out.println("listNode "+listNode.val);
        printLinkedList(listNode);
    }

    public static void printLinkedList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
