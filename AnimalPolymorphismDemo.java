// Demonstrates runtime polymorphism through animal vocalizations in an array loop.
class AnimalBase {
    String name;

    AnimalBase(String name) {
        this.name = name;
    }

    void sound() {
        System.out.println(name + " makes a sound");
    }
}

class Cat extends AnimalBase {
    Cat(String name) { super(name); }

    @Override
    void sound() {
        System.out.println(name + " says: Meow!");
    }
}

class Cow extends AnimalBase {
    Cow(String name) { super(name); }

    @Override
    void sound() {
        System.out.println(name + " says: Moo!");
    }
}

class Duck extends AnimalBase {
    Duck(String name) { super(name); }

    @Override
    void sound() {
        System.out.println(name + " says: Quack!");
    }
}

public class AnimalPolymorphismDemo {
    public static void main(String[] args) {
        AnimalBase[] barnyard = {
            new Cat("Whiskers"),
            new Cow("Daisy"),
            new Duck("Donald")
        };

        System.out.println("--- Polymorphic Barnyard Sounds ---");
        for (AnimalBase animal : barnyard) {
            animal.sound(); // Dynamically dispatched to Cat, Cow, or Duck
        }
    }
}
