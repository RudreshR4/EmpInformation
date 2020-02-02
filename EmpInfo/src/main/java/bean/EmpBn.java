package bean;

import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

public class EmpBn {
private int empId;
private String empName;
private double empSalary;
private int empAge;
private String empCity;
private String empGen;
private String[] empSkills;
private MultipartFile file;

public EmpBn() {
	super();
	// TODO Auto-generated constructor stub
}

public EmpBn(int empId, String empName, double empSalary, int empAge, String empCity, String empGen) {
	super();
	this.empId = empId;
	this.empName = empName;
	this.empSalary = empSalary;
	this.empAge = empAge;
	this.empCity = empCity;
	this.empGen = empGen;
	//this.empSkills = empSkills;
	//this.file = file;
}

public int getEmpId() {
	return empId;
}

public void setEmpId(int empId) {
	this.empId = empId;
}

public String getEmpName() {
	return empName;
}

public void setEmpName(String empName) {
	this.empName = empName;
}

public double getEmpSalary() {
	return empSalary;
}

public void setEmpSalary(double empSalary) {
	this.empSalary = empSalary;
}

public int getEmpAge() {
	return empAge;
}

public void setEmpAge(int empAge) {
	this.empAge = empAge;
}

public String getEmpCity() {
	return empCity;
}

public void setEmpCity(String empCity) {
	this.empCity = empCity;
}

public String getEmpGen() {
	return empGen;
}

public void setEmpGen(String empGen) {
	this.empGen = empGen;
}

public String[] getEmpSkills() {
	return empSkills;
}

public void setEmpSkills(String[] empSkills) {
	this.empSkills = empSkills;
}

public MultipartFile getFile() {
	return file;
}

public void setFile(MultipartFile file) {
	this.file = file;
}

@Override
public String toString() {
	return "EmpBn [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + ", empAge=" + empAge
			+ ", empCity=" + empCity + ", empGen=" + empGen + ", empSkills=" + Arrays.toString(empSkills) + ", file="
			+ file + "]";
}


}
