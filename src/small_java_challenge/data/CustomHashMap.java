package small_java_challenge.data;

import interfaces.NotFullyUnderstoodYet;

import java.util.Objects;

/**
 * Original version, not made by me
 */
public class CustomHashMap<K, V> {

    private final int SIZE = 5;

    private final Entry<K, V>[] entriesTable;

    public CustomHashMap() {
        this.entriesTable = new Entry[SIZE];
    }

    public Entry<K, V>[] getEntriesTable() {
        return entriesTable;
    }

    public void put(K key, V value) {
        Objects.requireNonNull(key);
        Objects.requireNonNull(value);
        int hash = key.hashCode() % SIZE;
        Entry<K, V> entry = entriesTable[hash];
        if (entry == null) {
            entriesTable[hash] = new Entry<>(key, value);
        } else {
            while (entry.next != null) {
                if (entry.getKey() == key) {
                    entry.setValue(value);
                    return;
                }
                entry = entry.next;
            }

            if (entry.getKey() == key) {
                entry.setValue(value);
                return;
            }
            entry.next = new Entry<>(key, value);
        }
    }

    public V get(K key) {
        Objects.requireNonNull(key);
        int hash = key.hashCode() % SIZE;
        Entry<K, V> entry = entriesTable[hash];

        if (entry == null) return null;

        while (entry != null) {
            if (entry.getKey() == key) {
                return entry.getValue();
            }
            entry = entry.next;
        }
        return null;
    }

    public Entry<K, V> remove(K key) {
        Objects.requireNonNull(key);
        int hash = key.hashCode() % SIZE;
        Entry<K, V> entry = entriesTable[hash];
        if (entry == null) return null;

        if (entry.getKey() == key) {
            entriesTable[hash] = entry.next;
            entry.next = null;
            return entry;
        }
        Entry<K, V> previous = entry;
        entry = entry.next;

        while (entry != null) {
            if (entry.getKey() == key) {
                previous.next = entry.next;
                entry.next = null;
                return entry;
            }
            entry = entry.next;
        }

        return null;
    }

    private static class Entry<K, V> {

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
