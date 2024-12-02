public class Complex {
    int real;
    int image;
    public Complex(int image, int real){
        this.image = image;
        this.real = real;
    }

    public int getImage() {
        return image;
    }

    public int getReal() {
        return real;
    }

    public String toString() {
        return real + " + " + image + "i";
    }

    // Метод для сложения двух комплексных чисел
    public Complex add(Complex other) {
        return new Complex(this.real + other.real, this.image + other.image);
    }

    // Метод для вычитания одного комплексного числа из другого
    public Complex subtract(Complex other) {
        return new Complex(this.real - other.real, this.image - other.image);
    }


}
