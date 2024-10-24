//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Management_Exc;

public class Developer extends Employee {
    private Manager projectManager = null;

    public Developer(String name, int age, double salary) {
        super(name, age, salary);
    }

    public Manager getProjectManager() {
        return this.projectManager;
    }

    protected void setProjectManager(Manager projectManager) throws IllegalStateException {
        if (this.projectManager != null) {
            String var10002 = this.getName();
            throw new IllegalStateException(var10002 + " already has a manager:" + this.getProjectManager().getName());
        } else {
            this.projectManager = projectManager;
        }
    }

    public void removePM() {
        this.projectManager = null;
    }

    public void birthday() {
        super.birthday();
        if (this.projectManager != null) {
            this.projectManager.giveRaise(this, this.getSalary() * 0.05);
        }

    }

    public void performTask() {
        System.out.println(this.getName() + " is coding");
    }

    public String toString() {
        if (this.projectManager != null) {
            String var10000 = super.toString();
            return var10000 + " [" + this.projectManager.getName() + "]";
        } else {
            return super.toString();
        }
    }
}
