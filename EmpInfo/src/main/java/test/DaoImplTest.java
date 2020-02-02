package test;

//import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigClassFirst;
import dao.EmpDao;
import dao.EmpDaoImpl;
import entities.EmpEn;

public class DaoImplTest {
public static void main(String[] args) {
	AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(ConfigClassFirst.class,EmpDaoImpl.class);
	EmpEn entity = new EmpEn(346, "Harish",12398, 32,"Mumbai");
	EmpDao edi = app.getBean(EmpDaoImpl.class);
	String str = edi.insertEmp(entity);
	System.out.println(str);
}

}
