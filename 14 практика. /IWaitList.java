import javax.lang.model.element.Element;
import java.util.Collection;

public interface IWaitList<E> {
    void add(E element);
    E remove();
    boolean contains(E element);
    boolean containsAll(Collection<E> c);

    boolean isEmpty();
    void remove(E element);

    void moveToBack(E element);
}
