public class BoundedWaitList<E> extends WaitList<E> {
    private int capacity;

    public BoundedWaitList(int capacity){
        super();
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public void add(E element) {
        if (content.size() < capacity){
            super.add(element);
        }
    }

    @Override
    public void remove(E element) {

    }

    @Override
    public E remove() {
        return content.poll();
    }

    @Override
    public void moveToBack(E element) {

    }


    @Override
    public String toString() {
        return "BoundedWaitList (capacity: " + capacity + "): " + content.toString();
    }
}
