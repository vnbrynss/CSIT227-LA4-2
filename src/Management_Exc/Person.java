//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Management_Exc;

public abstract class Person {
    private final String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        if (age < 0) {
            throw new IllegalArgumentException("Age must be non-negative.");
        } else {
            this.age = age;
        }
    }

    public String toString() {
        return this.name + " (" + this.age + ")";
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void birthday() {
        System.out.println("Happy birthday, " + this.name + "!");
        ++this.age;
    }

    public abstract void performTask();
}
