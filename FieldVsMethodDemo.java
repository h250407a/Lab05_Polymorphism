// Demonstrates that method calls are polymorphic but field accesses are bound to the declared reference type.
class Parent {
    String role = "Parent Role";

    String getRole() {
        return "Parent Method";
    }
}

class Child extends Parent {
    String role = "Child Role"; // Hides the Parent field

    @Override
    String getRole() {
        return "Child Method";
    }
}

public class FieldVsMethodDemo {
    public static void main(String[] args) {
        Parent ref = new Child(); // Upcasting Child to Parent reference

        System.out.println("Direct field access (ref.role)   : " + ref.role);
        System.out.println("Method call output   (ref.getRole()): " + ref.getRole());

        System.out.println("\nExplanation:");
        System.out.println("1. Method calls in Java use dynamic method dispatch (runtime polymorphism). The JVM executes Child.getRole() based on the actual object.");
        System.out.println("2. Field access is resolved at compile time based strictly on the declared reference type ('Parent'). Hence ref.role prints 'Parent Role'.");
    }
}
