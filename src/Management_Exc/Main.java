//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Management_Exc;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Main {
    public Main() {
    }

    public static void giveRaise(List<Person> persons, String manager, String employee, double salary) {
        Manager a = null;
        Employee b = null;
        Iterator var7 = persons.iterator();

        Person s;
        while(var7.hasNext()) {
            s = (Person)var7.next();
            if (Objects.equals(s.getName(), manager)) {
                if (!(s instanceof Manager)) {
                    throw new ClassCastException(s.getName() + " is not a manager");
                }

                a = (Manager)s;
            }
        }

        var7 = persons.iterator();

        while(var7.hasNext()) {
            s = (Person)var7.next();
            if (Objects.equals(s.getName(), employee)) {
                if (!(s instanceof Employee)) {
                    throw new ClassCastException(s.getName() + " is not an employee");
                }

                b = (Employee)s;
            }
        }

        if (a == null) {
            throw new NoSuchElementException(manager + " does not exist");
        } else if (b == null) {
            throw new NoSuchElementException(employee + " does not exist");
        } else if (salary < 0.0) {
            throw new IllegalArgumentException("Raise must be non-negative");
        } else {
            a.giveRaise(b, salary);
        }
    }

    public static void assignPM(List<Person> persons, String developer, String manager) {
        Developer c = null;
        Manager d = null;
        Iterator var5 = persons.iterator();

        Person s;
        while(var5.hasNext()) {
            s = (Person)var5.next();
            if (Objects.equals(s.getName(), developer)) {
                if (!(s instanceof Developer)) {
                    throw new ClassCastException(s.getName() + " is not a developer");
                }

                c = (Developer)s;
            }
        }

        var5 = persons.iterator();

        while(var5.hasNext()) {
            s = (Person)var5.next();
            if (Objects.equals(s.getName(), manager)) {
                if (!(s instanceof Manager)) {
                    throw new ClassCastException(s.getName() + " is not a manager");
                }

                d = (Manager)s;
            }
        }

        if (c == null) {
            throw new NoSuchElementException(developer + " does not exist");
        } else if (d == null) {
            throw new NoSuchElementException(manager + " does not exist");
        } else if (c.getProjectManager() == null) {
            c.setProjectManager(d);
        } else {
            String var10002 = c.getName();
            throw new IllegalStateException(var10002 + " already has a manager: " + c.getProjectManager().getName());
        }
    }

    public static String customerSpeak(List<Person> persons, String customer, String employee) {
        Customer e = null;
        Employee f = null;
        Iterator var5 = persons.iterator();

        Person s;
        while(var5.hasNext()) {
            s = (Person)var5.next();
            if (customer.equals(s.getName())) {
                if (!(s instanceof Customer)) {
                    throw new ClassCastException(customer + " is not a customer");
                }

                e = (Customer)s;
            }
        }

        var5 = persons.iterator();

        while(var5.hasNext()) {
            s = (Person)var5.next();
            if (employee.equals(s.getName())) {
                if (!(s instanceof Employee)) {
                    throw new ClassCastException(employee + " is not an employee");
                }

                f = (Employee)s;
            }
        }

        if (e == null) {
            throw new NoSuchElementException(customer + " does not exist");
        } else if (f == null) {
            throw new NoSuchElementException(employee + " does not exist");
        } else {
            return e.speak(f);
        }
    }
}
