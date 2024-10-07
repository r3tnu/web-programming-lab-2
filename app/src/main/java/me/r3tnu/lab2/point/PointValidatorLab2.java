package me.r3tnu.lab2.point;

import java.util.Arrays;

import me.r3tnu.lab2.point.exceptions.PointValidationException;
import me.r3tnu.lab2.point.interfaces.PointValidator;

public class PointValidatorLab2 implements PointValidator{
    public void validate(Point point) throws PointValidationException {
        boolean isXValid = Arrays.asList(-3.0, -2.0, -1.0, 0.0, 1.0, 2.0, 3.0, 4.0, 5.0).contains(point.getX());
        boolean isYValid = point.getY() > -3 && point.getY() < 3;
        boolean isRValid = Arrays.asList(1.0, 1.5, 2.0, 2.5, 3.0).contains(point.getR());

        String errorMessageString = "";
        if (!isXValid) {
            errorMessageString.concat("The x parameter must be in {-3.0, -2.0, -1.0, 0.0, 1.0, 2.0, 3.0, 4.0, 5.0}\n");
        }
        if (!isYValid) {
            errorMessageString.concat("The y parameter must be in (-3; 3)\n");
        }
        if (!isRValid) {
            errorMessageString.concat("The r parameter must be in {1.0, 1.5, 2.0, 2.5, 3.0}");
        }

        if (!errorMessageString.isEmpty()) {
            throw new PointValidationException(errorMessageString);
        } 
    }
}
