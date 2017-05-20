package at.fhj.swd;

import java.util.ArrayList;

/**
 * @author Helmut Bierbaumer
 *         Created on 2017/05/13.
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Rectangle> rectangles = new ArrayList<>();

        for (int i = 1; i < 9; i++) {
            rectangles.add(new Rectangle((i * 3), (i * 4)));
        }

        printRectangles(rectangles);

        rectangles.remove(rectangles.size() - 2);
        rectangles.remove(0);

        System.out.println("After removal of first and next-to-last element:");
        printRectangles(rectangles);
    }

    private static void printRectangles(ArrayList<Rectangle> rects) {
        int counter = 1;
        for (Rectangle r : rects) {
            System.out.println("Rechteck " + counter++ + ": " + r.getHeight() + " x " + r.getWidth() + " Umfang: " + r.getPerimeter());
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
}
