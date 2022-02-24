package hashtable;

public class HashNode {
    DataItem[] hashArray;
    int arraySize;
    DataItem nonItem;

    public HashNode(int arraySize) {
        this.arraySize = arraySize;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);
    }

    DataItem find(int key) {
        int hash = hashFunction(key);
        while (hashArray[hash] != null) {
            if (hashArray[hash].getKey() == key) {
                return hashArray[hash];
            }
            ++hash;
            hash %= arraySize;
        }
        return null;
    }

    public void displayTable() {
        System.out.print("Table: \n");
        for (int i = 0; i < arraySize; i++) {
            if (hashArray[i] != null) {
                System.out.print(hashArray[i].getKey() + " ");
            } else {
                System.out.print("*** ");
            }
        }
    }

    private int hashFunction(int key) {
        return key % arraySize;
    }
    public int hashFunction1(int key) {
        return 2 - key % 2;
    }

    public void insert(int key, DataItem item) {
        int hashVal = hashFunction(key);
        int step = hashFunction1(key);
        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
            ++hashVal;
            hashVal += step;
            hashVal = hashVal % arraySize;
        }
        hashArray[hashVal] = item;
    }

    public DataItem delete(int key) {
        int hashVal = hashFunction(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                DataItem temp = hashArray[hashVal]; // Временное сохранение
                hashArray[hashVal] = nonItem;
                return temp;
            }
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }
    public String getTime(long ms) {
        long sec = ms / 1000;
        ms = ms % 1000;
        long min = sec / 60;
        sec = sec % 60;
        return min + " min. " + sec + " sec. " + ms + " ms.";
    }

    public static void main(String[] args) {
        HashNode node = new HashNode(5);
        for (int i = 0; i < 4; i++) {
            DataItem item = new DataItem(15);
            node.insert(15, item);
        }
            node.displayTable();
    }
}