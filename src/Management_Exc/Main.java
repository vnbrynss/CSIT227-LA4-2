package Management_Exc;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Main {

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param manager the manager to give the salary
     * @param employee the employee to receive the raise
     * @param salary the salary increase to be given
     * @throws ClassCastException when manager or employee is not a manager or employee
     * @throws IllegalArgumentException when salary is invalid
     * @throws NoSuchElementException when given manager or employee does not exist in the list of persons
     */
    public static void giveRaise(List<Person> persons, String manager, String employee, double salary)  {
        Manager a = null;
        Employee b = null;

        for (Person s : persons) {
            if(Objects.equals(s.getName(), manager)) {
                if(s instanceof Manager) {
                    a = (Manager) s;
                } else {
                    throw new ClassCastException(s.getName() + " is not a manager");
                }
            }
        }

        for (Person s : persons) {
            if(Objects.equals(s.getName(), employee)) {
                if(s instanceof Employee) {
                    b = (Employee) s;
                } else {
                    throw  new ClassCastException(s.getName() + " is not an employee");
                }
            }
        }

        if(a == null) {
            throw new NoSuchElementException(manager + " does not exist");
        }
        if(b == null) {
            throw new NoSuchElementException(employee + " does not exist");
        }

        if(salary < 0) {
            throw new IllegalArgumentException("Raise must be non-negative");
        }

        a.giveRaise(b, salary);
    }

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param developer the developer to be assigned
     * @param manager the manager assigned to the dev
     * @throws ClassCastException when manager or developer is not a manager or employee
     * @throws NoSuchElementException when given manager or developer does not exist in the list of persons
     * @throws IllegalStateException when developer already has a manager
     */
    public static void assignPM(List<Person> persons, String developer, String manager) {
        Developer c = null;
        Manager d = null;

        for(Person s : persons) {
            if(Objects.equals(s.getName(), developer)) {
                if(s instanceof Developer) {
                    c = (Developer) s;
                } else {
                    throw new ClassCastException(s.getName() + " is not a developer");
                }
            }
        }

        for (Person s : persons) {
            if (Objects.equals(s.getName(), manager)) {
                if (s instanceof Manager) {
                    d = (Manager) s;
                } else {
                    throw new ClassCastException(s.getName() + " is not a manager");
                }
            }
        }

        if(c == null) {
            throw new NoSuchElementException(developer + " does not exist");
        }
        if(d == null) {
            throw new NoSuchElementException(manager + " does not exist");
        }

        if(c.getProjectManager() == null) {
            c.setProjectManager(d);
        } else {
            throw new IllegalStateException(c.getName() + " already has a manager: " + c.getProjectManager().getName());
        }
    }

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param customer the customer to speak to the employee
     * @param employee the employee to be spoken to
     * @return the dialogue of the customer to the employee
     * @throws ClassCastException when given customer or employee is not what they are
     * @throws NoSuchElementException when given customer or employee is not in the list of persons
     */
    public static String customerSpeak(List<Person> persons, String customer, String employee) {
        Customer e = null;
        Employee f = null;

        for(Person s : persons) {
            if(customer.equals(s.getName())) {
                if(s instanceof Customer) {
                    e = (Customer) s;
                } else {
                    throw new ClassCastException(customer + " is not a customer");
                }
            }
        }

        for (Person s : persons) {
            if(employee.equals(s.getName())) {
                if (s instanceof Employee) {
                    f = (Employee) s;
                } else {
                    throw new ClassCastException(employee + " is not an employee");
                }
            }
        }

        if(e == null) {
            throw new NoSuchElementException(customer + " does not exist");
        }
        if(f == null) {
            throw new NoSuchElementException(employee + " does not exist");
        }

        return e.speak(f);
    }
}