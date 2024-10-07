package me.r3tnu.lab2.servlets;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import me.r3tnu.lab2.servlets.exceptions.RequestException;
import me.r3tnu.lab2.utils.HttpUtils;

public class ControllerServlet extends HttpServlet {

    private void checkForUniqueParameter(Map<String, String[]> map, String key) throws RequestException{
        if (map.containsKey(key)) {
            if (map.get(key).length == 1) {
                return;
            }
        }
        throw new RequestException("The %s parameter is missing or has duplicates".formatted(key));
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
