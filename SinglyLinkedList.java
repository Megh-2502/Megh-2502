//SLL

import java.util.Scanner;

class SLL {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    Node first = null;

    void addFirst(int data) {
        Node newNode = new Node(data);
        if (first == null) {
            first = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }
    }

    void addLast(int data) {
        Node newNode = new Node(data);
        if (first == null) {
            first = newNode;
        } else {
            Node temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    void insertBeforeValue(int val, int data) {
        Node newNode = new Node(data);
        Node temp = first;
        if (first.data == val) {
            newNode.next = first;
            first = newNode;
        } else {
            while (temp.next != null && temp.next.data != val) {
                temp = temp.next;
            }
            if (temp.next == null && temp.data != val) {
                System.out.println("value not found");
            } else {
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }
    }

    void insertAfterValue(int data, int val) {
        Node newNode = new Node(data);
        Node temp = first;
        if (first.data == val) {
            newNode.next = first;
            first = newNode;
        } else {
            if (temp.next == null && temp.data == val) {
                temp.next = newNode;
            } else {
                while (temp.data != val) {
                    temp = temp.next;
                }
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }
    }

    void insertInOrder(int data) {
        Node newNode = new Node(data);
        if (first == null || first.data >= newNode.data) {
            newNode.next = first;
            first = newNode;
        } else {
            Node temp = first;
            while (temp.next != null && temp.next.data < newNode.data) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    void deleteFirst() {
        if (first == null) {
            System.out.println("Empty");
        } else {
            Node temp = first;
            first = first.next;
            temp.next = null;
        }
    }

    void deleteLast() {
        if (first == null) {
            System.out.println("Empty");
        } else if (first.next == null) {
            first = null;
        } else {
            Node temp = first;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
    }

    void deleteParticularValue(int data) {
        if (first == null) {
            System.out.println("Empty");
        } else if (first.data == data) {
            first = first.next;
        } else {
            Node temp = first;
            while (temp.next != null && temp.next.data != data) {
                temp = temp.next;
            }
            if (temp.next != null) {
                temp.next = temp.next.next;
            } else {
                System.out.println("value not found");
            }
        }
    }

    void deleteDuplicateValues() {
        Node temp1 = first;
        Node temp2 = null;
        Node dup = null;
        while (temp1 != null && temp1.next != null) {
            temp2 = temp1;
            while (temp2.next != null) {
                if (temp1.data == temp2.next.data) {
                    dup = temp2.next;
                    temp2.next = temp2.next.next;
                } else {
                    temp2 = temp2.next;
                }
            }
            temp1 = temp1.next;
        }

    }

    void deleteEvenValues() {
        Node prev = null;
        Node curr = first;
        while (curr != null) {
            if (curr.data % 2 == 0) {
                if (prev != null) {
                    prev.next = curr.next;
                } else {
                    first = curr.next;
                }
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
    }

    void deleteOddValues() {
        Node prev = null;
        Node curr = first;
        while (curr != null) {
            if (curr.data % 2 != 0) {
                if (prev != null) {
                    prev.next = curr.next;
                } else {
                    first = curr.next;
                }
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
    }

    void deleteOddPositionedNodes() {
        Node temp = first;
        while (temp != null && temp.next != null) {
            temp.next = temp.next.next;
            temp = temp.next;
        }
    }

    void deleteEvenPositionedNodes() {
        Node temp = first.next;
        while (temp != null && temp.next != null) {
            temp.next = temp.next.next;
            temp = temp.next;
        }
    }

    void display() {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.print("null");
    }
}

public class SinglyLinkedList {
    public static void main(String[] args) {
        SLL s = new SLL();
        int ch;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("1. Add first");
            System.out.println("2. Add last");
            System.out.println("3. Add before value");
            System.out.println("4. Add after value");
            System.out.println("5. Insert in order");
            System.out.println("6. Delete first");
            System.out.println("7. Delete last");
            System.out.println("8. Delete particular value");
            System.out.println("9. Delete duplicate values");
            System.out.println("10. Delete even values");
            System.out.println("11. Delete odd values");
            System.out.println("12. Delete odd positioned nodes");
            System.out.println("13. Delete even positioned nodes");
            System.out.println("14. Display");
            System.out.println("Enter your choice");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("enter number: ");
                    int n = sc.nextInt();
                    s.addFirst(n);
                    break;

                case 2:
                    System.out.println("enter number: ");
                    int n1 = sc.nextInt();
                    s.addLast(n1);
                    break;

                case 3:
                    System.out.println("enter number: ");
                    int n2 = sc.nextInt();
                    System.out.println("enter value before which you want to insert: ");
                    int v = sc.nextInt();
                    s.insertBeforeValue(v, n2);
                    break;

                case 4:
                    System.out.println("enter number: ");
                    int n3 = sc.nextInt();
                    System.out.println("enter value after which you want to insert: ");
                    int v1 = sc.nextInt();
                    s.insertAfterValue(n3, v1);
                    break;

                case 5:
                    System.out.println("enter number: ");
                    int n4 = sc.nextInt();
                    s.insertInOrder(n4);
                    break;

                case 6:
                    s.deleteFirst();
                    break;

                case 7:
                    s.deleteLast();
                    break;

                case 8:
                    System.out.println("enter number: ");
                    int n5 = sc.nextInt();
                    s.deleteParticularValue(n5);
                    break;

                case 9:
                    s.deleteDuplicateValues();
                    break;

                case 10:
                    s.deleteEvenValues();
                    break;

                case 11:
                    s.deleteOddValues();
                    break;

                case 12:
                    s.deleteOddPositionedNodes();
                    break;

                case 13:
                    s.deleteEvenPositionedNodes();
                    break;

                case 14:
                    s.display();
                    break;
            }
        } while (ch != 15);
    }
}
