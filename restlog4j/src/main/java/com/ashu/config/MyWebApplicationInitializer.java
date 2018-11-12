//package com.ashu.config;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletRegistration;
//
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.servlet.DispatcherServlet;
//
//public class MyWebApplicationInitializer implements WebApplicationInitializer {
//
//    public void onStartup(ServletContext container) {
//        ServletRegistration.Dynamic registration = container.addServlet("spring", new DispatcherServlet());
//        registration.setLoadOnStartup(1);
//        registration.addMapping("/*");
//    }
//    
//    
//
//}