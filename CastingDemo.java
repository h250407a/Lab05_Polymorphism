// Shows upcasting, downcasting with pattern matching instanceof, and non-polymorphic fields.
class Animal {
    String type = "Animal"; // field

    void speak() {
        System.out.println("...");
    }

    static void info() {
        System.out.println("Animal info");
    }
}

class Dog extends Animal {
    String type = "Dog"; // hides superclass field (not polymorphic)

    @Override
    void speak() {
        System.out.println("Woof");
    }

    void fetch() {
        System.out.println("Fetching...");
    }

    static void info() {
        System.out.println("Dog info"); // hides static method (not polymorphic)
    }
}

public class CastingDemo {
    public static void main(String[] args) {
        Animal a = new Dog(); // Upcast (implicit and always safe)

        a.speak();                  // "Woof" -> method call IS polymorphic
        System.out.println(a.type); // "Animal" -> fields follow declared reference type!
        a.info();                   // "Animal info" -> static methods follow declared type!

        // Downcasting safely with pattern matching instanceof
        if (a instanceof Dog d) {
            d.fetch(); // safe downcast to access subclass-specific method
        }

        Animal plain = new Animal();
        if (!(plain instanceof Dog)) {
            System.out.println("plain is not a Dog; downcast avoided");
        }
    }
}
