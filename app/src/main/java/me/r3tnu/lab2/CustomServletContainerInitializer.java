package me.r3tnu.lab2;

import java.util.*;
import jakarta.servlet.*;
import me.r3tnu.lab2.point.*;
import me.r3tnu.lab2.point.interfaces.*;
import me.r3tnu.lab2.servlets.*;
import me.r3tnu.lab2.servlets.ResourcesServlet;

public class CustomServletContainerInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext context) {
        System.out.println("onStartup method called");

        context.addJspFile("indexJsp", "/jsp/index.jsp").addMapping("/");
        context.addJspFile("resultJsp", "/jsp/result.jsp").addMapping("/result");
        context.addJspFile("errorJsp", "/jsp/error.jsp").addMapping("/error");

        PointValidator pointValidator = new PointValidatorLab2();
        PointChecker pointChecker = new PointCheckerLab2();

        AreaCheckServlet areaCheckServlet = new AreaCheckServlet(pointChecker, pointValidator);
        context.addServlet("checkServlet",  areaCheckServlet).addMapping("/checker");
        ControllerServlet controllerServlet = new ControllerServlet();
        context.addServlet("controllerServlet", controllerServlet).addMapping("/controller");
        ResourcesServlet resourcesServlet = new ResourcesServlet();
        context.addServlet("resourcesServlet", resourcesServlet).addMapping("/resources");
    }
}