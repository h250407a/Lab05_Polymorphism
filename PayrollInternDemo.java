// Demonstrates the Open/Closed Principle by adding Intern to payroll without modifying the calculation loop.
class Staff {
    protected String name;
    protected double baseSalary;

    Staff(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    double calculatePay() {
        return baseSalary;
    }

    String getName() {
        return name;
    }
}

class SalariedManager extends Staff {
    private double bonus;

    SalariedManager(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    double calculatePay() {
        return baseSalary + bonus;
    }
}

class SeniorDeveloper extends Staff {
    private int overtimeHours;

    SeniorDeveloper(String name, double baseSalary, int overtimeHours) {
        super(name, baseSalary);
        this.overtimeHours = overtimeHours;
    }

    @Override
    double calculatePay() {
        return baseSalary + (overtimeHours * 25.0);
    }
}

// Newly introduced Intern class without modifying existing hierarchy contracts
class Intern extends Staff {
    private double stipend;

    Intern(String name, double stipend) {
        super(name, 0.0);
        this.stipend = stipend;
    }

    @Override
    double calculatePay() {
        return stipend;
    }
}

public class PayrollInternDemo {
    public static void main(String[] args) {
        Staff[] employees = {
            new SalariedManager("Nyasha", 3500, 800),
            new SeniorDeveloper("Tatenda", 3000, 10),
            new Staff("Kudzai", 2000),
            new Intern("Anesu (Student Intern)", 850) // Newly integrated subtype
        };

        double totalPayroll = 0;
        System.out.println("--- Monthly Payroll Processing ---");
        for (Staff s : employees) {
            double pay = s.calculatePay();
            System.out.printf("%-25s : $%.2f%n", s.getName(), pay);
            totalPayroll += pay;
        }

        System.out.println("-------------------------------------");
        System.out.printf("Total Payroll Expenditure: $%.2f%n", totalPayroll);
    }
}
