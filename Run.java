import java.util.*;
class User{
    String bookName;
    int totalQuantity;
    int availableQuantity;
    public User(String bookName, int totalQuantity, int availableQuantity) {
        this.bookName = bookName;
        this.totalQuantity = totalQuantity;
        this.availableQuantity = availableQuantity;
    }
    @Override
    public String toString() {
        return "User [bookName=" + bookName + ", totalQuantity=" + totalQuantity + ", availableQuantity="
                + availableQuantity + "]";
    }
    
}
class BSMS {
    class Node //created a node which contains a data and refrence// 
        {
            User data; //the node will have a data of integer type//
            Node next; //it will have a reference variable//

            Node(User data) //created a constructor to create a node//
            {
                this.data = data; //the value of data will be same as entered by user//
                this.next = null; //the next pointer of the node will initialized with null//
            }
        }
        Node first = null;
        void insertBook(User data) //created a method to Insert a Node at Last//
        {
            Node n = new Node(data); //In insert method we always required to create a node//
            if (first == null) //checking if LinkedList is empty or not//
            {
                first = n; //if yes then first shall be directly pointing to n// 
                n.next = n; //and new node's next should be pointing n due to CLL//
            }
            else //otherwise//
            {
                Node temp = first; //created a temp node with the same value as first//
                while (temp.next != first)  //until we get the temp's next = null this loop will run//
					temp = temp.next;
                temp.next = n; //now temp's next which is showing old first shall be pointing n//
                n.next = first; //new node n's next shall be equal to first//
            }
            System.out.println(data+" is inserted Last");
        }
        void deldatavalue(User data) {
    int flag = 0;
    if (first == null) {
        System.out.println("Empty Circular Linked List, So can't delete value.");
    } else {
        Node temp = first;
        do {
            if (temp.data.bookName.trim().equals(data.bookName.trim())) {
                flag = 1;
                break;  // Found the book to delete, no need to continue the loop
            }
            temp = temp.next;
        } while (temp != first);
        
        if (flag == 1) {
            if (first.data.bookName.trim().equals(data.bookName.trim()) && first.next == first) {
                first = null;
            } else if (first.data.bookName.trim().equals(data.bookName.trim()) && first.next != first) {
                Node del = first;
                while (temp.next != first) {
                    temp = temp.next;
                }
                temp.next = first.next;
                first = first.next;
                del.next = null;
            } else {
                while (temp.next.data.bookName.trim().equals(data.bookName.trim())) {
                    temp = temp.next;
                }
                temp.next = temp.next.next;
            }
            System.out.println(data.bookName + " deleted.");
        } else {
            System.out.println("Book not found.");
        }
    }
}

        void display() //created a method to display the data of CircularLinkedList//
		{
            if(first == null) //checking if LinkedList is empty or not//
            {
                System.out.println("Empty");
            }
            else
            {
                Node temp = first; //created a temp node with the same value as first//
                while (temp.next != first) //until we get the temp's next = null this loop will run//
				{
                    System.out.print("["+temp.data.bookName+"]"+ "-"); //temp's data get printed//
                    temp = temp.next;
                }
                System.out.print("["+temp.data.bookName+"]");
            }
        }
       
}
public  class Run extends BSMS{
     public static void main(String[] args) throws Exception{
            BSMS bookStore=new BSMS();
            Scanner sc=new Scanner(System.in);
            for(int i=0;i<3;i++)
            {         
            System.out.println("Enter name of book: ");
            String bname = sc.next();
            //sc.nextLine();
            System.out.println("Enter quantity: ");
            int quantity=sc.nextInt();
            bookStore.insertBook(new User(bname, quantity, quantity));
            }
            bookStore.display();
            System.out.println();
            System.out.println("Enter book name to delete: ");
            String dname=sc.next();            
            bookStore.deldatavalue(new User(dname,0,0));
            System.out.println();
            bookStore.display();
        }
} 