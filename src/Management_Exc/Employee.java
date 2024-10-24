//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Management_Exc;

public class Employee extends Person {
    private double salary;

    public Employee(String name, int age, double salary) {
        super(name, age);
        if (salary < 30000.0) {
            throw new IllegalArgumentException("Salary must be greater than or equal to 30000");
        } else {
            this.salary = salary;
        }
    }

    public double getSalary() {
        return this.salary;
    }

    protected void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        String var10000 = super.toString();
        return var10000 + " - " + this.salary;
    }

    public void performTask() {
        System.out.println(this.getName() + " is working");
    }
}
