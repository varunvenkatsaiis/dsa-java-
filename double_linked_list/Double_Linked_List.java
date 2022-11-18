public class Double_Linked_List {
    Node head;
     int size = 0;
    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
    public void add_Node(int data  , int pos ){
            if(pos == 1){
                addFirst(data);
            }
            else if(pos >= size){
                add_Last(data);
            }
            else{
                if(head == null){
                    addFirst(data);
                }
                Node newNode = new Node(data);
                Node curr = head;
                int s = 1;
                while(s != pos){
                    curr = curr.next;
                    s++;
                }
                newNode.next = curr;
                newNode.prev = curr.prev;
                curr.prev.next = newNode;
                curr.prev =  newNode;

            }
            size++;
    }
    public void add_Last(int data){
            Node newNode = new Node(data);
            if(head == null){
                head = newNode;
            }
            else {
                Node curr = head;
                while (curr.next != null) {
                    curr = curr.next;
                }
                curr.next = newNode;
                newNode.prev = curr;
                newNode.next = null;
            }
            size++;
    }
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            newNode.prev = null;
            head = newNode;
        }
        size++;
    }
    public void PrintList(){
            Node curr = head;
            while(curr.next != null){
                System.out.print(curr.data +"-->");
                curr = curr.next;
            }
        System.out.print(curr.data +"-->");

    }
    public static void main(String[] args) {
        Double_Linked_List lis = new Double_Linked_List();
        lis.addFirst(48);
        lis.add_Last(4);
        lis.add_Last(8);
        lis.add_Last(12);
        lis.add_Node(24,3);
        System.out.println("size of a linked list is "+lis.size);
        lis.PrintList();
    }
    }



