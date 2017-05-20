package at.fhj.swd;

/**
 * @author Helmut Bierbaumer
 *         Created on 2017/05/13.
 */
public class Student extends Person {
    private float pointAverage;

    public Student(String firstName, String lastName, float pointAverage) {
        super(firstName, lastName);
        this.pointAverage = pointAverage;
    }

    public float getPointAverage() {
        return pointAverage;
    }

    @Override
    public void display() {
        System.out.println(String.format("<p> %s %s %.2f</p>", getFirstName(), getLastName(), pointAverage));
    }

    @Override
    public String toString() {
        return super.toString() + " Point average: " + pointAverage;
    }
}
