package at.fhj.swd;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Helmut Bierbaumer
 *         Created on 2017/05/13.
 */
public class Main {

    public static void main(String[] args) {
        Person p1 = new Person("Jane", "Doe");
        Person p2 = new Person("Jane", "Doe");
        System.out.println(p1.toString());
        System.out.println(p1);

        Student s1 = new Student("John", "Miller", 2.1f);
        System.out.println(s1);

        String firstObject = "test";
        String secondObject = "test";

        System.out.println("1. " + ("test" == "test"));
        System.out.println("2. " + (firstObject == secondObject));
        System.out.println("3. " + (p1 == p2));
        System.out.println("4. " + p1.equals(p2));

        displayHTML(p1);

        List<HTMLDisplayable> htmls = new ArrayList<>();
        htmls.add(p1);
        htmls.add(p2);
        htmls.add(s1);
        htmls.add(new Lecturer("Ron", "Howard", 2132));

        for (HTMLDisplayable h : htmls) {
            displayHTML(h);
        }
    }

    public static void displayHTML(HTMLDisplayable html) {
        html.display();
    }
}
