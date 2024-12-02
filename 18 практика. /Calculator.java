public class Calculator {
    public static <T extends Number> T sum(T a, T b) {
        if (a instanceof Double || b instanceof Double) {
            return (T) (Double) (a.doubleValue() + b.doubleValue());
        } else if (a instanceof Float || b instanceof Float) {
            return (T) (Float) (a.floatValue() + b.floatValue());
        } else if (a instanceof Long || b instanceof Long) {
            return (T) (Long) (a.longValue() + b.longValue());
        } else {
            return (T) (Integer) (a.intValue() + b.intValue());
        }
    }

    public static <T extends Number> T multiply(T a, T b) {
        if (a instanceof Double || b instanceof Double) {
            return (T) (Double) (a.doubleValue() * b.doubleValue());
        } else if (a instanceof Float || b instanceof Float) {
            return (T) (Float) (a.floatValue() * b.floatValue());
        } else if (a instanceof Long || b instanceof Long) {
            return (T) (Long) (a.longValue() * b.longValue());
        } else {
            return (T) (Integer) (a.intValue() * b.intValue());
        }
    }

    public static <T extends Number> T divide(T a, T b) {
        if (b.doubleValue() == 0.0) {
            throw new ArithmeticException("Division by zero");
        }

        if (a instanceof Double || b instanceof Double) {
            return (T) (Double) (a.doubleValue() / b.doubleValue());
        } else if (a instanceof Float || b instanceof Float) {
            return (T) (Float) (a.floatValue() / b.floatValue());
        } else if (a instanceof Long || b instanceof Long) {
            return (T) (Long) (a.longValue() / b.longValue());
        } else {
            return (T) (Integer) (a.intValue() / b.intValue());
        }
    }

    public static <T extends Number> T subtraction(T a, T b) {
        if (a instanceof Double || b instanceof Double) {
            return (T) (Double) (a.doubleValue() - b.doubleValue());
        } else if (a instanceof Float || b instanceof Float) {
            return (T) (Float) (a.floatValue() - b.floatValue());
        } else if (a instanceof Long || b instanceof Long) {
            return (T) (Long) (a.longValue() - b.longValue());
        } else {
            return (T) (Integer) (a.intValue() - b.intValue());
        }
    }

    public static void main(String[] args) {
        Integer[] intArray = {3, 8, 11, 7, 6, 5};
        MinMax<Integer> intMinMax = new MinMax<>(intArray);
        Integer minInt = intMinMax.findMin();
        Integer maxInt = intMinMax.findMax();
        System.out.println("Min Integer: " + minInt);
        System.out.println("Max Integer: " + maxInt);

        Double[] doubleArray = {3.5, 8.2, 1.7, 7.8, 6.1, 5.6};
        MinMax<Double> doubleMinMax = new MinMax<>(doubleArray);
        Double minDouble = doubleMinMax.findMin();
        Double maxDouble = doubleMinMax.findMax();
        System.out.println("Min Double: " + minDouble);
        System.out.println("Max Double: " + maxDouble);

        int a = 10;
        int b = 5;
        double x = 7.5;
        double y = 2.5;

        int sumResult = Calculator.sum(a, b);
        double divideResult = Calculator.divide(x, y);
        double subtraction = Calculator.subtraction(x,y);
        System.out.println("Sum Result: " + sumResult);
        System.out.println("Divide Result: " + divideResult);
        System.out.println("Subtraction Result: " + subtraction);
    }
}
