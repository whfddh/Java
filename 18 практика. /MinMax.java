public class MinMax <T extends Comparable<T>> {
    private T[] array;

    public MinMax(T[] array) {
        this.array = array;
    }

    public T findMin() {
        if (array == null || array.length == 0) {
            return null;
        }
        T min = array[0];
        for (T t : array) {
            if (t.compareTo(min) < 0) {
                min = t;
            }
        }
        return min;
    }
    public T findMax(){
        if (array == null || array.length == 0) {
            return null;
        }
        T max = array[0];
        for (T t : array) {
            if (t.compareTo(max) < 0) {
                max = t;
            }
        }
        return max;
    }



}
