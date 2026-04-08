package LL;


class InserinDLL {
    public ListNode insertBeforeTail(ListNode head, int X) {

        if(head == null) return new ListNode(X);

        ListNode temp = head;


        while(temp.next != null){

            temp = temp.next;
        }


        ListNode prev = temp.prev;


        ListNode newNode = new ListNode(X);

        prev.next = newNode;

        temp.prev = newNode;

        newNode.next = temp;

        System.out.println("prev " + prev.val + " next " + temp.val + " newNode " + newNode.val);

        return head;

    }


    public static void main(String[] args) {

        //input 1 2 4 in double linked list

        ListNode head = new ListNode(1);

        head.next = new ListNode(2);
        head.next.next = new ListNode(4);

        InserinDLL ins = new InserinDLL();
        ListNode listNode = ins.insertBeforeTail(head, 3);
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    ListNode() {
        val = 0;
        next = null;
        prev = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
        prev = null;
    }

    ListNode(int data1, ListNode next1, ListNode prev1) {
        val = data1;
        next = next1;
        prev = prev1;
    }
}

