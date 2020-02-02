package services;

import java.util.List;

import bean.EmpBn;

public interface EmpService {
public String addEmp(EmpBn bean);
public List<EmpBn> getEmps();
public EmpBn getEmp(int EmpId);
public EmpBn updateEmp(EmpBn bean);
public String deleteEmp(int empId);
}
