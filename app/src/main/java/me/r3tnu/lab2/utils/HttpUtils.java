package me.r3tnu.lab2.utils;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class HttpUtils {
    public void forwardToError(HttpServletRequest request, HttpServletResponse response, int sc_code, String message) throws ServletException, IOException {
        response.setStatus(sc_code);
        request.setAttribute("error", message);
        request.getServletContext().getRequestDispatcher("/error").forward(request, response);
    }

    public void forward(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher(path).forward(request, response);
    }
}
