import java.util.Scanner;

public class MultiplicationHashing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the hash table: ");
        int tableSize = scanner.nextInt();

        int[] hashTable = new int[tableSize];
        for (int i = 0; i < tableSize; i++) {
            hashTable[i] = -1; // Initialize all slots to -1 (indicating empty)
        }

        System.out.print("Enter the number of keys: ");
        int numKeys = scanner.nextInt();

        System.out.println("Enter the keys:");
        for (int i = 0; i < numKeys; i++) {
            int key = scanner.nextInt();
            insertWithCollisionHandling(hashTable, key, tableSize);
        }

        displayHashTable(hashTable);

        scanner.close();
    }

    private static void insertWithCollisionHandling(int[] hashTable, int key, int tableSize) {
        double A = 0.61803398875; // A common choice for the constant

        int index = (int) (tableSize * ((key * A) % 1));

        // Linear probing to handle collisions
        while (hashTable[index] != -1) {
            index = (index + 1) % tableSize;
        }

        hashTable[index] = key;
    }

    private static void displayHashTable(int[] hashTable) {
        System.out.println("Hash Table:");
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != -1) {
                System.out.println("Index " + i + ": " + hashTable[i]);
            } else {
                System.out.println("Index " + i + ": Empty");
            }
        }
    }
}
