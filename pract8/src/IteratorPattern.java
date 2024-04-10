import java.util.ArrayList;
import java.util.List;

interface Iterator {
    boolean hasNext();
    String next();
}

// Агрегат
interface Aggregate {
    Iterator iterator();
}

// Конкретный агрегат
class ConcreteAggregate implements Aggregate {
    private List<String> items;

    public ConcreteAggregate() {
        this.items = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    private class ConcreteIterator implements Iterator {

        private int index;

        public ConcreteIterator() {
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < items.size();
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException("No more elements");
            }
            return items.get(index++);
        }
    }

    @Override
    public Iterator iterator() {
        return new ConcreteIterator();
    }
}

// Тесты
public class IteratorPattern {
    public static void main(String[] args) {
        ConcreteAggregate aggregate = new ConcreteAggregate();
        aggregate.addItem("Item 1");
        aggregate.addItem("Item 2");
        aggregate.addItem("Item 3");

        Iterator iterator = aggregate.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
