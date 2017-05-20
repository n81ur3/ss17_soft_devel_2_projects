package at.fhj.swd;

/**
 * @author Helmut Bierbaumer
 *         Created on 2017/05/13.
 */
public class Rectangle {
    private int height;
    private int width;

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }


    public int getPerimeter() {
        return 2 * (width + height);
    }
}
