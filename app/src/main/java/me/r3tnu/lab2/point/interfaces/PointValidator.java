package me.r3tnu.lab2.point.interfaces;

import me.r3tnu.lab2.point.Point;
import me.r3tnu.lab2.point.exceptions.PointValidationException;

public interface PointValidator {
    public void validate(Point point) throws PointValidationException;
}
