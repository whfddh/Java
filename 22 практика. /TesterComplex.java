public class TesterComplex {

    public static void main(String[] args) {
        TesterComplex test = new TesterComplex();
        test.testComplexCreation();
        test.testComplexAddition();
        test.testComplexSubtraction();
        test.testFactoryCreation();
        test.testFactoryCreationWithParameters();
    }

    public void testComplexCreation() {
        Complex complex = new Complex(4, 3);

        if (complex.getReal() == 3 && complex.getImage() == 4 && "3 + 4i".equals(complex.toString())) {
            System.out.println("Test testComplexCreation passed.");
        } else {
            System.err.println("Test testComplexCreation failed.");
        }
    }

    public void testComplexAddition() {
        Complex complex1 = new Complex(3, 4);
        Complex complex2 = new Complex(1, 2);
        Complex result = complex1.add(complex2);

        if (result.getReal() == 4 && result.getImage() == 6) {
            System.out.println("Test testComplexAddition passed.");
        } else {
            System.err.println("Test testComplexAddition failed.");
        }
    }

    public void testComplexSubtraction() {
        Complex complex1 = new Complex(3, 4);
        Complex complex2 = new Complex(1, 2);
        Complex result = complex1.subtract(complex2);

        if (result.getReal() == 2 && result.getImage() == 2) {
            System.out.println("Test testComplexSubtraction passed.");
        } else {
            System.err.println("Test testComplexSubtraction failed.");
        }
    }

    public void testFactoryCreation() {
        ComplexAbstractFactory factory = new ConcreteFactory();
        Complex complex = factory.createComplex();

        if (complex.getReal() == 0 && complex.getImage() == 0) {
            System.out.println("Test testFactoryCreation passed.");
        } else {
            System.err.println("Test testFactoryCreation failed.");
        }
    }

    public void testFactoryCreationWithParameters() {
        ComplexAbstractFactory factory = new ConcreteFactory();
        Complex complex = factory.CreateComplex(7, 5);

        if (complex.getReal() == 5 && complex.getImage() == 7) {
            System.out.println("Test testFactoryCreationWithParameters passed.");
        } else {
            System.err.println("Test testFactoryCreationWithParameters failed.");
        }
    }
}
