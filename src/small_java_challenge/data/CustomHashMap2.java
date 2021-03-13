package small_java_challenge.data;

import java.util.Arrays;
import java.util.Objects;

/**
 * This is a Custom HashMap.
 * <p>
 * The purpose of this class was to finally, really understand the [CustomHashMap] class
 * that I created by watching a youtube video, but never really understood the fundamental functions
 * So I decided to recreate this class with the intent of coding it myself & documenting it so it is
 * understood in simpler ways.
 * </p>
 *
 * @author Kevin Germain
 */
public class CustomHashMap2<K, V> {

    private Entry<K, V>[] entriesTable;

    private int mapSize = 1; // arbitrary size I give by default

    public CustomHashMap2() {
        this.entriesTable = new Entry[mapSize];
    }

    public Entry<K, V>[] getEntriesTable() {
        return entriesTable;
    }

    /**
     * @param key   position of an Entry in the [entriesTable]
     *              [entriesTable] is this CustomHashMap2 class's only array of Entry.
     *              it is where we will put, get and remove Entry objects.
     *              [entryToPut] will point to an [Entry] in the [entriesTable]
     * @param value is the value that will match the key
     */
    public void put(K key, V value) {
        Objects.requireNonNull(key);
        Objects.requireNonNull(value);
        verifyIfMapSizeIncreaseIsNeeded();
        int entryKeyInTable = hashKey(key);
        Entry<K, V> entryToPut = entriesTable[entryKeyInTable];
        if (entryToPut == null) {
            // We create the Entry but without a pointer or in simpler terms without a next property
            entriesTable[entryKeyInTable] = new Entry<>(key, value);
        } else {
            // if entryToPut has a pointer which is what its next property is
            // loop through it to decide whether to replace its value or not
            while (entryToPut.next != null) {
                // Here this put function plays the role of a replace function
                // if entryToPut has a next Entry of which its key equals the key in this function
                // we will replace its value with the value in this function
                if (entryToPut.getKey() == key) {
                    entryToPut.setValue(value);
                    return;
                }
                entryToPut = entryToPut.next;
            }

            // if entryToPut doesn't have a pointer let's verify
            // whether we should replace its value or not
            if (entryToPut.getKey() == key) {
                entryToPut.setValue(value);
            }
            // Now let's make sure we add the new Entry<>(key, value) to entryToPut's pointer
            entryToPut.next = new Entry<>(key, value);
        }
    }

    /**
     * Totally my idea
     */
    public V get(K key) {
        Objects.requireNonNull(key);
        int entryKeyInTable = hashKey(key);
        Entry<K, V> entryToGet = entriesTable[entryKeyInTable];
        if (entryToGet == null) {
            return null;
        } else {
            return entryToGet.getValue();
        }
    }

    /**
     * Totally my idea
     */
    public Entry<K, V> remove(K key) {
        Objects.requireNonNull(key);
        int entryKeyInTable = hashKey(key);
        Entry<K, V> entryToRemove = entriesTable[entryKeyInTable];
        if (entryToRemove == null) throw new NullPointerException("The Object you are trying to remove doesn't exist");
        else {
            Entry<K, V> beforeRemoval = entryToRemove;
            // we'll make entryToRemove hold the Entry after it, before we remove it
            entryToRemove = entryToRemove.next;
            entriesTable[entryKeyInTable] = entryToRemove;

            return beforeRemoval;
        }
    }

    public int getMapSize() {
        return size();
    }

    private Long getEntriesTableSize() {
        return Arrays.stream(entriesTable).count();
    }

    private void verifyIfMapSizeIncreaseIsNeeded() {
        if (getEntriesTableSize() == 1) {
            mapSize = mapSize + 1;
            entriesTable = new Entry[mapSize];
        }
    }

    private int size() {
        return this.mapSize;
    }

    /**
     * In order to guarantee the uniqueness of each key
     * I created this function that gives each key a supposedly unique Hash
     *
     * @return Name Of the Key
     */
    private int hashKey(K key) {
        return key.hashCode() % size();
    }

    // Made protected in case I want to implement an Iterable later
    // Signed Kevin Germain
    protected static class Entry<K, V> {

        private final K key;
        private V value;
        private Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            Entry<K, V> temp = this;
            StringBuilder sb = new StringBuilder();
            while (temp != null) {
                sb.append(temp.key).append(" -> ").append(temp.value).append(", ");
                temp = temp.next;
            }
            return sb.toString();
        }
    }
}
