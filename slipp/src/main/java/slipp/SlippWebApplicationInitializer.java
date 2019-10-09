package slipp;

import nextstep.mvc.DispatcherServlet;
import nextstep.mvc.HandlerMapping;
import nextstep.mvc.asis.ControllerHandlerAdapter;
import nextstep.mvc.tobe.AnnotationHandlerMapping;
import nextstep.mvc.tobe.HandlerAdapter;
import nextstep.mvc.tobe.HandlerExecutionHandlerAdapter;
import nextstep.mvc.tobe.view.JspViewResolver;
import nextstep.mvc.tobe.view.ViewResolver;
import nextstep.web.WebApplicationInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import java.util.ArrayList;
import java.util.List;

public class SlippWebApplicationInitializer implements WebApplicationInitializer {
    private static final Logger log = LoggerFactory.getLogger(SlippWebApplicationInitializer.class);

    @Override
    public void onStartup(ServletContext servletContext) {
        List<HandlerMapping> handlerMappings = new ArrayList<>();
        handlerMappings.add(new AnnotationHandlerMapping("slipp.controller"));
        handlerMappings.add(new ManualHandlerMapping());

        List<HandlerAdapter> handlerAdapters = new ArrayList<>();
        handlerAdapters.add(new HandlerExecutionHandlerAdapter());
        handlerAdapters.add(new ControllerHandlerAdapter());

        List<ViewResolver> viewResolvers = new ArrayList<>();
        viewResolvers.add(new JspViewResolver());

        DispatcherServlet dispatcherServlet = new DispatcherServlet(handlerMappings, handlerAdapters, viewResolvers);

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", dispatcherServlet);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

        log.info("Start MyWebApplication Initializer");
    }
}