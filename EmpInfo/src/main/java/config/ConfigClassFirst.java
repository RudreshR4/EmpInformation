package config;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import entities.EmpEn;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"src.main.java.*","src.main.java.controller"})
public class ConfigClassFirst {
static {
	System.out.println("ConfigClass loaded");
}	

	@Bean(name="multipartResolver") 
    public CommonsMultipartResolver getResolver() throws IOException{
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        //Set the maximum allowed size (in bytes) for each individual file.
        resolver.setMaxUploadSizePerFile(5242880);//5MB
        //You may also set other available properties.
        return resolver;
    }

@Bean("sfactory")
public LocalSessionFactoryBean getSFactory() {
LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
sf.setPackagesToScan(new String[] {"src.main.java.config.*"});
sf.setHibernateProperties(getHProperties());
sf.setDataSource(getDataSource());
sf.setAnnotatedClasses(EmpEn.class);
return sf;
}

public Properties getHProperties() {
System.out.println("Inside Hibernate properties");
Properties prt = new Properties();
prt.put(Environment.DIALECT,"org.hibernate.dialect.MySQL57Dialect");
prt.put(Environment.HBM2DDL_AUTO,"update");
prt.put(Environment.SHOW_SQL,"true");
return prt;
}

@Bean
public BasicDataSource getDataSource() {
BasicDataSource bds = new BasicDataSource();
bds.setUrl("jdbc:mysql://localhost:3306/emp_info");
bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
bds.setUsername("root");
bds.setPassword("Mysql@007");
return bds;
}

@Bean
public ViewResolver getViewResolver() {
InternalResourceViewResolver irvr = new InternalResourceViewResolver();
irvr.setViewClass(JstlView.class);
irvr.setPrefix("/WEB-INF/view/");
irvr.setSuffix(".jsp");
return irvr;
}
}
