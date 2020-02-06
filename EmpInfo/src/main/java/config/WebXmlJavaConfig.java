package config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import controller.EmpController;
import dao.EmpDaoImpl;
import services.EmpServiceImpl;

@Configuration
@ComponentScan(basePackages = {"src.main.java.*"})
public class WebXmlJavaConfig implements WebApplicationInitializer{
	static {
		System.out.println("Webxml loaded");
	}

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		AnnotationConfigWebApplicationContext ctx  = new AnnotationConfigWebApplicationContext();
		ctx.register(ConfigClassFirst.class);
		ctx.register(EmpController.class);
		ctx.register(EmpServiceImpl.class);
		ctx.register(EmpDaoImpl.class);
		ctx.setServletContext(container);
		ServletRegistration.Dynamic servlet = container.addServlet("dispatcher",new DispatcherServlet(ctx));
		servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
		//servlet.setRunAsRole("empInfo");
	}

}
