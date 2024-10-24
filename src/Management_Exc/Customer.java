//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Management_Exc;

public class Customer extends Person {
    public Customer(String name, int age) {
        super(name, age);
    }

    public void performTask() {
        System.out.println(this.getName() + " is browsing through");
    }

    public String speak(Employee e) {
        return e instanceof Developer && this.getAge() > e.getAge() && ((Developer)e).getProjectManager() != null ? "Can I see your manager " + ((Developer)e).getProjectManager().getName() + "?" : "Oh, hello, " + e.getName() + ". Can you assist me?";
    }
}
