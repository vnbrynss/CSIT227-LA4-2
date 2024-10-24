package Management_Exc;

public class Manager extends Employee {
    public Manager(String name, int age, double salary) {
        super(name, age, salary);
    }

    /**
     * TODO this implementation
     * @param e the employee to be given raise
     * @param raise the raise
     * @throws IllegalArgumentException when raise is negative
     */
    public void giveRaise(Employee e, double raise) {
        if (raise < 0) {
            throw new IllegalArgumentException("Raise must be non-negative");
        } else {
            double inc = e.getSalary();
            if (e.equals(this)) {
                this.setSalary(this.getSalary() + raise);
            } else {
                e.setSalary(e.getSalary() + raise);
                this.setSalary(this.getSalary() + raise/2);
            }
        }
    }

    @Override
    public String toString() {
        return "Mgr. " +super.toString();
    }
}