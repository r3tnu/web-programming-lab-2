package me.r3tnu.lab2.point;

public class Point {
    private double x;
    private double y;
    private double r;

    public Point(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    } 

    public double getR() {
        return this.r;
    }
}
