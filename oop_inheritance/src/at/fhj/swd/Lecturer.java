package at.fhj.swd;

/**
 * @author Helmut Bierbaumer
 *         Created on 2017/05/13.
 */
public class Lecturer extends Person {
    private float salary;

    public Lecturer(String firstName, String lastName, float salary) {
        super(firstName, lastName);
        this.salary = salary;
    }

    public float getSalary() {
        return salary;
    }

    @Override
    public void display() {
        System.out.println(String.format("<p> %s %s (%.2f €)</p>", getFirstName(), getLastName(), salary));
    }
}
