package me.r3tnu.lab2.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import me.r3tnu.lab2.utils.HttpUtils;

public class ResourcesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpUtils httpUtils = new HttpUtils();
        String uri = request.getRequestURI();
        String resourcePath = uri.substring(uri.indexOf("resources/") + "resources/".length());

        getServletContext().log(resourcePath);

        try (InputStream resourceStream = getClass().getClassLoader().getResourceAsStream(resourcePath)) {
            if (!Objects.isNull(resourceStream)) {
                resourceStream.transferTo(response.getOutputStream());
            } else {
                httpUtils.forwardToError(request, response, HttpServletResponse.SC_NOT_FOUND, "Resource \"%s\" not found".formatted(resourcePath));
            }
        }
    }
}
