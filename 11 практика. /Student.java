import java.util.Random;
import java.util.Scanner;

public class Student {
    private int iDNumber;

    public Student(int iDNumber) {
        this.iDNumber = iDNumber;
    }

    public int getiDNumber() {
        return iDNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "iDNumber=" + iDNumber +
                '}';
    }
}
