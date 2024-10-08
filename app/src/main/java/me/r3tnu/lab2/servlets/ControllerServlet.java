package me.r3tnu.lab2.servlets;

import java.io.IOException;
import java.util.Map;
import java.util.regex.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import me.r3tnu.lab2.servlets.exceptions.RequestException;
import me.r3tnu.lab2.utils.HttpUtils;

public class ControllerServlet extends HttpServlet {

    private void checkForUniqueParameter(Map<String, String[]> map, String key) throws RequestException{
        if (!map.containsKey(key)) {
            throw new RequestException("The %s parameter is missing".formatted(key));
        }
        if (map.get(key).length != 1) {
            throw new RequestException("The %s parameter has duplicates".formatted(key));
        }
        Matcher matcher = Pattern.compile("^\\d+(\\.\\d{1,15})?$").matcher(map.get(key)[0]);
        if (!matcher.find()) {
            throw new RequestException("The %s parameter cannot have more than 15 digits after decimal".formatted(key));
        }
    }

    private void checkRequestForPointData(HttpServletRequest request) throws RequestException {
        Map<String, String[]> map = request.getParameterMap();
        checkForUniqueParameter(map, "x");
        checkForUniqueParameter(map, "y"); 
        checkForUniqueParameter(map, "r");
   }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpUtils httpUtils = new HttpUtils();
        try {
            checkRequestForPointData(request);
            httpUtils.forward(request, response, "/checker");
        } catch (RequestException e) {
            httpUtils.forwardToError(request, response, HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
        }
    }

}
