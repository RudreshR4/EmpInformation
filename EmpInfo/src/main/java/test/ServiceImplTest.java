package test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bean.EmpBn;
import config.ConfigClassFirst;
import dao.EmpDaoImpl;
import services.EmpServiceImpl;

public class ServiceImplTest {
public static void main(String[] args) {
	AnnotationConfigApplicationContext count = new AnnotationConfigApplicationContext(ConfigClassFirst.class,EmpServiceImpl.class,EmpDaoImpl.class);
	EmpBn bean = new EmpBn(4352,"Ganesh",15423,40,"Nashik","");
	EmpServiceImpl service =count.getBean(EmpServiceImpl.class);
	//String str = service.addEmp(bean);        //Add Employee
	//System.out.println(str);
	//String strSecond = service.deleteEmp(345);      //Delete Employee
	//System.out.println(strSecond);
	 EmpBn result = service.updateEmp(bean);          //Update Employee -by age
	 System.out.println(result);
}
}
