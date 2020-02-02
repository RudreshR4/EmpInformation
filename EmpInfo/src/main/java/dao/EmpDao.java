package dao;

import java.util.List;

import entities.EmpEn;

public interface EmpDao {
public String insertEmp(EmpEn entity);
public List<EmpEn> fetchEmps();
public EmpEn fetchEmp(int empId);
public EmpEn modifyEmp(EmpEn empen);
public String deleteEmp(int empId);
}
