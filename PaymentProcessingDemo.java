// Compares procedural instanceof pattern matching against true object-oriented polymorphic dispatch.
// Design 1: Types for instanceof approach
abstract class Payment {
    double amount;
    Payment(double amount) { this.amount = amount; }
}

class CardPaymentMethod extends Payment {
    String cardNumber;
    CardPaymentMethod(double amount, String cardNumber) {
        super(amount);
        this.cardNumber = "*".repeat(12) + cardNumber.substring(cardNumber.length() - 4);
    }
}

class MobileMoneyPaymentMethod extends Payment {
    String phoneNumber;
    MobileMoneyPaymentMethod(double amount, String phoneNumber) {
        super(amount);
        this.phoneNumber = phoneNumber;
    }
}

// Design 2: Polymorphic interface approach
interface PayableItem {
    void process();
}

class PolymorphicCardPayment implements PayableItem {
    private final double amount;
    private final String cardLastFour;

    PolymorphicCardPayment(double amount, String cardLastFour) {
        this.amount = amount;
        this.cardLastFour = cardLastFour;
    }

    @Override
    public void process() {
        System.out.printf("Processed Card payment of $%.2f (Card ending in %s)%n", amount, cardLastFour);
    }
}

class PolymorphicMobilePayment implements PayableItem {
    private final double amount;
    private final String phone;

    PolymorphicMobilePayment(double amount, String phone) {
        this.amount = amount;
        this.phone = phone;
    }

    @Override
    public void process() {
        System.out.printf("Processed EcoCash mobile payment of $%.2f via %s%n", amount, phone);
    }
}

public class PaymentProcessingDemo {
    // Design 1 method using instanceof pattern matching
    public static void payWithInstanceof(Payment p) {
        if (p instanceof CardPaymentMethod card) {
            System.out.printf("[instanceof] Charging Card %s for $%.2f%n", card.cardNumber, card.amount);
        } else if (p instanceof MobileMoneyPaymentMethod mobile) {
            System.out.printf("[instanceof] Charging Mobile wallet %s for $%.2f%n", mobile.phoneNumber, mobile.amount);
        } else {
            System.out.println("[instanceof] Unknown payment method");
        }
    }

    // Design 2 method using clean polymorphism (Open/Closed Principle)
    public static void payPolymorphic(PayableItem item) {
        item.process();
    }

    public static void main(String[] args) {
        System.out.println("--- 1. Testing instanceof Pattern Matching ---");
        payWithInstanceof(new CardPaymentMethod(150.0, "1234567890123456"));
        payWithInstanceof(new MobileMoneyPaymentMethod(45.0, "+263771234567"));

        System.out.println("\n--- 2. Testing Polymorphic Dispatch ---");
        payPolymorphic(new PolymorphicCardPayment(150.0, "3456"));
        payPolymorphic(new PolymorphicMobilePayment(45.0, "+263771234567"));

        System.out.println("\nComparison:");
        System.out.println("The polymorphic design obeys Open/Closed: adding CryptoPayment requires no change to payPolymorphic(),");
        System.out.println("whereas the instanceof pattern matching approach requires modifying the if-else branch chain for every new type.");
    }
}
