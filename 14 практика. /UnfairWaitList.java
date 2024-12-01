public class UnfairWaitList<E> extends WaitList<E> {
    public UnfairWaitList(){
        super();
    }
    @Override
    public void remove(E element){
        content.remove(element);
    }

    public void moveToBack(E element){
        if (content.remove(element)){
            content.add(element);
        }
    }

    @Override
    public String toString() {
        return "UnfairWaitList: " + content.toString();
    }

    @Override
    public E remove() {
        E element = content.poll();
        content.add(element);
        return element;
    }
}
