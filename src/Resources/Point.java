package Resources;

/**
 * Created by Omer Dekel on 09/01/2018.
 */
public class Point {
    private int x;
    private int y;

    /**
     *
     */
    public  Point(){}

    /**
     * The constructor of the class.
     *
     * @param x
     *            the x of the new point.
     * @param y
     *            the y of the new point.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    int getX()  {
        return this.x;
    }
    /*
     * set the x.
     * @param x the point.
     * @return m_x the point.
     */
    void setX(int x) {
        this.x = x;
    }
    /*
     * get the y
     * @return m_y the point
     */
    int getY() {
        return this.y;
    }
    /*
     * set the y.
     * @param y the point.
     * @return m_y the point.
     */
    void setY( int y) {
        this.y = y;
    }
    /**
     * The equals method.
     *
     * @param other
     *            the other point to compare to.
     * @return true if the point are equal, false otherwise.
     */
    public boolean equals(Point other) {
        return (Math.abs(this.x - other.getX()) <= 0.02 && Math.abs(this.y - other.getY()) <= 0.02);
    }


}
