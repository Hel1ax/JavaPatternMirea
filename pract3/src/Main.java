import java.util.*;
import java.util.concurrent.Semaphore;

class ConcurrentMap<K, V>{
    private final Map<K, V> map = new HashMap<>();
    private final Semaphore semaphore = new Semaphore(1);
    public V put(K key, V value) {
        try {
            semaphore.acquire();
            return map.put(key, value);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        } finally {
            semaphore.release();
        }
    }
    public V remove(Object key) {
        try {
            semaphore.acquire();
            return map.remove(key);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        } finally {
            semaphore.release();
        }
    }
    public V get(Object key) {
        try {
            semaphore.acquire();
            return map.get(key);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        } finally {
            semaphore.release();
        }
    }
    public int size() {
        try {
            semaphore.acquire();
            return map.size();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return -1;
        } finally {
            semaphore.release();
        }
    }
    public boolean containsKey(Object key) {
        try {
            semaphore.acquire();
            return map.containsKey(key);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        } finally {
            semaphore.release();
        }
    }
}

// Потокобезопасная имплементация Set с использованием synchronized
class ConcurrentSet<E> {
    private final Set<E> set = Collections.synchronizedSet(new HashSet<>());

    public synchronized boolean add(E e) {
        return set.add(e);
    }

    public synchronized boolean remove(Object o) {
        return set.remove(o);
    }

    public synchronized int size() {
        return set.size();
    }

    public synchronized boolean isEmpty() {
        return set.isEmpty();
    }

    public synchronized Iterator<E> iterator() {
        return set.iterator();
    }

}

public class Main {
    public static void main(String[] args) {
        // Тестирование ConcurrentMap
        ConcurrentMap<String, Integer> concurrentMap = new ConcurrentMap<>();
        concurrentMap.put("One", 1);
        concurrentMap.put("Two", 2);
        concurrentMap.put("Three", 3);

        System.out.println("ConcurrentMap contains key 'One': " + concurrentMap.containsKey("One"));
        System.out.println("ConcurrentMap size: " + concurrentMap.size());

        // Тестирование метода remove
        concurrentMap.remove("Two");
        System.out.println("ConcurrentMap contains key 'Two' after removal: " + concurrentMap.containsKey("Two"));
        System.out.println("ConcurrentMap size after removal: " + concurrentMap.size());

        // Тестирование метода get
        System.out.println("Value for key 'Three': " + concurrentMap.get("Three"));

        // Тестирование ConcurrentSet
        ConcurrentSet<String> concurrentSet = new ConcurrentSet<>();
        concurrentSet.add("Apple");
        concurrentSet.add("Banana");
        concurrentSet.add("Orange");

        // Тестирование метода iterator
        System.out.print("ConcurrentSet elements: ");
        Iterator<String> iterator = concurrentSet.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}
