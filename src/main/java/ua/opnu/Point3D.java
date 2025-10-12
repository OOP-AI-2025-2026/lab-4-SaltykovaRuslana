package ua.opnu;

import ua.opnu.java.inheritance.point.Point;
import java.lang.Math;

public class Point3D extends Point {
    private int z;

    public Point3D() {
        super();
        this.z = 0;
    }

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public void setLocation(int x, int y, int z) {
        super.setLocation(x, y);
        this.z = z;
    }

    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x, y);
        this.z = 0;
    }

    public int getZ() {
        return this.z;
    }

    @Override
    public double distanceFromOrigin() {
        double x_dist_sq = Math.pow(this.getX(), 2);
        double y_dist_sq = Math.pow(this.getY(), 2);
        double z_dist_sq = Math.pow(this.getZ(), 2);
        return Math.sqrt(x_dist_sq + y_dist_sq + z_dist_sq);
    }

    public double distance(Point3D p) {
        double x_dist_sq = Math.pow(this.getX() - p.getX(), 2);
        double y_dist_sq = Math.pow(this.getY() - p.getY(), 2);
        double z_dist_sq = Math.pow(this.getZ() - p.getZ(), 2);
        return Math.sqrt(x_dist_sq + y_dist_sq + z_dist_sq);
    }

    @Override
    public String toString() {
        return "(" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")";
    }
}
