// Demonstrates method overloading across primitives, objects, and array parameters.
import java.util.Arrays;

public class PrinterOverloadDemo {
    public void print(int value) {
        System.out.println("Printing integer: " + value);
    }

    public void print(double value) {
        System.out.printf("Printing double: %.4f%n", value);
    }

    public void print(String text) {
        System.out.println("Printing string: \"" + text + "\"");
    }

    public void print(int[] array) {
        System.out.println("Printing int array: " + Arrays.toString(array));
    }

    public static void main(String[] args) {
        PrinterOverloadDemo printer = new PrinterOverloadDemo();

        printer.print(42);
        printer.print(3.14159);
        printer.print("Hello Object-Oriented Programming");
        printer.print(new int[]{10, 20, 30, 40, 50});
    }
}
