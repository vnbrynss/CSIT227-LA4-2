//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Management_Exc;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonTest {
    List<Person> persons;

    PersonTest() {
    }

    @BeforeEach
    void setUp() {
        this.persons = new ArrayList();
    }

    @AfterEach
    void tearDown() {
        this.persons.clear();
    }

    @Test
    void testAgeValid() {
        Assertions.assertDoesNotThrow(() -> {
            this.persons.add(new Developer("Jea", 25, 47500.0));
            this.persons.add(new Manager("Vince", 28, 32700.0));
            this.persons.add(new Employee("Jeshiel", 21, 35000.0));
            this.persons.add(new Manager("Mary", 24, 50200.0));
        });
        Assertions.assertEquals(((Person)this.persons.get(3)).getAge(), 24);
    }

    @Test
    void testAgeInvalid() {
        this.persons.add(new Manager("Vince", 28, 32700.0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            this.persons.add(new Manager("Jea", -25, 47500.0));
        }, "Age cannot be negative");

        try {
            this.persons.add(new Manager("Jea", -25, 47500.0));
        } catch (IllegalArgumentException var2) {
            IllegalArgumentException e = var2;
            Assertions.assertEquals(e.getMessage(), "Age must be non-negative.");
        }

        Assertions.assertEquals(this.persons.size(), 1);
    }

    @Test
    void testSalaryInvalid() {
        this.persons.add(new Manager("Vince", 28, 32700.0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            this.persons.add(new Manager("Jea", -25, 47500.0));
        }, "Age cannot be negative");

        try {
            this.persons.add(new Manager("Jea", 25, 27500.0));
        } catch (IllegalArgumentException var2) {
            IllegalArgumentException e = var2;
            Assertions.assertEquals(e.getMessage(), "Salary must be greater than or equal to 30000");
        }

        Assertions.assertEquals(this.persons.size(), 1);
    }

    @Test
    void testAssignPMValid() {
        this.persons.add(new Developer("Jea", 25, 47500.0));
        this.persons.add(new Developer("Vince", 28, 32700.0));
        this.persons.add(new Employee("Jeshiel", 21, 35000.0));
        this.persons.add(new Manager("Mary", 24, 50200.0));
        this.persons.add(new Manager("Claire", 27, 52600.0));
        Assertions.assertDoesNotThrow(() -> {
            Main.assignPM(this.persons, "Vince", "Mary");
            Main.assignPM(this.persons, "Jea", "Claire");
        });
        Developer vince = (Developer)this.persons.get(1);
        Developer jea = (Developer)this.persons.get(0);
        Assertions.assertEquals(vince.getProjectManager(), this.persons.get(3));
        Assertions.assertEquals(jea.getProjectManager(), this.persons.get(4));
    }

    @Test
    void testAssignPMNotManager() {
        this.persons.add(new Developer("Jea", 25, 47500.0));
        this.persons.add(new Developer("Vince", 28, 32700.0));
        this.persons.add(new Employee("Jeshiel", 21, 35000.0));
        this.persons.add(new Manager("Mary", 24, 50200.0));
        this.persons.add(new Manager("Claire", 27, 52600.0));
        Assertions.assertThrows(ClassCastException.class, () -> {
            Main.assignPM(this.persons, "Vince", "Jeshiel");
        });

        try {
            Main.assignPM(this.persons, "Vince", "Jeshiel");
        } catch (ClassCastException var2) {
            ClassCastException e = var2;
            Assertions.assertEquals(e.getMessage(), "Jeshiel is not a manager");
        }

    }

    @Test
    void testAssignPMNotListed() {
        this.persons.add(new Developer("Jea", 25, 47500.0));
        this.persons.add(new Developer("Vince", 28, 32700.0));
        this.persons.add(new Employee("Jeshiel", 21, 35000.0));
        this.persons.add(new Manager("Mary", 24, 50200.0));
        this.persons.add(new Manager("Claire", 27, 52600.0));
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            Main.assignPM(this.persons, "Vince", "Scott");
        });

        try {
            Main.assignPM(this.persons, "Vince", "Scott");
        } catch (NoSuchElementException var2) {
            NoSuchElementException e = var2;
            Assertions.assertEquals(e.getMessage(), "Scott does not exist");
        }

    }

    @Test
    void testAssignPMAlreadyHas() {
        this.persons.add(new Developer("Jea", 25, 47500.0));
        this.persons.add(new Developer("Vince", 28, 32700.0));
        this.persons.add(new Employee("Jeshiel", 21, 35000.0));
        this.persons.add(new Manager("Mary", 24, 50200.0));
        this.persons.add(new Manager("Claire", 27, 52600.0));
        Assertions.assertDoesNotThrow(() -> {
            Main.assignPM(this.persons, "Vince", "Mary");
            Main.assignPM(this.persons, "Jea", "Mary");
        });
        Assertions.assertThrows(IllegalStateException.class, () -> {
            Main.assignPM(this.persons, "Vince", "Claire");
        });

        try {
            Main.assignPM(this.persons, "Vince", "Claire");
        } catch (IllegalStateException var2) {
            IllegalStateException e = var2;
            Assertions.assertEquals(e.getMessage(), "Vince already has a manager: Mary");
        }

    }

    @Test
    void testGiveRaiseValid() {
        this.persons.add(new Developer("Jea", 25, 47500.0));
        this.persons.add(new Developer("Vince", 28, 32700.0));
        this.persons.add(new Employee("Jeshiel", 21, 35000.0));
        this.persons.add(new Manager("Mary", 24, 50200.0));
        this.persons.add(new Manager("Claire", 27, 52600.0));
        Assertions.assertDoesNotThrow(() -> {
            Main.assignPM(this.persons, "Vince", "Mary");
            Main.assignPM(this.persons, "Jea", "Mary");
            Main.giveRaise(this.persons, "Mary", "Vince", 140.3);
        });
        Employee vince = (Employee)this.persons.get(1);
        Employee mary = (Employee)this.persons.get(3);
        Assertions.assertEquals(vince.getSalary(), 32840.3);
        Assertions.assertEquals(mary.getSalary(), 50270.15);
    }

    @Test
    void testGiveRaiseInvalid1() {
        this.persons.add(new Developer("Jea", 25, 47500.0));
        this.persons.add(new Developer("Vince", 28, 32700.0));
        this.persons.add(new Employee("Jeshiel", 21, 35000.0));
        this.persons.add(new Manager("Mary", 24, 50200.0));
        this.persons.add(new Manager("Claire", 27, 52600.0));
        this.persons.add(new Customer("Felix", 52));
        Assertions.assertDoesNotThrow(() -> {
            Main.assignPM(this.persons, "Vince", "Mary");
            Main.assignPM(this.persons, "Jea", "Mary");
            Main.giveRaise(this.persons, "Mary", "Vince", 140.3);
        });
        Assertions.assertThrows(ClassCastException.class, () -> {
            Main.giveRaise(this.persons, "Felix", "Jeshiel", 2500.0);
        });

        try {
            Main.giveRaise(this.persons, "Felix", "Jeshiel", 2500.0);
        } catch (ClassCastException var2) {
            ClassCastException e = var2;
            Assertions.assertEquals(e.getMessage(), "Felix is not a manager");
        }

        Employee jeshiel = (Employee)this.persons.get(2);
        Assertions.assertEquals(jeshiel.getSalary(), 35000.0);
    }

    @Test
    void testGiveRaiseInvalid2() {
        this.persons.add(new Developer("Jea", 25, 47500.0));
        this.persons.add(new Developer("Vince", 28, 32700.0));
        this.persons.add(new Employee("Jeshiel", 21, 35000.0));
        this.persons.add(new Manager("Mary", 24, 50200.0));
        this.persons.add(new Manager("Claire", 27, 52600.0));
        this.persons.add(new Customer("Felix", 52));
        Assertions.assertDoesNotThrow(() -> {
            Main.assignPM(this.persons, "Vince", "Mary");
            Main.assignPM(this.persons, "Jea", "Mary");
            Main.giveRaise(this.persons, "Mary", "Vince", 140.3);
        });
        Assertions.assertThrows(ClassCastException.class, () -> {
            Main.giveRaise(this.persons, "Felix", "Jeshiel", 2500.0);
        });

        try {
            Main.giveRaise(this.persons, "Claire", "Felix", 2500.0);
        } catch (ClassCastException var2) {
            ClassCastException e = var2;
            Assertions.assertEquals(e.getMessage(), "Felix is not an employee");
        }

        Employee claire = (Employee)this.persons.get(4);
        Assertions.assertEquals(claire.getSalary(), 52600.0);
    }

    @Test
    void testGiveRaiseInvalid3() {
        this.persons.add(new Developer("Jea", 25, 47500.0));
        this.persons.add(new Developer("Vince", 28, 32700.0));
        this.persons.add(new Employee("Jeshiel", 21, 35000.0));
        this.persons.add(new Manager("Mary", 24, 50200.0));
        this.persons.add(new Manager("Claire", 27, 52600.0));
        this.persons.add(new Customer("Felix", 52));
        Assertions.assertDoesNotThrow(() -> {
            Main.assignPM(this.persons, "Vince", "Mary");
            Main.assignPM(this.persons, "Jea", "Mary");
            Main.giveRaise(this.persons, "Claire", "Vince", 140.3);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Main.giveRaise(this.persons, "Mary", "Jeshiel", -2500.0);
        });

        try {
            Main.giveRaise(this.persons, "Mary", "Jeshiel", -2500.0);
        } catch (IllegalArgumentException var3) {
            IllegalArgumentException e = var3;
            Assertions.assertEquals(e.getMessage(), "Raise must be non-negative");
        }

        Employee mary = (Employee)this.persons.get(3);
        Employee jeshiel = (Employee)this.persons.get(2);
        Assertions.assertEquals(mary.getSalary(), 50200.0);
        Assertions.assertEquals(jeshiel.getSalary(), 35000.0);
    }

    @Test
    void testGiveRaiseInvalid4() {
        this.persons.add(new Developer("Jea", 25, 47500.0));
        this.persons.add(new Developer("Vince", 28, 32700.0));
        this.persons.add(new Employee("Jeshiel", 21, 35000.0));
        this.persons.add(new Manager("Mary", 24, 50200.0));
        this.persons.add(new Manager("Claire", 27, 52600.0));
        this.persons.add(new Customer("Felix", 52));
        Assertions.assertDoesNotThrow(() -> {
            Main.assignPM(this.persons, "Vince", "Mary");
            Main.assignPM(this.persons, "Jea", "Mary");
            Main.giveRaise(this.persons, "Mary", "Vince", 140.3);
        });
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            Main.giveRaise(this.persons, "Alaera", "Jeshiel", 2500.0);
        });

        NoSuchElementException e;
        try {
            Main.giveRaise(this.persons, "Alaera", "Jeshiel", 2500.0);
        } catch (NoSuchElementException var3) {
            e = var3;
            Assertions.assertEquals(e.getMessage(), "Alaera does not exist");
        }

        try {
            Main.giveRaise(this.persons, "Claire", "Frieren", 2500.0);
        } catch (NoSuchElementException var2) {
            e = var2;
            Assertions.assertEquals(e.getMessage(), "Frieren does not exist");
        }

    }

    @Test
    void testCustomerSpeakValid() {
        this.persons.add(new Developer("Jea", 25, 47500.0));
        this.persons.add(new Developer("Vince", 28, 32700.0));
        this.persons.add(new Employee("Jeshiel", 21, 35000.0));
        this.persons.add(new Customer("Jewel", 38));
        this.persons.add(new Manager("Mary", 24, 50200.0));
        this.persons.add(new Manager("Claire", 27, 52600.0));
        this.persons.add(new Customer("Felix", 52));
        Assertions.assertDoesNotThrow(() -> {
            Main.customerSpeak(this.persons, "Felix", "Jeshiel");
            Main.customerSpeak(this.persons, "Jewel", "Jea");
        });
        Assertions.assertEquals(Main.customerSpeak(this.persons, "Felix", "Jeshiel"), "Oh, hello, Jeshiel. Can you assist me?");
        Assertions.assertEquals(Main.customerSpeak(this.persons, "Jewel", "Jea"), "Oh, hello, Jea. Can you assist me?");
        Main.assignPM(this.persons, "Jea", "Mary");
        Assertions.assertEquals(Main.customerSpeak(this.persons, "Felix", "Jea"), "Can I see your manager Mary?");
    }

    @Test
    void testCustomerSpeakInvalid() {
        this.persons.add(new Developer("Jea", 25, 47500.0));
        this.persons.add(new Developer("Vince", 28, 32700.0));
        this.persons.add(new Employee("Jeshiel", 21, 35000.0));
        this.persons.add(new Customer("Jewel", 38));
        this.persons.add(new Manager("Mary", 24, 50200.0));
        this.persons.add(new Manager("Claire", 27, 52600.0));
        this.persons.add(new Customer("Felix", 52));
        Assertions.assertThrows(ClassCastException.class, () -> {
            Main.customerSpeak(this.persons, "Mary", "Jeshiel");
            Main.customerSpeak(this.persons, "Jewel", "Felix");
        });

        ClassCastException e;
        try {
            Main.customerSpeak(this.persons, "Mary", "Jeshiel");
        } catch (ClassCastException var3) {
            e = var3;
            Assertions.assertEquals(e.getMessage(), "Mary is not a customer");
        }

        try {
            Main.customerSpeak(this.persons, "Jewel", "Felix");
        } catch (ClassCastException var2) {
            e = var2;
            Assertions.assertEquals(e.getMessage(), "Felix is not an employee");
        }

    }

    @Test
    void testCustomerSpeakInvalid2() {
        this.persons.add(new Developer("Jea", 25, 47500.0));
        this.persons.add(new Developer("Vince", 28, 32700.0));
        this.persons.add(new Employee("Jeshiel", 21, 35000.0));
        this.persons.add(new Customer("Jewel", 38));
        this.persons.add(new Manager("Mary", 24, 50200.0));
        this.persons.add(new Manager("Claire", 27, 52600.0));
        this.persons.add(new Customer("Felix", 52));
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            Main.customerSpeak(this.persons, "Travis", "Jeshiel");
            Main.customerSpeak(this.persons, "Jewel", "Travis");
        });

        try {
            Main.customerSpeak(this.persons, "Jewel", "Travis");
        } catch (Exception var2) {
            Exception e = var2;
            Assertions.assertEquals(e.getMessage(), "Travis does not exist");
        }

    }
}
