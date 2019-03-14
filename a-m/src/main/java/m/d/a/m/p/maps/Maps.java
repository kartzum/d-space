package m.d.a.m.p.maps;

public class Maps {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        MyMap<Integer, String> myMap1 = new MyMap<>();
        myMap1.put(1, "1");
        myMap1.put(2, "2");
        System.out.println(myMap1.get(1));
        System.out.println(myMap1.get(2));
        System.out.println(myMap1.get(3));
    }

    public static class MyMap<K, V> {
        private Entry<K, V>[] buckets;

        public MyMap() {
            buckets = new Entry[10];
        }

        void put(K key, V val) {
            Entry<K, V> entry = new Entry<>();
            entry.key = key;
            entry.val = val;

            int index = key.hashCode() % buckets.length;

            Entry<K, V> existing = buckets[index];

            if (existing == null) {
                buckets[index] = entry;
            } else {
                Entry<K, V> current = existing;
                while (current != null) {
                    if (current.key.equals(key)) {
                        current.val = val;
                        return;
                    }
                    current = current.next;
                }
                entry.next = existing;
                buckets[index] = entry;
            }
        }

        V get(K key) {
            int index = key.hashCode() % buckets.length;
            Entry<K, V> entry = buckets[index];
            while (entry != null) {
                if (key == entry.key) {
                    return entry.val;
                }
                entry = entry.next;
            }
            return null;
        }

        class Entry<K1, V1> {
            K1 key;
            V1 val;
            Entry<K1, V1> next;
        }
    }
}
