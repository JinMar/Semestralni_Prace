package tul.ppj.configuration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import tul.ppj.PpjApplication;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * Created by Marek on 02.05.2016.
 */
public class MyWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();


        rootContext.register(PpjApplication.class);
        container.addListener(new ContextLoaderListener(rootContext));
        // Vytvoření dispečeru pro spring contextCreate the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
        dispatcherServlet.register(PpjApplication.class);
        // Zaregistrování a namapovaní servlet dispečeru
        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(dispatcherServlet));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }

}