package at.fhj.swd;

/**
 * @author Helmut Bierbaumer
 *         Created on 2017/05/13.
 */
public class Person implements HTMLDisplayable {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void display() {
        System.out.println(String.format("<p> %s %s </p>", firstName, lastName));
    }

    @Override
    public String toString() {
        return String.format("Person(%s %s)", firstName, lastName);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Person)) {
            return false;
        }

        Person p = (Person) obj;

        boolean isEqual = firstName.equals(p.firstName) && lastName.equals(p.lastName);

        return isEqual;
    }


}
