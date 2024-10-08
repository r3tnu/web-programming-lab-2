package me.r3tnu.lab2.servlets;

import java.io.IOException;
import java.time.Instant;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import me.r3tnu.lab2.point.Point;
import me.r3tnu.lab2.point.exceptions.PointValidationException;
import me.r3tnu.lab2.point.interfaces.*;
import me.r3tnu.lab2.utils.HttpUtils;

public class AreaCheckServlet extends HttpServlet {

    private PointChecker pointChecker;
    private PointValidator pointValidator;

    public AreaCheckServlet(PointChecker pointChecker, PointValidator pointValidator) {
        this.pointChecker = pointChecker;
        this.pointValidator = pointValidator;
    }

    private Double getParameter(HttpServletRequest request, String key) throws NumberFormatException {
        Double number;
        try {
            number = Double.parseDouble(request.getParameter(key));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Couldn't parse %s as %s parameter\n".formatted(e.getMessage().substring(e.getMessage().indexOf(":") + 2), key));
        }
        return number;
    }

    private Point getPointFromRequest(HttpServletRequest request) throws NumberFormatException {
        Double x = getParameter(request, "x");
        Double y = getParameter(request, "y");
        Double r = getParameter(request, "r");

        return new Point(x, y, r);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute("start", Instant.now());
        HttpUtils httpUtils = new HttpUtils();
        try {
            Point point = getPointFromRequest(request);
            pointValidator.validate(point);
            boolean result = pointChecker.check(point);
            request.setAttribute("point", point);
            request.setAttribute("result", result);
            request.setAttribute("end", Instant.now());
            httpUtils.forward(request, response, "/result");
        } catch (PointValidationException | NumberFormatException e) {
            httpUtils.forwardToError(request, response, HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
        }
    }
    
}
