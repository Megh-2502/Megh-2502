import java.util.Scanner;
import java.util.Random;

class goodHashFunction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\t\t\t\t======================================================================");
            System.out.println("");
            System.out.println("\t\t\t\t\t\t\t1. Division Remainder Method");
            System.out.println("\t\t\t\t\t\t\t2. Multiplication Method");
            System.out.println("\t\t\t\t\t\t\t3. MidSquare Method");
            System.out.println("\t\t\t\t\t\t\t4. Exit");
            System.out.print("\t\t\t\t\t\t\tEnter your choice: ");
            choice = sc.nextInt();
            System.out.println("");
            System.out.println("\t\t\t\t======================================================================");
            switch (choice) {
                case 1:
                    System.out.println("\t\t\t\t\t\t\tDivision Remainder Method");
                    divisionRemainder();
                    break;
                case 2:
                    System.out.println("\t\t\t\t\t\t\tMultiplication Method");
                    multiplicationHash();
                    break;
                case 3:
                    System.out.println("\t\t\t\t\t\t\tMidSquare Method");
                    midSquare();
                    break;
                case 4:
                    System.out.println("\t\t\t\t\t\t\tExiting....");
                    System.out.println();
                    System.out.println("\t\t\t\t-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-");
                    break;

                default:
                    break;
            }
        } while (choice != 4);
    }

    static void divisionRemainder() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\t\t\t\t\t\t\tEnter size of hashTable: ");
        int table_size = sc.nextInt();
        int hashTable[] = new int[table_size];
        for (int i = 0; i < table_size; i++) {
            hashTable[i] = -1;
        }
        System.out.print("\t\t\t\t\t\t\tHow many key you want to enter: ");
        int nkey = sc.nextInt();
        if (nkey > table_size) {
            System.out.println("\t\t\t\t\t\t\tInvalid");
            return;
        } else {
            for (int i = 0; i < nkey; i++) {
                System.out.println("");
                System.out.print("\t\t\t\t\t\t\tEnter Key: ");
                int key = sc.nextInt();
                int index = key % table_size;
                while (hashTable[index] != -1) {
                    index = (index + 1) % table_size;
                }
                hashTable[index] = key;
            }
        }
        System.out.println("");
        System.out.println("\t\t\t\t\t\t\tHash Table:");
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != -1) {
                System.out.println("\t\t\t\t\t\t\tIndex " + i + ": " + hashTable[i]);
            } else {
                System.out.println("\t\t\t\t\t\t\tIndex " + i + ": Empty");
            }
        }
    }

    static void multiplicationHash() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\t\t\t\t\t\t\tEnter size of hashTable: ");
        int table_size = sc.nextInt();
        int hashTable[] = new int[table_size];
        for (int i = 0; i < table_size; i++) {
            hashTable[i] = -1;
        }
        System.out.print("\t\t\t\t\t\t\tHow many key you want to enter: ");
        int nkey = sc.nextInt();
        if (nkey > table_size) {
            System.out.println("\t\t\t\t\t\t\tInvalid");
            return;
        } else {
            Random op = new Random();
            double random = op.nextDouble(0, 1);
            for (int i = 0; i < nkey; i++) {
                System.out.print("\t\t\t\t\t\t\tEnter Key: ");
                int key = sc.nextInt();
                int index = (int) (table_size * ((key * random) % 1));
                while (hashTable[index] != -1) {
                    index = (index + 1) % table_size;
                }
                hashTable[index] = key;
            }
        }
        System.out.println("");
        System.out.println("\t\t\t\t\t\t\tHash Table:");
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != -1) {
                System.out.println("\t\t\t\t\t\t\tIndex " + i + ": " + hashTable[i]);
            } else {
                System.out.println("\t\t\t\t\t\t\tIndex " + i + ": Empty");
            }
        }
    }

    static void midSquare() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\t\t\t\t\t\t\tEnter size of hashTable: ");
        int table_size = sc.nextInt();
        int hashTable[] = new int[table_size];
        for (int i = 0; i < table_size; i++) {
            hashTable[i] = -1;
        }
        System.out.print("\t\t\t\t\t\t\tHow many key you want to enter: ");
        int nkey = sc.nextInt();
        if (nkey > table_size) {
            System.out.println("\t\t\t\t\t\t\tInvalid");
            return;
        } else {
            for (int i = 0; i < nkey; i++) {
                System.out.print("\t\t\t\t\t\t\tEnter Key: ");
                int key = sc.nextInt();
                long squareKey = (long) key * key;
                // System.out.println(squareKey);
                String strsqKey = Long.toString(squareKey);
                // System.out.println(strsqKey);
                int length = strsqKey.length();
                int index = 0;
                if (length > 5) {
                    int middleIndex = length / 2;
                    String middleElements = strsqKey.substring(middleIndex - 1, middleIndex + 2);
                    index = Integer.parseInt(middleElements);
                    System.out.println("Index is : " + index);
                } else {
                    index = strsqKey.length() - 1;
                }
                while (hashTable[index] != -1) {
                    index = (index + 1) % table_size;
                }
                hashTable[index] = key;
            }
            System.out.println("");
            System.out.println("\t\t\t\t\t\t\tHash Table:");
            for (int i = 0; i < hashTable.length; i++) {
                if (hashTable[i] != -1) {
                    System.out.println("\t\t\t\t\t\t\tIndex " + i + ": " + hashTable[i]);
                } else {
                    System.out.println("\t\t\t\t\t\t\tIndex " + i + ": Empty");
                }
            }
        }
    }
}