public class AnyType<T>{
    private Object[] array;

    public AnyType(int size){
        array = new Object[size];
    }

    public void set(int index, T value){
        array[index] = value;
    }
    public T get(int index){
        return (T) array[index];
    }

    public int length(){
        return array.length;
    }

    public static void main(String[] args){
        AnyType<Integer> str1 = new AnyType<>(3);
        str1.set(0, 13);
        str1.set(1, 14);
        str1.set(2, 15);

        for (int i = 0; i < str1.length(); i++){
            System.out.println(str1.get(i));
        }

        System.out.print("\n");

        AnyType<String> str2 = new AnyType<>(2);
        str2.set(0, "jas");
        str2.set(1, "a");

        for (int i = 0; i < str2.length(); i++){
            System.out.println(str2.get(i));
        }
        AnyType<Boolean> str3 = new AnyType<>(3);
        str3.set(0, true);
        str3.set(1, false);
        str3.set(2, false);

        for (int i = 0; i < str3.length(); i++){
            System.out.println(str3.get(i));
        }

        AnyType<Character> str4 = new AnyType<>(1);
        str4.set(0, 'C');

        for (int i = 0; i < str4.length(); i++){
            System.out.println(str4.get(i));
        }
    }
}
