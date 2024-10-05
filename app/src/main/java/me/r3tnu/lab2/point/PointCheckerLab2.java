package me.r3tnu.lab2.point;

import me.r3tnu.lab2.point.interfaces.PointChecker;

public class PointCheckerLab2 implements PointChecker{
    public boolean check(Point point) {
        double x = point.getX(), y = point.getY(), r = point.getR();
        boolean firstQuadrant = x <= r && x >= 0 && y <= r && y >= 0;
        boolean thirdQuadrant = x >= -Math.sqrt(r * r - y * y) && x <= 0 && y <= 0;
        boolean fourthQuadrant = x <= y + r && x >= 0 && y <= 0;
        return firstQuadrant || thirdQuadrant || fourthQuadrant;
    }
}
